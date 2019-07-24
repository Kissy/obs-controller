package fr.kissy.tools.obscontroller.infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.kissy.tools.obscontroller.model.event.ObsEvent;
import fr.kissy.tools.obscontroller.model.request.ObsRequest;
import fr.kissy.tools.obscontroller.model.response.ObsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.net.URI;

/**
 * Created by Guillaume on 04/12/2016.
 */
@Component
@Scope(scopeName = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ObsWebSocketSession extends TextWebSocketHandler implements InitializingBean, DisposableBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(ObsWebSocketSession.class);
    private static final String OBS_WS_URL = "ws://localhost:4444/";
    private ObjectMapper objectMapper;
    private SimpMessagingTemplate simpMessagingTemplate;
    private WebSocketSession webSocketSession;

    @Autowired
    public ObsWebSocketSession(ObjectMapper objectMapper, SimpMessagingTemplate simpMessagingTemplate) {
        this.objectMapper = objectMapper;
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public void send(ObsRequest obsRequest) {
        if (webSocketSession == null || !webSocketSession.isOpen()) {
            throw new IllegalStateException("Session is not connected");
        }

        try {
            byte[] payload = objectMapper.writeValueAsBytes(obsRequest);
            webSocketSession.sendMessage(new TextMessage(payload));
        } catch (IOException e) {
            LOGGER.error("Error while connecting to obs service", e);
        }
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String data = message.getPayload();

        Object payload;
        if (data.contains("\"update-type\"")) {
            payload = objectMapper.readValue(data, ObsEvent.class);
        } else {
            payload = objectMapper.readValue(data, ObsResponse.class);
        }
        simpMessagingTemplate.convertAndSend("/topic/obs", payload);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        webSocketSession = new StandardWebSocketClient().doHandshake(this, null, new URI(OBS_WS_URL)).get();
    }

    @Override
    public void destroy() throws Exception {
        if (webSocketSession != null && webSocketSession.isOpen()) {
            webSocketSession.close();
        }
    }
}

package fr.kissy.tools.obscontroller.interfaces;

import fr.kissy.tools.obscontroller.infrastructure.ObsWebSocketSession;
import fr.kissy.tools.obscontroller.model.request.ObsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Controller
public class ObsRelayController {

    private final ObsWebSocketSession obsWebSocketSession;

    @Autowired
    public ObsRelayController(ObsWebSocketSession obsWebSocketSession) {
        this.obsWebSocketSession = obsWebSocketSession;
    }

    @MessageMapping("/obs")
    public void relay(@Payload ObsRequest request) throws Exception {
        obsWebSocketSession.send(request);
    }
}

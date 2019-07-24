package fr.kissy.tools.obscontroller.interfaces;

import fr.kissy.tools.obscontroller.infrastructure.ObsWebSocketSession;
import fr.kissy.tools.obscontroller.model.request.GetVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class EffectController {

    @Autowired
    private ObsWebSocketSession obsWebSocketSession;

    @MessageMapping("/light/enable")
    public void enable() throws Exception {
        System.out.println("ok");
        obsWebSocketSession.send(new GetVersion("GetVersion-1"));
    }

    /*
    @MessageMapping("/light/disable")
    public void disable() {
        PHBridge selectedBridge = PHHueSDK.getInstance().getSelectedBridge();
        PHLightState newState = new PHLightState();
        newState.setHue(0);
        newState.setSaturation(0);
        newState.setBrightness(254);
        selectedBridge.updateLightState(selectedBridge.getResourceCache().getLights().get("4"), newState);
    }
    */
}

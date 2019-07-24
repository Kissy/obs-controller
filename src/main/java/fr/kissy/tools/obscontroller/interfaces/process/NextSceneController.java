package fr.kissy.tools.obscontroller.interfaces.process;

import fr.kissy.tools.obscontroller.model.event.SwitchScenes;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

/**
 * Created by Guillaume on 27/11/2016.
 */
@Controller
public class NextSceneController {

    @MessageMapping("/hello")
    public void onSwitchScenes(SwitchScenes message) throws Exception {
        System.out.println(message);
    }
}

package fr.kissy.tools.obscontroller.model.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Guillaume on 27/11/2016.
 */
public class SwitchScenes extends ObsEvent {

    private final String sceneName;

    @JsonCreator
    public SwitchScenes(@JsonProperty("scene-name") String sceneName) {
        this.sceneName = sceneName;
    }

    public String getSceneName() {
        return sceneName;
    }

}

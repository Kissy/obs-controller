package fr.kissy.tools.obscontroller.model.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by guillaume on 05/12/2016.
 */
public class Scenes extends ObsResponse {
    private final String currentScene;
    private final List<Scene> scenes;

    @JsonCreator
    public Scenes(@JsonProperty("current-scene") String currentScene,
                  @JsonProperty("scenes") List<Scene> scenes) {
        this.currentScene = currentScene;
        this.scenes = scenes;
    }


    public String getCurrentScene() {
        return currentScene;
    }

    public List<Scene> getScenes() {
        return scenes;
    }

}

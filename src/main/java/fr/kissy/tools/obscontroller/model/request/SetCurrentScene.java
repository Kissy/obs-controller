package fr.kissy.tools.obscontroller.model.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.kissy.tools.obscontroller.model.response.Result;

/**
 * Created by Guillaume on 27/11/2016.
 */
public class SetCurrentScene extends ObsRequest {
    private final String sceneName;

    @JsonCreator
    public SetCurrentScene(@JsonProperty("message-id") String messageId,
                           @JsonProperty("scene-name") String sceneName) {
        super(messageId);
        this.sceneName = sceneName;
    }

    @Override
    protected Class getResponseClass() {
        return Result.class;
    }

    public String getSceneName() {
        return sceneName;
    }
}

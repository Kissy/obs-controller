package fr.kissy.tools.obscontroller.model.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by Guillaume on 27/11/2016.
 */
@JsonSubTypes({
        @JsonSubTypes.Type(value = GetCurrentScene.class),
        @JsonSubTypes.Type(value = GetSceneList.class),
        @JsonSubTypes.Type(value = GetStreamingStatus.class),
        @JsonSubTypes.Type(value = GetTransitionList.class),
        @JsonSubTypes.Type(value = GetVersion.class),
        @JsonSubTypes.Type(value = SetCurrentScene.class),
        @JsonSubTypes.Type(value = SetCurrentTransition.class),
        @JsonSubTypes.Type(value = SetSourceRender.class),
        @JsonSubTypes.Type(value = StartStopRecording.class),
        @JsonSubTypes.Type(value = StartStopStreaming.class)
})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "request-type")
public abstract class ObsRequest {
    private final String messageId;

    ObsRequest(String messageId) {
        this.messageId = getResponseClass().getSimpleName() + "-" + messageId;
    }

    public String getMessageId() {
        return messageId;
    }

    protected abstract Class getResponseClass();
}

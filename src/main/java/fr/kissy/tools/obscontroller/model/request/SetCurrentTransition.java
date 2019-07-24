package fr.kissy.tools.obscontroller.model.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.kissy.tools.obscontroller.model.response.Result;

/**
 * Created by Guillaume on 27/11/2016.
 */
public class SetCurrentTransition extends ObsRequest {
    private String transitionName;

    @JsonCreator
    public SetCurrentTransition(@JsonProperty("message-id") String messageId,
                                @JsonProperty("transition-name") String transitionName) {
        super(messageId);
        this.transitionName = transitionName;
    }

    @Override
    protected Class getResponseClass() {
        return Result.class;
    }

    public String getTransitionName() {
        return transitionName;
    }
}

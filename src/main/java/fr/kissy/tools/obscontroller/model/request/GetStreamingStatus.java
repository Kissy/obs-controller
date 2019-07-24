package fr.kissy.tools.obscontroller.model.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.kissy.tools.obscontroller.model.response.Result;
import fr.kissy.tools.obscontroller.model.response.StreamingStatus;

/**
 * Created by Guillaume on 27/11/2016.
 */
public class GetStreamingStatus extends ObsRequest {
    @JsonCreator
    public GetStreamingStatus(@JsonProperty("message-id") String messageId) {
        super(messageId);
    }

    @Override
    protected Class getResponseClass() {
        return StreamingStatus.class;
    }
}

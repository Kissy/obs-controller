package fr.kissy.tools.obscontroller.model.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.kissy.tools.obscontroller.model.response.Version;

/**
 * Created by Guillaume on 27/11/2016.
 */
public class GetVersion extends ObsRequest {
    @JsonCreator
    public GetVersion(@JsonProperty("message-id") String messageId) {
        super(messageId);
    }

    @Override
    protected Class getResponseClass() {
        return Version.class;
    }
}

package fr.kissy.tools.obscontroller.model.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.kissy.tools.obscontroller.model.response.Result;

/**
 * Created by Guillaume on 27/11/2016.
 */
public class SetSourceRender extends ObsRequest {
    private final String source;
    private final boolean render;

    @JsonCreator
    public SetSourceRender(@JsonProperty("message-id") String messageId,
                           @JsonProperty("source") String source,
                           @JsonProperty("render") boolean render) {
        super(messageId);
        this.source = source;
        this.render = render;
    }

    @Override
    protected Class getResponseClass() {
        return Result.class;
    }

    public String getSource() {
        return source;
    }

    public boolean isRender() {
        return render;
    }
}

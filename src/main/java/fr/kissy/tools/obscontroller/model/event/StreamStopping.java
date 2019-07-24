package fr.kissy.tools.obscontroller.model.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Guillaume on 27/11/2016.
 */
public class StreamStopping extends ObsEvent {

    private final boolean previewOnly;

    @JsonCreator
    public StreamStopping(@JsonProperty("preview-only ") boolean previewOnly) {
        this.previewOnly = previewOnly;
    }

    public boolean isPreviewOnly() {
        return previewOnly;
    }

}

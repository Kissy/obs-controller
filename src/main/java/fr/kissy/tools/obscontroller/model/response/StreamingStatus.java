package fr.kissy.tools.obscontroller.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by guillaume on 05/12/2016.
 */
public class StreamingStatus extends ObsResponse {
    private final boolean streaming;
    private final boolean recording;
    private final boolean previewOnly;

    public StreamingStatus(@JsonProperty("streaming") boolean streaming,
                           @JsonProperty("recording") boolean recording,
                           @JsonProperty("preview-only") boolean previewOnly) {
        this.streaming = streaming;
        this.recording = recording;
        this.previewOnly = previewOnly;
    }

    public boolean isStreaming() {
        return streaming;
    }

    public boolean isRecording() {
        return recording;
    }

    public boolean isPreviewOnly() {
        return previewOnly;
    }

}

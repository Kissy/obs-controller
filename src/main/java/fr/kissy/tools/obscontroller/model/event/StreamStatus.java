package fr.kissy.tools.obscontroller.model.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Guillaume on 27/11/2016.
 */
public class StreamStatus extends ObsEvent {
    private final boolean streaming;
    private final boolean recording;
    private final boolean previewnly;
    private final int bytesPerSec;
    private final int kbitsPerSec;
    private final double strain;
    private final double totalStreamTime;
    private final double numTotalFrames;
    private final double numDroppedFrames;
    private final double fps;

    @JsonCreator
    public StreamStatus(@JsonProperty("streaming") boolean streaming,
                        @JsonProperty("recording") boolean recording,
                        @JsonProperty("previewOnly") boolean previewOnly,
                        @JsonProperty("bytesPerSec") int bytesPerSec,
                        @JsonProperty("kbitsPerSec") int kbitsPerSec,
                        @JsonProperty("strain") double strain,
                        @JsonProperty("totalStreamTime") double totalStreamTime,
                        @JsonProperty("numTotalFrames") double numTotalFrames,
                        @JsonProperty("numDroppedFrames") double numDroppedFrames,
                        @JsonProperty("fps") double fps) {
        this.streaming = streaming;
        this.recording = recording;
        this.previewnly = previewOnly;
        this.bytesPerSec = bytesPerSec;
        this.kbitsPerSec = kbitsPerSec;
        this.strain = strain;
        this.totalStreamTime = totalStreamTime;
        this.numTotalFrames = numTotalFrames;
        this.numDroppedFrames = numDroppedFrames;
        this.fps = fps;
    }

    public boolean isStreaming() {
        return streaming;
    }

    public boolean isRecording() {
        return recording;
    }

    public boolean isPreviewnly() {
        return previewnly;
    }

    public int getBytesPerSec() {
        return bytesPerSec;
    }

    public int getKbitsPerSec() {
        return kbitsPerSec;
    }

    public double getStrain() {
        return strain;
    }

    public double getTotalStreamTime() {
        return totalStreamTime;
    }

    public double getNumTotalFrames() {
        return numTotalFrames;
    }

    public double getNumDroppedFrames() {
        return numDroppedFrames;
    }

    public double getFps() {
        return fps;
    }
}

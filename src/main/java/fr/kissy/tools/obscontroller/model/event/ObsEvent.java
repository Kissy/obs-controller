package fr.kissy.tools.obscontroller.model.event;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by Guillaume on 27/11/2016.
 */
@JsonSubTypes({
        @JsonSubTypes.Type(value = Exiting.class),
        @JsonSubTypes.Type(value = RecordingStarted.class),
        @JsonSubTypes.Type(value = RecordingStarting.class),
        @JsonSubTypes.Type(value = RecordingStopped.class),
        @JsonSubTypes.Type(value = RecordingStopping.class),
        @JsonSubTypes.Type(value = ScenesChanged.class),
        @JsonSubTypes.Type(value = StreamStarted.class),
        @JsonSubTypes.Type(value = StreamStarting.class),
        @JsonSubTypes.Type(value = StreamStopped.class),
        @JsonSubTypes.Type(value = StreamStopping.class),
        @JsonSubTypes.Type(value = SwitchScenes.class)
})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "update-type")
public abstract class ObsEvent {

}

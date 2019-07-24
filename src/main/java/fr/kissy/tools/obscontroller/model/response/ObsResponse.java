package fr.kissy.tools.obscontroller.model.response;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
import fr.kissy.tools.obscontroller.model.request.GetVersion;

/**
 * Created by Guillaume on 27/11/2016.
 */
@JsonSubTypes({
        @JsonSubTypes.Type(value = Result.class),
        @JsonSubTypes.Type(value = Scene.class),
        @JsonSubTypes.Type(value = Scenes.class),
        @JsonSubTypes.Type(value = StreamingStatus.class),
        @JsonSubTypes.Type(value = Transitions.class),
        @JsonSubTypes.Type(value = Version.class)
})
@JsonTypeInfo(use = JsonTypeInfo.Id.CUSTOM, property = "message-id")
@JsonTypeIdResolver(ObsResponseTypeIdResolver.class)
public abstract class ObsResponse {
}

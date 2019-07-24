package fr.kissy.tools.obscontroller.model.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by guillaume on 05/12/2016.
 */
public class Scene extends ObsResponse {
    private final String name;
    private final List<Source> sources;

    @JsonCreator
    public Scene(@JsonProperty("name") String name,
                 @JsonProperty("sources") List<Source> sources) {
        this.name = name;
        this.sources = sources;
    }

    public String getName() {
        return name;
    }

    public List<Source> getSources() {
        return sources;
    }

}

package fr.kissy.tools.obscontroller.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by guillaume on 05/12/2016.
 */
public class Transitions extends ObsResponse {
    private final String currentTransition;
    private final List<Transition> transitions;

    public Transitions(@JsonProperty("current-transition") String currentTransition,
                       @JsonProperty("transitions") List<Transition> transitions) {
        this.currentTransition = currentTransition;
        this.transitions = transitions;
    }

    public String getCurrentTransition() {
        return currentTransition;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }

}

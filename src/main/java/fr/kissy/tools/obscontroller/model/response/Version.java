package fr.kissy.tools.obscontroller.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Guillaume on 27/11/2016.
 */
public class Version extends ObsResponse {

    private final Double version;
    private final String obsWebsocketVersion;

    public Version(@JsonProperty("version") Double version,
                   @JsonProperty("obs-websocket-version") String obsWebsocketVersion) {
        this.version = version;
        this.obsWebsocketVersion = obsWebsocketVersion;
    }

    public Double getVersion() {
        return version;
    }

    public String getObsWebsocketVersion() {
        return obsWebsocketVersion;
    }

}

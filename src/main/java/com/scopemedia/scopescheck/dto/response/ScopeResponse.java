package com.scopemedia.scopescheck.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Maikel Rehl on 6/12/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ScopeResponse {

    @JsonProperty("status")
    private String status;

    @JsonProperty("error")
    private String error;

    public ScopeResponse() {

    }

    public String getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }
}

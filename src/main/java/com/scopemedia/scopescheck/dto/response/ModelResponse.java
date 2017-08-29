package com.scopemedia.scopescheck.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.scopemedia.scopescheck.dto.model.Model;

/**
 * Created by maikel on 2017-03-27.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModelResponse extends ScopeResponse {

    @JsonProperty("models")
    private Model[] models;

    public ModelResponse() {
        super();
    }

    /**
     * Returns all prediction models
     * @return {@link Model}
     */
    public Model[] getModels() {
        return models;
    }
}

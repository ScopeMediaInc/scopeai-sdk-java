package com.scopemedia.scopescheck.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.scopemedia.scopescheck.dto.model.Tag;

/**
 * Created by maikel on 2017-03-27.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class PredictionResponse extends ScopeResponse {

    @JsonProperty("tags")
    private Tag[] tags;

    public PredictionResponse() {
        super();
    }

    /**
     * Returns all tags based on the prediction models
     * @return {@link Tag}
     */
    public Tag[] getTags() {
        return tags;
    }
}

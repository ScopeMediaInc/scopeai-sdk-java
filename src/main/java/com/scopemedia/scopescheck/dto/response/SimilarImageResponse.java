package com.scopemedia.scopescheck.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.scopemedia.scopescheck.dto.model.Media;

/**
 * Created by maikel on 2017-03-27.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class SimilarImageResponse extends ScopeResponse {

    @JsonProperty("medias")
    private Media[] medias;

    public SimilarImageResponse() {
        super();
    }

    /**
     * Returns all similar medias
     * @return {@link Media}
     */
    public Media[] getMedias() {
        return medias;
    }
}
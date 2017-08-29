package com.scopemedia.scopescheck.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.scopemedia.scopescheck.dto.model.Media;

/**
 * Created by maikel on 2017-03-27.
 */

/**
 * Return all media files you added to your similar images pool
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddMediaResponse extends ScopeResponse {

    @JsonProperty("medias")
    private Media[] medias;

    public AddMediaResponse() {
    }

    /**
     * Array of Medias you added to your similar images pool
     * @return Array of Medias you added to your similar images pool. See {@link com.scopemedia.scopescheck.dto.model.Media}
     */
    public Media[] getMedias() {
        return medias;
    }
}

package com.scopemedia.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.scopemedia.api.dto.Media;

/**
 * Created by maikel on 2017-03-27.
 */

/**
 * Returns all media files you added to your similar images pool
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MediaResponse extends ScopeResponse {

    @JsonProperty("medias")
    private Media[] medias;

    public static MediaResponse newInstance(){
    		return new MediaResponse();
    	}

    public MediaResponse() {
    }

    /**
     * Array of Medias you added to your similar images pool
     * @return Array of Medias you added to your similar images pool. See {@link Media}
     */
    public Media[] getMedias() {
        return medias;
    }
}

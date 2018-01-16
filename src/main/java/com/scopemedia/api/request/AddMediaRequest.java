package com.scopemedia.api.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.scopemedia.api.dto.Media;

/**
 * Created by maikel on 2017-03-27.
 */

/**
 * Create a request to upload new media files to your similar images pool
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddMediaRequest extends ScopeRequest {

    @JsonProperty("medias")
    private Media[] medias;

    public AddMediaRequest() {
    }

    /**
     * Array of Medias to add to your similar images pool
     * @param medias List of new medias. See {@link com.scopemedia.api.dto.Media}
     */
    public AddMediaRequest(Media[] medias) {
        this.medias = medias;
    }

    /**
     * Array of Medias to add to your similar images pool
     * @param medias List of new medias. See {@link com.scopemedia.api.dto.Media}
     * @return AddMediaRequest
     */
    public AddMediaRequest setMedias(Media[] medias) {
        this.medias = medias;
        return this;
    }

    @Override
    public boolean checkAllRequired() {
        return medias != null;
    }
}

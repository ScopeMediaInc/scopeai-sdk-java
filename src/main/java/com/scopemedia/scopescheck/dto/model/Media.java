package com.scopemedia.scopescheck.dto.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Maikel Rehl on 6/12/2017.
 */

public class Media {

    @JsonProperty("mediaId")
    private long id;

    @JsonProperty("mediaUrl")
    private String url;

    public Media() {
    }

    public Media setId(long id) {
        this.id = id;
        return this;
    }

    public Media setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     *
     * @return mediaID
     */
    public long getId() {
        return id;
    }

    /**
     *
     * @return media URL
     */
    public String getUrl() {
        return url;
    }
}

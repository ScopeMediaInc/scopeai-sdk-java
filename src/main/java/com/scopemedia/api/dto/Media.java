package com.scopemedia.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Maikel Rehl on 6/12/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Media {

    @JsonProperty("mediaId")
    private Long id;

    @JsonProperty("mediaUrl")
    private String url;

    @JsonProperty("mediaThumbnail")
    private String thumbnail;
    
    public Media() {
    }

    public Media setId(Long id) {
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
    public Long getId() {
        return id;
    }

    /**
     *
     * @return media URL
     */
    public String getUrl() {
        return url;
    }

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	@Override
	public String toString() {
		return "Media [id=" + id + ", url=" + url + ", thumbnail=" + thumbnail + "]";
	}
}

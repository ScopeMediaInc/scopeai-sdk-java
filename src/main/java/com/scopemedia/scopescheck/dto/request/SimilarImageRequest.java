package com.scopemedia.scopescheck.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.scopemedia.scopescheck.Utils;
import com.scopemedia.scopescheck.dto.model.Area;

/**
 * Created by maikel on 2017-03-27.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SimilarImageRequest extends ScopeRequest {

    @JsonProperty("base64")
    private String base64;

    @JsonProperty("mediaId")
    private long mediaId;

    @JsonProperty("mediaUrl")
    private String mediaUrl;

    @JsonProperty("modelId")
    private String appId;

    @JsonProperty("area")
    private Area area;

    public SimilarImageRequest() {
    }

    /**
     * Media as ID, Bitmap, Base64 or as URL is required
     * @param id Media ID
     * @return PredictionRequest
     */
    public SimilarImageRequest setMediaId(long id) {
        this.mediaId = id;
        return this;
    }

    /**
     * Media as ID, Bitmap, Base64 or as URL is required
     * @param bitmap encoded media
     * @return SimilarImageRequest
     */
//    public SimilarImageRequest setMediaAsBitmap(Bitmap bitmap) {
//        this.base64 = Utils.bitmap2base64(bitmap);
//        return this;
//    }

    /**
     * Media as ID, Bitmap, Base64 or as URL is required
     * @param base64 encoded media
     * @return SimilarImageRequest
     */
    public SimilarImageRequest setMediaAsBase64(String base64) {
        this.base64 = base64;
        return this;
    }

    /**
     * Media as ID, Bitmap, Base64 or as URL is required
     * @param url media URL
     * @return SimilarImageRequest
     */
    public SimilarImageRequest setMediaAsUrl(String url) {
        this.mediaUrl = url;
        return this;
    }

    /**
     * @param appId app ID use for similar images.
     * @return SimilarImageRequest
     */
    public SimilarImageRequest setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    /**
     * Set an area which will be used for the similar images
     * @param area Area will be used for the similar images. See {@link com.scopemedia.scopescheck.dto.model.Area}
     * @return SimilarImageRequest
     */
    public SimilarImageRequest setArea(Area area) {
        this.area = area;
        return this;
    }

    @Override
    public boolean checkAllRequired() {
        return mediaId != 0.0 || mediaUrl != null || base64 != null;
    }
}

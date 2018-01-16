package com.scopemedia.api.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.scopemedia.api.dto.Area;

/**
 * Created by maikel on 2017-03-27.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PredictionRequest extends ScopeRequest {

    @JsonProperty("base64")
    private String base64;

    @JsonProperty("mediaUrl")
    private String mediaUrl;

    @JsonProperty("modelId")
    private String modelId;

    @JsonProperty("area")
    private Area area;

    public PredictionRequest() {
    }

    /**
     * Media as Base64, Bitmap or as URL is required
     * @param bitmap media
     * @return PredictionRequest
     */
//    public PredictionRequest setMediaAsBitmap(Bitmap bitmap) {
//        this.base64 = Utils.bitmap2base64(bitmap);
//        return this;
//    }

    /**
     * Media as Base64, Bitmap or as URL is required
     * @param base64 encoded media
     * @return PredictionRequest
     */
    public PredictionRequest setMediaAsBase64(String base64) {
        this.base64 = base64;
        return this;
    }

    /**
     * Media as Base64, Bitmap or as URL is required
     * @param url media URL
     * @return PredictionRequest
     */
    public PredictionRequest setMediaAsUrl(String url) {
        this.mediaUrl = url;
        return this;
    }

    /**
     * Image as Base64 or as URl is required
     * @param modelId modelId ID use for prediction. See {@link com.scopemedia.api.dto.Model}
     * @return PredictionRequest
     */
    public PredictionRequest setModelId(String modelId) {
        this.modelId = modelId;
        return this;
    }

    /**
     * Set an area which will be used for the prediction
     * @param area Area will be use for the prediction. See {@link com.scopemedia.api.dto.Area}
     * @return PredictionRequest
     */
    public PredictionRequest setArea(Area area) {
        this.area = area;
        return this;
    }

    @Override
    public boolean checkAllRequired() {
        return (mediaUrl != null || base64 != null) && modelId != null;
    }
}

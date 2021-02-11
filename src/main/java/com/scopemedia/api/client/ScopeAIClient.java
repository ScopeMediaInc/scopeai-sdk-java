package com.scopemedia.api.client;

import com.scopemedia.api.client.ScopeAIClientImpl.RequestBuilder;
import com.scopemedia.api.request.AddMediaRequest;
import com.scopemedia.api.request.PredictionRequest;
import com.scopemedia.api.request.SimilarImageRequest;
import com.scopemedia.api.response.MediaResponse;
import com.scopemedia.api.response.ModelResponse;
import com.scopemedia.api.response.PredictionResponse;

/**
 * Created by maikel on 2017-03-27.
 */

public interface ScopeAIClient {
    /**
     * Returns all media files form your similar images pool
     * @param page
     * @param size
     * @return {@link MediaResponse}
     */
    RequestBuilder<MediaResponse> getMedias(int page, int size);

    /**
     * Create a request to upload new media files to your similar images pool
     * Returns all media files you added to your similar images pool
     * @param request {@link AddMediaRequest}
     * @return {@link AddMediaResponse}
     */
    RequestBuilder<MediaResponse> addMedias(AddMediaRequest request);

    /**
     * returns similar images based on an input image
     * @param request {@link SimilarImageRequest}
     * @return {@link SimilarImageResponse}
     */
    RequestBuilder<MediaResponse> getSimilarImages(SimilarImageRequest request);

    /**
     * returns predictions based on an input image
     * @param request {@link PredictionRequest}
     * @return {@link PredictionResponse}
     */
    RequestBuilder<PredictionResponse> getPrediction(PredictionRequest request);

    /**
     * returns all prediction models including public and private models of the user
     * @return {@link ModelResponse}
     */
    RequestBuilder<ModelResponse> getModels();
}
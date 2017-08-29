package com.scopemedia.scopescheck.client;

import com.scopemedia.scopescheck.client.ScopeCheckClientImpl.RequestBuilder;
import com.scopemedia.scopescheck.dto.request.AddMediaRequest;
import com.scopemedia.scopescheck.dto.request.PredictionRequest;
import com.scopemedia.scopescheck.dto.request.SimilarImageRequest;

import com.scopemedia.scopescheck.dto.response.AddMediaResponse;
import com.scopemedia.scopescheck.dto.response.GetMediaResponse;
import com.scopemedia.scopescheck.dto.response.ModelResponse;
import com.scopemedia.scopescheck.dto.response.PredictionResponse;
import com.scopemedia.scopescheck.dto.response.SimilarImageResponse;

/**
 * Created by maikel on 2017-03-27.
 */

public interface ScopeCheckClient {
    /**
     * Returns all media files form your similar images pool
     * @param page
     * @param size
     * @return {@link GetMediaResponse}
     */
    RequestBuilder<GetMediaResponse> getMedias(int page, int size);

    /**
     * Create a request to upload new media files to your similar images pool
     * Returns all media files you added to your similar images pool
     * @param request {@link AddMediaRequest}
     * @return {@link AddMediaResponse}
     */
    RequestBuilder<AddMediaResponse> addMedias(AddMediaRequest request);

    /**
     * returns similar images based on an input image
     * @param request {@link SimilarImageRequest}
     * @return {@link SimilarImageResponse}
     */
    RequestBuilder<SimilarImageResponse> getSimilarImages(SimilarImageRequest request);

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
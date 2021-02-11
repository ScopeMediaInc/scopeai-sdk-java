package com.scopemedia.api.client;

import com.scopemedia.api.request.AddMediaRequest;
import com.scopemedia.api.request.PredictionRequest;
import com.scopemedia.api.request.SimilarImageRequest;
import com.scopemedia.api.response.MediaResponse;
import com.scopemedia.api.response.ModelResponse;
import com.scopemedia.api.response.PredictionResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by maikel on 2017-03-27.
 */

interface ScopeAIService {

    @GET("simile/v2/medias")
    Call<MediaResponse> getMedias(@Query("page") int page, @Query("size") int size);

    @POST("simile/v2/medias")
    Call<MediaResponse> addMedias(@Body AddMediaRequest request);

    @POST("simile/v2/search")
    Call<MediaResponse> getSimilarImages(@Body SimilarImageRequest request);

    @POST("tag/v2/tagging")
    Call<PredictionResponse> getPrediction(@Body PredictionRequest request);

    @GET("tag/v2/models")
    Call<ModelResponse> getModels();
}
package com.scopemedia.scopescheck.client;

import com.scopemedia.scopescheck.dto.request.AddMediaRequest;
import com.scopemedia.scopescheck.dto.request.PredictionRequest;
import com.scopemedia.scopescheck.dto.request.SimilarImageRequest;
import com.scopemedia.scopescheck.dto.response.AddMediaResponse;
import com.scopemedia.scopescheck.dto.response.GetMediaResponse;
import com.scopemedia.scopescheck.dto.response.ModelResponse;
import com.scopemedia.scopescheck.dto.response.PredictionResponse;
import com.scopemedia.scopescheck.dto.response.SimilarImageResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by maikel on 2017-03-27.
 */

interface ScopeCheckService {

    @GET("search/v2/medias")
    Call<GetMediaResponse> getMedias(@Query("page") int page, @Query("size") int size);

    @POST("search/v2/medias")
    Call<AddMediaResponse> addMedias(@Body AddMediaRequest request);

    @POST("search/v2/similar")
    Call<SimilarImageResponse> getSimilarImages(@Body SimilarImageRequest request);

    @POST("tagging/v2/prediction")
    Call<PredictionResponse> getPrediction(@Body PredictionRequest request);

    @GET("tagging/v2/models")
    Call<ModelResponse> getModels();
}
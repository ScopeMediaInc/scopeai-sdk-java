package com.scopemedia.api.client;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scopemedia.api.exception.ScopeMissingArgumentException;
import com.scopemedia.api.request.AddMediaRequest;
import com.scopemedia.api.request.PredictionRequest;
import com.scopemedia.api.request.SimilarImageRequest;
import com.scopemedia.api.response.MediaResponse;
import com.scopemedia.api.response.ModelResponse;
import com.scopemedia.api.response.PredictionResponse;
import com.scopemedia.api.response.ScopeResponse;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by maikel on 2017-03-27.
 */

class ScopeCheckClientImpl implements ScopeCheckClient {
	@JsonIgnoreProperties(ignoreUnknown = true)
	public class ScopeError {
		private int status;
		private String code;
		private String message;
		private String detail;
		private String uri;
		private String fieldErrors;
		
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getDetail() {
			return detail;
		}
		public void setDetail(String detail) {
			this.detail = detail;
		}
		public String getUri() {
			return uri;
		}
		public void setUri(String uri) {
			this.uri = uri;
		}
		public String getFieldErrors() {
			return fieldErrors;
		}
		public void setFieldErrors(String fieldErrors) {
			this.fieldErrors = fieldErrors;
		}	
	}

    private ScopeCheckService service;

    /**
     *  Use by {@link ScopeCheckBuilder} to initialise a new {@link ScopeCheckClient}
     * @param builder {@link ScopeCheckBuilder}
     */
    protected ScopeCheckClientImpl(ScopeCheckBuilder builder) {

        final String clientId = builder.getClientId();
        final String clientSecret = builder.getClientSecret();

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                // Request customization: add request headers
                Request.Builder requestBuilder = original.newBuilder()
                        .addHeader("Client-Id", clientId)
                        .addHeader("Client-Secret", clientSecret);

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });

        if (builder.getDebugMode()) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(builder.getDebugLevel());
            httpClient.addInterceptor(loggingInterceptor);
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(builder.getBaseUrl())
                .client(httpClient.build())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        this.service = retrofit.create(ScopeCheckService.class);
    }

    @Override
    public RequestBuilder<MediaResponse> getMedias(int page, int size) {
        return new RequestBuilder<>(service.getMedias(page, size), MediaResponse.class);
    }

    @Override
    public RequestBuilder<MediaResponse> addMedias(AddMediaRequest request) {
        if (!request.checkAllRequired()) throw new ScopeMissingArgumentException("Please set a media array");
        return new RequestBuilder<>(service.addMedias(request), MediaResponse.class);
    }

    @Override
    public RequestBuilder<MediaResponse> getSimilarImages(SimilarImageRequest request) {
        if (!request.checkAllRequired()) throw new ScopeMissingArgumentException("Please set a mediaId or mediaUrl or base64");
        return new RequestBuilder<>(service.getSimilarImages(request), MediaResponse.class);
    }

    @Override
    public RequestBuilder<PredictionResponse> getPrediction(PredictionRequest request) {
        if (!request.checkAllRequired()) throw new ScopeMissingArgumentException("Please set a (mediaUrl or base64) and a modelId");
        return new RequestBuilder<>(service.getPrediction(request), PredictionResponse.class);
    }

    @Override
    public RequestBuilder<ModelResponse> getModels() {
        return new RequestBuilder<>(service.getModels(), ModelResponse.class);
    }

    /**
     * RequestBuilder class for all response classes extends {@link ScopeResponse}
     * @param <T> extends {@link ScopeResponse}
     */
    public static class RequestBuilder<T extends ScopeResponse> {
        private Call<T> call;
        private Class<T> clazz;

        /**
         * Create a new Request
         * @param call set the {@link Call} for any response class which extends {@link ScopeResponse}
         */
        private RequestBuilder(Call<T> call, Class<T> clazz) {
            this.call = call;
            this.clazz = clazz;
        }

        /**
         * Perform request synchronous
         * @return Response object extends {@link ScopeResponse}
         * @throws IOException
         */
        public T performSync() throws IOException {
            return performCallSync(call);
        }

        /**
         * Perform OkHttp call synchronous
         * @param call {@link Call}
         * @return Response object extends {@link ScopeResponse}
         * @throws IOException
         */
        private T performCallSync(Call<T> call) throws IOException {
            Response<T> response = call.execute();
            if (response != null && response.isSuccessful()) {
            		T t = response.body();
            		t.setCode(response.code());
            		t.setMessage(response.message());
            		return t;
            } else {
            		try {
					T t = clazz.newInstance();
					t.setCode(response.code());
					t.setMessage(response.message());
					String text = response.errorBody().string();
					ScopeError error = convertToObject(text);
					if (error != null) {
						t.setCode(error.getStatus());
						t.setMessage(error.getCode());
					}
					return t;
				} catch (InstantiationException | IllegalAccessException e) {
					return null;
				}
            }
        }

		public static ScopeError convertToObject(String jsonStr) {
			if (jsonStr == null)
				return null;
			ObjectMapper mapper = new ObjectMapper();
			try {
				return mapper.readValue(jsonStr, ScopeError.class);
			} catch (IOException e) {
				//logger.error(e.getMessage());
			}
			return null;
		}
    }
}
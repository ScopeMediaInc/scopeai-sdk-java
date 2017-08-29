package com.scopemedia.scopescheck;

import com.scopemedia.scopescheck.client.ScopeCheckBuilder;
import com.scopemedia.scopescheck.client.ScopeCheckClient;
import com.scopemedia.scopescheck.dto.model.Area;
import com.scopemedia.scopescheck.dto.model.Media;
import com.scopemedia.scopescheck.dto.model.Model;
import com.scopemedia.scopescheck.dto.model.Tag;
import com.scopemedia.scopescheck.dto.request.PredictionRequest;
import com.scopemedia.scopescheck.dto.request.SimilarImageRequest;
import com.scopemedia.scopescheck.dto.response.GetMediaResponse;
import com.scopemedia.scopescheck.dto.response.ModelResponse;
import com.scopemedia.scopescheck.dto.response.PredictionResponse;
import com.scopemedia.scopescheck.dto.response.SimilarImageResponse;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author Maikel Rehl on 6/8/2017.
 */

public class ApiTest {

    private static final String CLIENT_ID = "demo";
    private static final String CLIENT_SECRET = "demotestsecret";
    private ScopeCheckClient client;

    private Area area = new Area(320, 520, 340, 750);
    private String imageUrl = "https://cdn-images.farfetch-contents.com/11/84/74/89/11847489_8709666_1000.jpg";

    @Before
    public void init() {
        client = new ScopeCheckBuilder(CLIENT_ID, CLIENT_SECRET)
                .setDebugMode(true)
                .setDebugLevel(HttpLoggingInterceptor.Level.BODY)
                .build();
    }

    @Test
    public void getMedias() {
        try {
            GetMediaResponse response = client.getMedias(0,20).performSync();;
            Media[] medias = response.getMedias();
            for (Media media : medias)
                System.out.println(media.getUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getModels() {
        try {
            ModelResponse response = client.getModels().performSync();
            Model[] models = response.getModels();
            for (Model model : models)
                System.out.println(model.getName() + "\tisPublic: " + model.isPublicModel());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getPrediction() {
        PredictionRequest request = new PredictionRequest();
        request.setMediaAsUrl(imageUrl);
        request.setModelId("general-v3");

        try {
            PredictionResponse response = client.getPrediction(request).performSync();
            Tag[] tags = response.getTags();
            for (Tag tag : tags)
                System.out.println(tag.getTag() + ":" + tag.getScore());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getPredictionArea() {
        PredictionRequest request = new PredictionRequest();
        request.setMediaAsUrl(imageUrl);
        request.setArea(area);
        request.setModelId("general-v3");

        try {
            PredictionResponse response = client.getPrediction(request).performSync();
            Tag[] tags = response.getTags();
            for (Tag tag : tags)
                System.out.println(tag.getTag() + ":" + tag.getScore());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getSimilar() {
        SimilarImageRequest request = new SimilarImageRequest();
        request.setMediaAsUrl(imageUrl);
        request.setAppId("fashion");

        try {
            SimilarImageResponse response = client.getSimilarImages(request).performSync();
            Media[] mediaList = response.getMedias();
            for (Media media : mediaList)
                System.out.println(media.getUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getSimilarArea() {
        SimilarImageRequest request = new SimilarImageRequest();
        request.setMediaAsUrl(imageUrl);
        request.setArea(area);
        request.setAppId("fashion");

        try {
            SimilarImageResponse response = client.getSimilarImages(request).performSync();
            Media[] mediaList = response.getMedias();
            for (Media media : mediaList)
                System.out.println(media.getUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

package com.scopemedia.scopescheck;

import org.junit.Before;
import org.junit.Test;

import com.scopemedia.api.ScopeCheckBuilder;
import com.scopemedia.api.ScopeCheckClient;
import com.scopemedia.api.dto.Area;
import com.scopemedia.api.dto.Media;
import com.scopemedia.api.dto.Model;
import com.scopemedia.api.dto.Tag;
import com.scopemedia.api.request.PredictionRequest;
import com.scopemedia.api.request.SimilarImageRequest;
import com.scopemedia.api.response.MediaResponse;
import com.scopemedia.api.response.ModelResponse;
import com.scopemedia.api.response.PredictionResponse;

import org.junit.Assert;

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
            MediaResponse response = client.getMedias(0,20).performSync();
            Assert.assertEquals("OK", response.getStatus());
            Media[] medias = response.getMedias();
            for (Media media : medias)
                System.out.println(media.getUrl());
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void getModels() {
        try {
            ModelResponse response = client.getModels().performSync();
            Assert.assertEquals("OK", response.getStatus());
            Model[] models = response.getModels();
            for (Model model : models)
                System.out.println(model.getName() + "\tisPublic: " + model.isPublicModel());
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void getPrediction() {
        PredictionRequest request = new PredictionRequest();
        request.setMediaAsUrl(imageUrl);
        request.setModelId("general-v3");

        try {
            PredictionResponse response = client.getPrediction(request).performSync();
            Assert.assertEquals("OK", response.getStatus());
            Tag[] tags = response.getTags();
            for (Tag tag : tags)
                System.out.println(tag.getTag() + ":" + tag.getScore());
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();            
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
            Assert.assertEquals("OK", response.getStatus());
            Tag[] tags = response.getTags();
            for (Tag tag : tags)
                System.out.println(tag.getTag() + ":" + tag.getScore());

        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void getSimilar() {
        SimilarImageRequest request = new SimilarImageRequest();
        request.setMediaAsUrl(imageUrl);
        request.setAppId("fashion");

        try {
            MediaResponse response = client.getSimilarImages(request).performSync();
            Assert.assertEquals("OK", response.getStatus());
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
            MediaResponse response = client.getSimilarImages(request).performSync();
            Assert.assertEquals("OK", response.getStatus());
            Media[] mediaList = response.getMedias();
            for (Media media : mediaList)
                System.out.println(media.getUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

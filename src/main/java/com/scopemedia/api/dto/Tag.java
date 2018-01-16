package com.scopemedia.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by maikel on 2017-03-27.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tag {

    @JsonProperty("label")
    private String label;

    @JsonProperty("score")
    private String score;

    public Tag() {
    }

    public Tag setLabel(String label) {
        this.label = label;
        return this;
    }

    public Tag setScore(String score) {
        this.score = score;
        return this;
    }

    public String getTag() {
        return (label == null) ? "" : label.toLowerCase().trim();
    }

    public double getScore() {
        return Double.parseDouble(score);
    }
}
package com.scopemedia.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Maikel Rehl on 6/12/2017.
 */

public class Area {

    @JsonProperty("x")
    private int startX;

    @JsonProperty("y")
    private int startY;

    @JsonProperty("w")
    private int width;

    @JsonProperty("h")
    private int height;

    /**
     * Set an area of an image
     * @param startX start position X
     * @param startY start position Y
     * @param width width
     * @param height height
     */
    public Area(int startX, int startY, int width, int height) {
        this.startX = startX;
        this.startY = startY;
        this.width = width;
        this.height = height;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

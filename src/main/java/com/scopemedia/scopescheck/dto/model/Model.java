package com.scopemedia.scopescheck.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by maikel on 2017-03-27.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Model {

    @JsonProperty("modelId")
    private String id;

    @JsonProperty("creationTime")
    private String creationTime;

    @JsonProperty("description")
    private String description;

    @JsonProperty("modelName")
    private String name;

    @JsonProperty("public")
    private boolean publicModel;

    @JsonProperty("status")
    private String status;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSSZ", Locale.getDefault());

    public Model() {
    }

    public Model setId(String id) {
        this.id = id;
        return this;
    }

    public Model setCreationTime(String creationTime) {
        this.creationTime = creationTime;
        return this;
    }

    public Model setDescription(String description) {
        this.description = description;
        return this;
    }

    public Model setName(String name) {
        this.name = name;
        return this;
    }

    public Model setPublicModel(boolean publicModel) {
        this.publicModel = publicModel;
        return this;
    }

    public Model setStatus(String status) {
        this.status = status;
        return this;
    }

    public Model setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
        return this;
    }

    /**
     *
     * @return modelID
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @return creation date
     */
    public Date getCreationTime() {
        try {
            return dateFormat.parse(creationTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @return description of the model
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return model name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return public model
     */
    public boolean isPublicModel() {
        return publicModel;
    }

    public String getStatus() {
        return status;
    }
}
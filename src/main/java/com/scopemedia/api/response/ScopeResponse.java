package com.scopemedia.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Maikel Rehl on 6/12/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ScopeResponse {

    @JsonProperty("code")
    private int code;

    @JsonProperty("message")
    private String message;
    
    public ScopeResponse() {
    }
    
    public ScopeResponse(int code, String message) {
    		this.code = code;
    		this.message = message;
    }

    public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

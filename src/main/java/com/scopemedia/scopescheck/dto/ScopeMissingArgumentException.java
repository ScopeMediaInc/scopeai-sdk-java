package com.scopemedia.scopescheck.dto;

/**
 * @author Maikel Rehl on 6/22/2017.
 */

public class ScopeMissingArgumentException extends IllegalArgumentException {
    public ScopeMissingArgumentException(String message) {
        super(message);
    }
}

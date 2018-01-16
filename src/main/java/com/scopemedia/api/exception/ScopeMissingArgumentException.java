package com.scopemedia.api.exception;

/**
 * @author Maikel Rehl on 6/22/2017.
 */

public class ScopeMissingArgumentException extends IllegalArgumentException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4238435694799245134L;

	public ScopeMissingArgumentException(String message) {
        super(message);
    }
}

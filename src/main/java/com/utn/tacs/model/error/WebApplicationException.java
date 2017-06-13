package com.utn.tacs.model.error;

/**
 * Created by alalbiero on 6/10/17.
 */
public class WebApplicationException extends RuntimeException {

    private final int statusCode;

    public WebApplicationException(int statusCode, String msg) {
        super(msg);

        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}


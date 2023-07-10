package com.app.server.controllers.exceptions;

import java.time.Instant;

public class StandardError {
    private Instant timestamp;
    private String message;
    private String path;
    private Integer status;
    private String error;

    public StandardError() {
    }

    public StandardError(Instant timestamp, String message, String path, Integer status, String error) {
        this.timestamp = timestamp;
        this.message = message;
        this.path = path;
        this.status = status;
        this.error = error;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}

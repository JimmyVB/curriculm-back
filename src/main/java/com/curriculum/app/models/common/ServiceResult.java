package com.curriculum.app.models.common;

public class ServiceResult {

    private String message;
    private boolean success;
    private Object data;
    private String error;

    public ServiceResult() {
        this.success = true;
    }

    public ServiceResult(String message, boolean success, Object data, String error) {
        this.message = message;
        this.success = success;
        this.data = data;
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}

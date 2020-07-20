package com.iyengarcoders.groceries.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class PingDto {
    private String message;
    private Date timestamp;

    public PingDto(@JsonProperty("message") String message, @JsonProperty("timeStamp") Date timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}

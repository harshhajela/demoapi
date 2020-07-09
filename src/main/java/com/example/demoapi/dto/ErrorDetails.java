package com.example.demoapi.dto;

import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
public class ErrorDetails {
    private int status;
    private Date timestamp;
    private String message;
    private Map<String, String> errors = new HashMap<>();

    public ErrorDetails(Date timestamp, String message, int status) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.status = status;
    }
}

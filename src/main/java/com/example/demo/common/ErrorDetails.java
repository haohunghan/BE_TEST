package com.example.demo.common;

import com.example.demo.infrastructure.ServiceStatus;
import lombok.Data;

import java.util.Date;

@Data
public class ErrorDetails {
    private String status;
    private String message;

    public ErrorDetails(ServiceStatus status, String message) {
        super();
        this.status = status.getCode();
        this.message = message;
    }
}

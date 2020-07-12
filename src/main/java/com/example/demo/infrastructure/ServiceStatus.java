package com.example.demo.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ServiceStatus {
    SUCCESS("200000"),
    BAD_REQUEST("400000"),
    ERROR("500000");

    private final String code;
}

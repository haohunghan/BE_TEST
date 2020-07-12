package com.example.demo.controller.request;

import lombok.Data;

@Data
public class MedicinePostRequest {
    private String id;
    private String name;
    private Integer price;
}

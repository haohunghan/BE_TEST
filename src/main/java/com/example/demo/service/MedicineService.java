package com.example.demo.service;

import com.example.demo.controller.request.MedicinePostRequest;
import com.example.demo.controller.response.MedicinePostResponse;
import com.example.demo.entity.Medicine;

import java.util.List;
import java.util.Optional;

public interface MedicineService {
    List<Medicine> getMedicines();

    Medicine getMedicineById(String id) throws Exception;

    MedicinePostResponse postMedicine(MedicinePostRequest medicine);
}

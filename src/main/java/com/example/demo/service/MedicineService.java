package com.example.demo.service;

import com.example.demo.controller.request.MedicineGetRequest;
import com.example.demo.controller.request.MedicinePostRequest;
import com.example.demo.controller.response.MedicinePostResponse;
import com.example.demo.domain.entity.MedicineEntity;
import com.example.demo.domain.object.Medicine;

import java.util.List;

public interface MedicineService {
    List<Medicine> getMedicines(MedicineGetRequest request) throws Exception;

    MedicineEntity getMedicineById(MedicineGetRequest request) throws Exception;

    MedicinePostResponse postMedicine(MedicinePostRequest medicine);

    List<MedicineEntity> getMedicineList(MedicineGetRequest request) throws Exception;
}

package com.example.demo.service.impl;

import com.example.demo.controller.request.MedicinePostRequest;
import com.example.demo.controller.response.MedicinePostResponse;
import com.example.demo.entity.Medicine;
import com.example.demo.infrastructure.ServiceStatus;
import com.example.demo.repository.MedicineRepository;
import com.example.demo.service.MedicineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepository medicineRepository;

    @Override
    public List<Medicine> getMedicines() {
        try {
            return medicineRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Medicine getMedicineById(String id) throws Exception {
        return medicineRepository.findById(id).orElseThrow(Exception::new);
    }

    @Override
    public MedicinePostResponse postMedicine(MedicinePostRequest request) {
        Medicine medicine = Medicine.builder()
                .id(request.getId())
                .name(request.getName())
                .price(request.getPrice())
                .build();
        try {
            medicineRepository.save(medicine);
            return MedicinePostResponse.builder()
                    .serviceStatus(ServiceStatus.SUCCESS)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


}

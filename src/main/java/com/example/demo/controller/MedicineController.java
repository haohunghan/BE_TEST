package com.example.demo.controller;

import java.util.List;

import com.example.demo.controller.request.MedicinePostRequest;
import com.example.demo.controller.response.MedicinePostResponse;
import com.example.demo.entity.Medicine;
import com.example.demo.service.MedicineService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/medicine")
@AllArgsConstructor
public class MedicineController {

    private final MedicineService medicineService;

    // get all medicines
    @GetMapping
    public List<Medicine> getMedicines() {
        return medicineService.getMedicines();
    }

    // get user by id
    @GetMapping("/{id}")
    public Medicine getMedicine(@PathVariable (value = "id") String id) throws Exception {
        return medicineService.getMedicineById(id);
    }

    // create user
    @PostMapping
    public MedicinePostResponse postMedicine(@RequestBody MedicinePostRequest request) {
        return medicineService.postMedicine(request);
    }
}


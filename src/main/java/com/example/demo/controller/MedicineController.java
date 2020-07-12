package com.example.demo.controller;

import java.util.List;

import com.example.demo.controller.request.MedicineGetRequest;
import com.example.demo.controller.request.MedicinePostRequest;
import com.example.demo.controller.response.MedicineGetResponse;
import com.example.demo.controller.response.MedicinePostResponse;
import com.example.demo.domain.entity.MedicineEntity;
import com.example.demo.domain.object.Medicine;
import com.example.demo.infrastructure.ServiceStatus;
import com.example.demo.service.MedicineService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/v1/medicine")
@AllArgsConstructor
@Api(tags = "users")
public class MedicineController {

    private final MedicineService medicineService;

    // get all medicines
    @GetMapping
    @ApiOperation(value = "API get medicine(s)")
    @ApiResponses(value = {
            @ApiResponse(code = 200000, message = "Success"),
            @ApiResponse(code = 400000, message = "Forbidden"),
            @ApiResponse(code = 500000, message = "Internal error")})
    public MedicineGetResponse getMedicines(MedicineGetRequest request) throws Exception {

        List<Medicine> medicines = medicineService.getMedicines(request);

        return MedicineGetResponse.of(ServiceStatus.SUCCESS, medicines);
    }

    // create medicine
    @PostMapping
    @ApiOperation(value = "API register/update medicine")
    @ApiResponses(value = {
            @ApiResponse(code = 200000, message = "Success"),
            @ApiResponse(code = 400000, message = "Forbidden"),
            @ApiResponse(code = 500000, message = "Internal error")})
    public MedicinePostResponse postMedicine(@RequestBody MedicinePostRequest request) {
        return medicineService.postMedicine(request);
    }
}


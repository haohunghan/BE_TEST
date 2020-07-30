package com.example.demo.controller.request;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
public class MedicineGetRequest {
    @ApiParam("medicine id")
    @Pattern(regexp="^MD_[0-9]{5}$")
    private String id;
}

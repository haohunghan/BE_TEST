package com.example.demo.controller.request;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class MedicineGetRequest {
    @ApiParam("medicine id")
    @NotNull
    @Pattern(regexp="^MD_[0-9]{5}$")
    private String id;
}

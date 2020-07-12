package com.example.demo.controller.request;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
public class MedicinePostRequest {

    @ApiParam("medicine id")
    @Pattern(regexp="^MD_[0-9]{5}$")
    private String id;

    @ApiParam("medicine name")
    private String name;

    @ApiParam("medicine price")
    private Integer price;
}

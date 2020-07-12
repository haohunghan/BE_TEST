package com.example.demo.controller.response;

import com.example.demo.infrastructure.ServiceStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MedicinePostResponse {
    ServiceStatus status;
}

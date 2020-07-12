package com.example.demo.controller.response;

import com.example.demo.infrastructure.ServiceStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MedicinePostResponse {
    ServiceStatus status;
}

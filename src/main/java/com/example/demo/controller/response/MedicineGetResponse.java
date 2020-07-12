package com.example.demo.controller.response;

import com.example.demo.domain.object.Medicine;
import com.example.demo.infrastructure.ServiceStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
public class MedicineGetResponse {
    private String status;
    private Feed feed;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Feed {
        private List<Medicine> entry;
    }

    public static MedicineGetResponse of(ServiceStatus status, List<Medicine> entry) {
        return MedicineGetResponse.builder()
                .status(status.getCode())
                .feed(Feed.builder().entry(entry).build())
                .build();
    }
}

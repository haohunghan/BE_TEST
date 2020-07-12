package com.example.demo.domain.object;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Medicine {
    private String id;
    private String name;
    private Integer price;
}

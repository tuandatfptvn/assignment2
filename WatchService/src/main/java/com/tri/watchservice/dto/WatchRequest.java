package com.tri.watchservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WatchRequest {

    private String brand;

    private Double price;

    private String category;
}

package com.tri.watchservice_se173191.dto;

import com.tri.watchservice_se173191.entity.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WatchRequest {

    private String brand;

    private Double price;

    private String category;
}

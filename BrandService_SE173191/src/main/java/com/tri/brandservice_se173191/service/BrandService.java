package com.tri.brandservice_se173191.service;

import com.tri.brandservice_se173191.entity.Brand;

public interface BrandService {
    Brand getBrandByNameOrElseCreateTheNewOne(String name);
}

package com.tri.brandservice.service;

import com.tri.brandservice.entity.Brand;

public interface BrandService {
    Brand getBrandByNameOrElseCreateTheNewOne(String name);
}

package com.tri.brandservice.service.impl;

import com.tri.brandservice.entity.Brand;
import com.tri.brandservice.repository.BrandRepository;
import com.tri.brandservice.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;


    @Override
    public Brand getBrandByNameOrElseCreateTheNewOne(String name) {
        var brand = brandRepository.findByNameIgnoreCase(name).orElse(
                brandRepository.save(Brand.builder()
                                .name(name)
                        .build()));
        System.out.println(brand.getName());
        return brand;
    }
}

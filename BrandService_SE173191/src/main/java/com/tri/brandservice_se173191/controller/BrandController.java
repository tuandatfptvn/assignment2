package com.tri.brandservice_se173191.controller;

import com.tri.brandservice_se173191.entity.Brand;
import com.tri.brandservice_se173191.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/brands")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping("/{name}")
    public Brand getBrandOrElseCreate(@PathVariable("name") String name){
        return brandService.getBrandByNameOrElseCreateTheNewOne(name);
    }
}

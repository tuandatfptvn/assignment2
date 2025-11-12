package com.tri.brandservice.controller;

import com.tri.brandservice.entity.Brand;
import com.tri.brandservice.service.BrandService;
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

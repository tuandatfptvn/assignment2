package com.tri.watchservice_se173191.httpClient;

import com.tri.watchservice_se173191.dto.Brand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "brand-client", url = "http://localhost:8082")
public interface BrandClient {
    @GetMapping("/api/brands/{name}")
    Brand getBrandOrElseCreate(@PathVariable("name") String name);
}

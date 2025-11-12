package com.tri.watchservice_se173191.service.impl;

import com.tri.watchservice_se173191.dto.Brand;
import com.tri.watchservice_se173191.dto.WatchRequest;
import com.tri.watchservice_se173191.entity.Category;
import com.tri.watchservice_se173191.entity.Watch;
import com.tri.watchservice_se173191.httpClient.BrandClient;
import com.tri.watchservice_se173191.repository.CategoryRepository;
import com.tri.watchservice_se173191.repository.WatchRepository;
import com.tri.watchservice_se173191.service.WatchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class WatchServiceImpl implements WatchService {

    private final WatchRepository watchRepository;
    private final CategoryRepository categoryRepository;
    private final BrandClient brandClient;


    @Override
    public Watch createWatch(WatchRequest request) {
        Brand brand = getBrandFromName(request.getBrand());
        Category category = getCategoryFromName(request.getCategory());
        return watchRepository.save(Watch.builder()
                        .price(request.getPrice())
                        .brand(brand.getName())
                        .category(category)
                .build());
    }

    @Override
    public List<Watch> getAllWatches() {
        return watchRepository.findAll();
    }




    @Override
    public Watch updateWatch(Integer id, WatchRequest request) {
        Brand brand = getBrandFromName(request.getBrand());
        Category category = getCategoryFromName(request.getCategory());
        return watchRepository.findById(id)
                .map(existingWatch -> {
                    existingWatch.setBrand(brand.getName());
                    existingWatch.setPrice(request.getPrice());
                    existingWatch.setCategory(category);
                    return watchRepository.save(existingWatch);
                })
                .orElseThrow(() -> new RuntimeException("Watch not found with id: " + id));
    }

    @Override
    public void deleteWatch(Integer id) {
        log.info("Deleting watch with id: {}", id);
        if (!watchRepository.existsById(id)) {
            throw new RuntimeException("Watch not found with id: " + id);
        }
        watchRepository.deleteById(id);
    }

   private Brand getBrandFromName(String name){
        return brandClient.getBrandOrElseCreate(name);
   }

    private Category getCategoryFromName(String name){
        return categoryRepository.findByNameIgnoreCase(name)
                .orElse(categoryRepository.save(Category.builder().name(name).build()));
    }
}

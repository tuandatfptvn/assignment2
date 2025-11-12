package com.tri.watchservice.configuration;
import com.tri.watchservice.entity.Category;
import com.tri.watchservice.entity.Watch;
import com.tri.watchservice.httpClient.BrandClient;
import com.tri.watchservice.repository.CategoryRepository;
import com.tri.watchservice.repository.WatchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class AppConfig {

    private final BrandClient brandClient;
    private final CategoryRepository categoryRepository;
    private final WatchRepository watchRepository;

    @Bean
    public ApplicationRunner applicationRunner(){
        return args -> {
            brandClient.getBrandOrElseCreate("Rolex");
            brandClient.getBrandOrElseCreate("Omega");
            brandClient.getBrandOrElseCreate("Casio");


            Category luxury = categoryRepository.save(Category.builder().name("Luxury").build());
            Category sport = categoryRepository.save(Category.builder().name("Sport").build());
            Category classic = categoryRepository.save(Category.builder().name("Classic").build());



            Watch watch1 = Watch.builder().brand("Rolex").price(15000.0).category(luxury).build();
            Watch watch2 = Watch.builder().brand("Omega").price(12000.0).category(sport).build();
            Watch watch3 = Watch.builder().brand("Casio").price(150.0).category(classic).build();

            watchRepository.saveAll(List.of(watch1, watch2, watch3));
        };
    }







}

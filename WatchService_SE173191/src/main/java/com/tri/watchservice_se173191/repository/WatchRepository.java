package com.tri.watchservice_se173191.repository;

import com.tri.watchservice_se173191.entity.Watch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WatchRepository extends JpaRepository<Watch, Integer> {
    List<Watch> findByBrandIgnoreCase(String brand);
    List<Watch> findByCategoryId(Integer categoryId);
}

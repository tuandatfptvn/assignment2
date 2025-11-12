package com.tri.watchservice_se173191.controller;

import com.tri.watchservice_se173191.dto.WatchRequest;
import com.tri.watchservice_se173191.entity.Watch;
import com.tri.watchservice_se173191.service.WatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/watches")
@RequiredArgsConstructor
public class WatchController {

    private final WatchService watchService;

    @PostMapping
    public ResponseEntity<Watch> createWatch(@RequestBody WatchRequest watch) {
        Watch createdWatch = watchService.createWatch(watch);
        return new ResponseEntity<>(createdWatch, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<Watch>> getAllWatches() {
        List<Watch> watches = watchService.getAllWatches();
        return ResponseEntity.ok(watches);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Watch> updateWatch(@PathVariable Integer id, @RequestBody WatchRequest watch) {
        try {
            Watch updatedWatch = watchService.updateWatch(id, watch);
            return ResponseEntity.ok(updatedWatch);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWatch(@PathVariable Integer id) {
        try {
            watchService.deleteWatch(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}

package com.duck.airline.controller;

import com.duck.airline.model.PhanCong;
import com.duck.airline.service.PhanCongService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/phancong")
public class PhanCongController {
    private final PhanCongService phanCongService;

    public PhanCongController(PhanCongService phanCongService) {
        this.phanCongService = phanCongService;
    }

    @GetMapping
    public ResponseEntity<List<PhanCong>> getAllPhanCongs() {
        List<PhanCong> phanCongs = phanCongService.getAllPhanCong();
        return ResponseEntity.ok(phanCongs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhanCong> getPhanCongById(@PathVariable Long id) {
        Optional<PhanCong> phanCongOptional = phanCongService.getPhanCongById(id);
        return phanCongOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PhanCong> createPhanCong(@RequestBody PhanCong phanCong) {
        PhanCong createdPhanCong = phanCongService.createPhanCong(phanCong);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPhanCong);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhanCong> updatePhanCong(@PathVariable Long id, @RequestBody PhanCong phanCong) {
        phanCong.setId(id);
        PhanCong updatedPhanCong = phanCongService.updatePhanCong(phanCong);
        return ResponseEntity.ok(updatedPhanCong);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhanCongById(@PathVariable Long id) {
        phanCongService.deletePhanCongById(id);
        return ResponseEntity.noContent().build();
    }
}


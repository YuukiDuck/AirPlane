package com.duck.airline.controller;

import com.duck.airline.model.LoaiMayBay;
import com.duck.airline.service.LoaiMayBayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/loaimaybay")
public class LoaiMayBayController {
    private final LoaiMayBayService loaiMayBayService;

    public LoaiMayBayController(LoaiMayBayService loaiMayBayService) {
        this.loaiMayBayService = loaiMayBayService;
    }

    @GetMapping
    public ResponseEntity<List<LoaiMayBay>> getAllLoaiMayBay() {
        List<LoaiMayBay> loaiMayBay = loaiMayBayService.getAllLoaiMayBay();
        return ResponseEntity.ok(loaiMayBay);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoaiMayBay> getLoaiMayBayById(@PathVariable Long id) {
        Optional<LoaiMayBay> userOptional = loaiMayBayService.getLoaiMayBayById(id);
        return userOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LoaiMayBay> createLoaiMayBay(@RequestBody LoaiMayBay loaiMayBay) {
        LoaiMayBay createLoaiMayBay = loaiMayBayService.createLoaiMayBay(loaiMayBay);
        return ResponseEntity.status(HttpStatus.CREATED).body(createLoaiMayBay);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoaiMayBay> updateLoaiMayBay(@PathVariable Long id, @RequestBody LoaiMayBay loaiMayBay) {
        loaiMayBay.setId(id);
        LoaiMayBay updateLoaiMayBay = loaiMayBayService.updateLoaiMayBay(loaiMayBay);
        return ResponseEntity.ok(updateLoaiMayBay);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoaiMayBayById(@PathVariable Long id) {
        loaiMayBayService.deleteLoaiMayBayById(id);
        return ResponseEntity.noContent().build();
    }
}


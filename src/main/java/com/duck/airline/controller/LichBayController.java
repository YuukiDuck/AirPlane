package com.duck.airline.controller;

import com.duck.airline.model.LichBay;
import com.duck.airline.service.LichBayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lichbay")
public class LichBayController {
    private final LichBayService lichBayService;

    public LichBayController(LichBayService lichBayService) {
        this.lichBayService = lichBayService;
    }

    @GetMapping
    public ResponseEntity<List<LichBay>> getAllLichBay() {
        List<LichBay> lichBay = lichBayService.getAllLichBay();
        return ResponseEntity.ok(lichBay);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LichBay> getLichBayById(@PathVariable Long id) {
        Optional<LichBay> userOptional = lichBayService.getLichBayById(id);
        return userOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LichBay> createLichBay(@RequestBody LichBay lichBay) {
        LichBay createLichBay = lichBayService.createLichBay(lichBay);
        return ResponseEntity.status(HttpStatus.CREATED).body(createLichBay);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LichBay> updateLichBay(@PathVariable Long id, @RequestBody LichBay lichBay) {
        lichBay.setId(id);
        LichBay updatedUser = lichBayService.updateLichBay(lichBay);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLichBayById(@PathVariable Long id) {
        lichBayService.deleteLichBayById(id);
        return ResponseEntity.noContent().build();
    }
}


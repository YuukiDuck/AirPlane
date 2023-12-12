package com.duck.airline.controller;

import com.duck.airline.model.MayBay;
import com.duck.airline.service.MayBayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/maybay")
public class MayBayController {
    private final MayBayService mayBayService;

    public MayBayController(MayBayService mayBayService) {
        this.mayBayService = mayBayService;
    }

    @GetMapping
    public ResponseEntity<List<MayBay>> getAllMayBay() {
        List<MayBay> mayBays = mayBayService.getAllMayBay();
        return ResponseEntity.ok(mayBays);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MayBay> getMayBayById(@PathVariable Long id) {
        Optional<MayBay> mayBayOptional = mayBayService.getMayBayById(id);
        return mayBayOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MayBay> createMayBay(@RequestBody MayBay mayBay) {
        MayBay createdMayBay = mayBayService.createMayBay(mayBay);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMayBay);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MayBay> updateMayBay(@PathVariable Long id, @RequestBody MayBay mayBay) {
        mayBay.setId(id);
        MayBay updatedMayBay = mayBayService.updateMayBay(mayBay);
        return ResponseEntity.ok(updatedMayBay);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMayBayById(@PathVariable Long id) {
        mayBayService.deleteMayBayById(id);
        return ResponseEntity.noContent().build();
    }
}

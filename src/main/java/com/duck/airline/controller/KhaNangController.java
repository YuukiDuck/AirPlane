package com.duck.airline.controller;

import com.duck.airline.model.KhaNang;
import com.duck.airline.service.KhaNangService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/khanang")
public class KhaNangController {
    private final KhaNangService khaNangService;

    public KhaNangController(KhaNangService khaNangService) {
        this.khaNangService = khaNangService;
    }

    @GetMapping
    public ResponseEntity<List<KhaNang>> getAllKhaNang() {
        List<KhaNang> khaNang = khaNangService.getAllKhaNang();
        return ResponseEntity.ok(khaNang);
    }

    @GetMapping("/{id}")
    public ResponseEntity<KhaNang> getKhaNangById(@PathVariable Long id) {
        Optional<KhaNang> userOptional = khaNangService.getKhaNangById(id);
        return userOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<KhaNang> createKhaNang(@RequestBody KhaNang khaNang) {
        KhaNang createdUser = khaNangService.createKhaNang(khaNang);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<KhaNang> updateKhaNang(@PathVariable Long id, @RequestBody KhaNang khaNang) {
        khaNang.setId(id);
        KhaNang updatedUser = khaNangService.updateKhaNang(khaNang);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKhaNangById(@PathVariable Long id) {
        khaNangService.deleteKhaNangById(id);
        return ResponseEntity.noContent().build();
    }
}

package com.duck.airline.controller;

import com.duck.airline.model.DatCho;
import com.duck.airline.model.KhachHang;
import com.duck.airline.service.KhachHangService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/khachhang")
public class KhachHangController {
    private final KhachHangService khachHangService;

    public KhachHangController(KhachHangService khachHangService) {
        this.khachHangService = khachHangService;
    }

    @GetMapping
    public ResponseEntity<List<KhachHang>> getAllKhachHang() {
        List<KhachHang> khachHang = khachHangService.getAllKhachHang();
        return ResponseEntity.ok(khachHang);
    }

    @GetMapping("/{id}")
    public ResponseEntity<KhachHang> getKhachHangById(@PathVariable Long id) {
        Optional<KhachHang> userOptional = khachHangService.getKhachHangById(id);
        return userOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<KhachHang> createKhachHang(@RequestBody KhachHang khachHang) {
        KhachHang createdKhachHang = khachHangService.createKhachHang(khachHang);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdKhachHang);
    }

    @PutMapping("/{id}")
    public ResponseEntity<KhachHang> updateKhachHang(@PathVariable Long id, @RequestBody KhachHang khachHang) {
        khachHang.setId(id);
        KhachHang updateKhachHang = khachHangService.updateKhachHang(khachHang);
        return ResponseEntity.ok(updateKhachHang);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKhachHangById(@PathVariable Long id) {
        khachHangService.deleteKhachHangById(id);
        return ResponseEntity.noContent().build();
    }

}

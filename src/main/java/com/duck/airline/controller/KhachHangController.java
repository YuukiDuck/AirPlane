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
    public ResponseEntity<KhachHang> getDatChoById(@PathVariable Long id) {
        Optional<KhachHang> userOptional = khachHangService.getKhachHangById(id);
        return userOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<KhachHang> createDatCho(@RequestBody KhachHang khachHang) {
        KhachHang createdUser = khachHangService.createKhachHang(khachHang);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<KhachHang> updateDatCho(@PathVariable Long id, @RequestBody KhachHang khachHang) {
        khachHang.setId(id);
        KhachHang updatedUser = khachHangService.updateKhachHang(khachHang);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDatChoById(@PathVariable Long id) {
        khachHangService.deleteKhachHangById(id);
        return ResponseEntity.noContent().build();
    }

}

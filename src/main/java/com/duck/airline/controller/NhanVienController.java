package com.duck.airline.controller;

import com.duck.airline.model.NhanVien;
import com.duck.airline.service.NhanVienService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/nhanvien")
public class NhanVienController {
    private final NhanVienService nhanVienService;

    public NhanVienController(NhanVienService nhanVienService) {
        this.nhanVienService = nhanVienService;
    }

    @GetMapping
    public ResponseEntity<List<NhanVien>> getAllNhanVien() {
        List<NhanVien> nhanViens = nhanVienService.getAllNhanVien();
        return ResponseEntity.ok(nhanViens);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NhanVien> getNhanVienById(@PathVariable Long id) {
        Optional<NhanVien> nhanVienOptional = nhanVienService.getNhanVienById(id);
        return nhanVienOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<NhanVien> createNhanVien(@RequestBody NhanVien nhanVien) {
        NhanVien createdNhanVien = nhanVienService.createNhanVien(nhanVien);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNhanVien);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NhanVien> updateNhanVien(@PathVariable Long id, @RequestBody NhanVien nhanVien) {
        nhanVien.setId(id);
        NhanVien updatedNhanVien = nhanVienService.updateNhanVien(nhanVien);
        return ResponseEntity.ok(updatedNhanVien);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNhanVienById(@PathVariable Long id) {
        nhanVienService.deleteNhanVienById(id);
        return ResponseEntity.noContent().build();
    }
}


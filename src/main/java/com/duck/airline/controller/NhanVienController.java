package com.duck.airline.controller;

import com.duck.airline.exception.AccessDeniedException;
import com.duck.airline.model.NhanVien;
import com.duck.airline.service.NhanVienService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<List<NhanVien>> getAllNhanVien() {
        List<NhanVien> nhanViens = nhanVienService.getAllNhanVien();
        return ResponseEntity.ok(nhanViens);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<NhanVien> getNhanVienById(@PathVariable Long id) {
        Optional<NhanVien> nhanVienOptional = nhanVienService.getNhanVienById(id);
        return nhanVienOptional.map(ResponseEntity::ok)
                .orElseThrow(() -> new AccessDeniedException("Access denied for role ADMIN"));
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<NhanVien> createNhanVien(@RequestBody NhanVien nhanVien) {
        NhanVien createdNhanVien = nhanVienService.createNhanVien(nhanVien);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNhanVien);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<NhanVien> updateNhanVien(@PathVariable Long maNV, @RequestBody NhanVien nhanVien) {
        nhanVien.setMaNV(maNV);
        NhanVien updatedNhanVien = nhanVienService.updateNhanVien(nhanVien);
        return ResponseEntity.ok(updatedNhanVien);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<Void> deleteNhanVienById(@PathVariable Long maNV) {
        nhanVienService.deleteNhanVienById(maNV);
        return ResponseEntity.noContent().build();
    }
}

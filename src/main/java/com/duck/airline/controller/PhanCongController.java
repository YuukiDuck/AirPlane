package com.duck.airline.controller;

import com.duck.airline.exception.NotFoundException;
import com.duck.airline.exception.PermissionDeniedException;
import com.duck.airline.model.PhanCong;
import com.duck.airline.service.PhanCongService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<List<PhanCong>> getAllPhanCongs() {
        List<PhanCong> phanCongs = phanCongService.getAllPhanCong();
        return ResponseEntity.ok(phanCongs);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<PhanCong> getPhanCongById(@PathVariable Long id) {
        Optional<PhanCong> phanCongOptional = phanCongService.getPhanCongById(id);
        return phanCongOptional.map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundException("PhanCong not found with ID: " + id));
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<PhanCong> createPhanCong(@RequestBody PhanCong phanCong) {
        try {
            PhanCong createdPhanCong = phanCongService.createPhanCong(phanCong);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPhanCong);
        } catch (PermissionDeniedException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<PhanCong> updatePhanCong(@PathVariable Long id, @RequestBody PhanCong phanCong) {
        try {
            phanCong.setId(id);
            PhanCong updatedPhanCong = phanCongService.updatePhanCong(phanCong);
            return ResponseEntity.ok(updatedPhanCong);
        } catch (PermissionDeniedException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhanCongById(@PathVariable Long id) {
        try {
            phanCongService.deletePhanCongById(id);
            return ResponseEntity.noContent().build();
        } catch (PermissionDeniedException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
}

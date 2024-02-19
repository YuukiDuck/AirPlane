package com.duck.airline.controller;

import com.duck.airline.exception.InternalServerErrorException;
import com.duck.airline.exception.NotFoundException;
import com.duck.airline.model.KhachHang;
import com.duck.airline.service.KhachHangService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/khachhang")
@ControllerAdvice
public class KhachHangController {
    private final KhachHangService khachHangService;

    public KhachHangController(KhachHangService khachHangService) {
        this.khachHangService = khachHangService;
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<List<KhachHang>> getAllKhachHang() {
        try {
            List<KhachHang> khachHang = khachHangService.getAllKhachHang();
            return ResponseEntity.ok(khachHang);
        } catch (Exception e) {
            throw new InternalServerErrorException("Internal Server Error occurred", e);
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<KhachHang> getKhachHangById(@PathVariable Long id) {
        try {
            Optional<KhachHang> userOptional = khachHangService.getKhachHangById(id);
            return userOptional.map(ResponseEntity::ok)
                    .orElseThrow(() -> new NotFoundException("KhachHang not found with ID: " + id));
        } catch (Exception e) {
            throw new InternalServerErrorException("Internal Server Error occurred", e);
        }
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseEntity<KhachHang> createKhachHang(@RequestBody KhachHang khachHang) {
        try {
            KhachHang createdKhachHang = khachHangService.createKhachHang(khachHang);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdKhachHang);
        } catch (NotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new InternalServerErrorException("Internal Server Error occurred", e);
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseEntity<KhachHang> updateKhachHang(@PathVariable Long maKH, @RequestBody KhachHang khachHang) {
        try {
            khachHang.setMaKH(maKH); // Cập nhật ID của khách hàng với ID được chuyển từ đường dẫn
            KhachHang updatedKhachHang = khachHangService.updateKhachHang(khachHang); // Gọi service để cập nhật khách hàng
            return ResponseEntity.ok(updatedKhachHang);
        } catch (NotFoundException e) {
            throw e; // Re-throw exception để ngoại lệ được xử lý ở lớp ControllerAdvice
        } catch (Exception e) {
            throw new InternalServerErrorException("Internal Server Error occurred", e);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseEntity<Void> deleteKhachHangById(@PathVariable Long id) {
        try {
            khachHangService.deleteKhachHangById(id);
            return ResponseEntity.noContent().build();
        } catch (NotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new InternalServerErrorException("Internal Server Error occurred", e);
        }
    }
}

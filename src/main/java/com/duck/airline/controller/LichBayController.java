package com.duck.airline.controller;

import com.duck.airline.model.LichBay;
import com.duck.airline.service.LichBayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyAuthority('ADMIN','NHANVIEN')")
    public ResponseEntity<List<LichBay>> getAllLichBay() {
        List<LichBay> lichBay = lichBayService.getAllLichBay();
        return ResponseEntity.ok(lichBay);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','NHANVIEN')")
    public ResponseEntity<Optional<LichBay>> getLichBayById(@PathVariable Long id) {
        // Lấy danh sách lịch bay dựa trên id hoặc một logic nào đó
        Optional<LichBay> lichBayList = lichBayService.getLichBayById(id);
        // Kiểm tra nếu danh sách không rỗng, trả về danh sách lịch bay
        if (!lichBayList.isEmpty()) {
            return ResponseEntity.ok(lichBayList);
        } else {
            // Nếu danh sách rỗng, trả về HTTP 404 Not Found
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<LichBay> createLichBay(@RequestBody LichBay lichBay) {
        LichBay createLichBay = lichBayService.createLichBay(lichBay);
        return ResponseEntity.status(HttpStatus.CREATED).body(createLichBay);

    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<LichBay> updateLichBay(@PathVariable Long id, @RequestBody LichBay lichBay) {
        lichBay.setId(id);
        LichBay updatedUser = lichBayService.updateLichBay(lichBay);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<Void> deleteLichBayById(@PathVariable Long id) {
        lichBayService.deleteLichBayById(id);
        return ResponseEntity.noContent().build();
    }
}


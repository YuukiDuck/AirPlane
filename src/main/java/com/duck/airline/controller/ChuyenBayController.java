package com.duck.airline.controller;

import com.duck.airline.model.ChuyenBay;
import com.duck.airline.service.ChuyenBayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chuyenbay")
public class ChuyenBayController {
    private final ChuyenBayService chuyenBayService;

    public ChuyenBayController(ChuyenBayService chuyenBayService) {
        this.chuyenBayService = chuyenBayService;
    }

    @GetMapping
    ResponseEntity<List<ChuyenBay>> getAllChuyenBay() {
        List<ChuyenBay> chuyenBayList = chuyenBayService.getAllChuyenBay();
        return ResponseEntity.ok(chuyenBayList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChuyenBay> getChuyenBayById(@PathVariable String maCB) {
        Optional<ChuyenBay> userOptional = chuyenBayService.getChuyenBayById(maCB);
        return userOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ChuyenBay> createUser(@RequestBody ChuyenBay chuyenBay) {
        ChuyenBay createdUser = chuyenBayService.createChuyenBay(chuyenBay);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChuyenBay> updateChuyenBay(@PathVariable String maCB, @RequestBody ChuyenBay chuyenBay) {
        chuyenBay.setMaCB(maCB);
        ChuyenBay updatedChuyenBay = chuyenBayService.updateChuyenBay(chuyenBay);
        return ResponseEntity.ok(updatedChuyenBay);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChuyenBayByMaCB(@PathVariable String maCB) {
        chuyenBayService.deleteChuyenBayByMaCB(maCB);
        return ResponseEntity.noContent().build();
    }

}

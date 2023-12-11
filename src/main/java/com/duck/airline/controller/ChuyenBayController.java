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
    public ResponseEntity<ChuyenBay> getChuyenBayById(@PathVariable Long id) {
        Optional<ChuyenBay> userOptional = chuyenBayService.getUserById(id);
        return userOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ChuyenBay> createUser(@RequestBody ChuyenBay chuyenBay) {
        ChuyenBay createdUser = chuyenBayService.createChuyenBay(chuyenBay);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChuyenBay> updateUser(@PathVariable long id, @RequestBody ChuyenBay chuyenBay) {
        chuyenBay.setId(id);
        ChuyenBay updateChuyenBay = chuyenBayService.updateChuyenBay(chuyenBay);
        return ResponseEntity.ok(updateChuyenBay);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        chuyenBayService.deleteChuyenBayById(id);
        return ResponseEntity.noContent().build();
    }
}

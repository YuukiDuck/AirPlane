package com.duck.airline.controller;

import com.duck.airline.model.DatCho;
import com.duck.airline.service.DatChoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/datcho")
public class DatChoController {
    private final DatChoService datChoService;

    public DatChoController(DatChoService datChoService) {
        this.datChoService = datChoService;
    }

    @GetMapping
    public ResponseEntity<List<DatCho>> getAllDatCho() {
        List<DatCho> datChos = datChoService.getAllDatCho();
        return ResponseEntity.ok(datChos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatCho> getDatChoById(@PathVariable Long id) {
        Optional<DatCho> userOptional = datChoService.getDatChoById(id);
        return userOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DatCho> createDatCho(@RequestBody DatCho datCho) {
        DatCho createdUser = datChoService.createDatCho(datCho);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatCho> updateDatCho(@PathVariable Long id, @RequestBody DatCho datCho) {
        datCho.setId(id);
        DatCho updateDatCho = datChoService.updateDatCho(datCho);
        return ResponseEntity.ok(updateDatCho);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDatChoById(@PathVariable Long id) {
        datChoService.deleteDatChoById(id);
        return ResponseEntity.noContent().build();
    }

}

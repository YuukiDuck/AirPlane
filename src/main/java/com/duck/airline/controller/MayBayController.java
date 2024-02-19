package com.duck.airline.controller;

import com.duck.airline.dto.MayBayDto;
import com.duck.airline.exception.NotFoundException;
import com.duck.airline.exception.PermissionDeniedException;
import com.duck.airline.model.MayBay;
import com.duck.airline.service.MayBayService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/maybay")
public class MayBayController {
    private final MayBayService mayBayService;

    public MayBayController(MayBayService mayBayService) {
        this.mayBayService = mayBayService;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<List<MayBay>> getAllMayBay() {
        List<MayBay> mayBays = mayBayService.getAllMayBay();
        return ResponseEntity.ok(mayBays);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<MayBay> getMayBayById(@PathVariable Long id) {
        Optional<MayBay> mayBay = mayBayService.getMayBayById(id);
        if (mayBay.isPresent()) {
            return ResponseEntity.ok(mayBay.get());
        } else {
            throw new NotFoundException("MayBay not found with ID: " + id);
        }
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<?> createMayBay(@Valid @RequestBody MayBayDto mayBayDto, BindingResult result, Principal principal) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        try {
            // Kiểm tra vai trò của người dùng và ném ngoại lệ nếu không có quyền
            if (!isAdmin(principal)) {
                throw new PermissionDeniedException("Permission denied to create MayBay");
            }

            MayBay createdMayBay = mayBayService.createMayBay(mayBayDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdMayBay);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (PermissionDeniedException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMayBayById(@PathVariable Long id) {
        try {
            mayBayService.deleteMayBayById(id);
            return ResponseEntity.noContent().build();
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Phương thức kiểm tra vai trò ADMIN của người dùng hiện tại
    private boolean isAdmin(Principal principal) {
        return principal != null && principal.getName() != null
                && principal.getName().equals("ADMIN"); // Thay thế "ADMIN" bằng cách lấy vai trò thực tế của người dùng.
    }
}

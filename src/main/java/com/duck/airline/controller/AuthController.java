package com.duck.airline.controller;

import com.duck.airline.dto.AuthRequestDto;
import com.duck.airline.dto.AuthResponseDto;
import com.duck.airline.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register/khachhang")
    public AuthResponseDto registerKhachHang(@RequestBody AuthRequestDto requestDto) {
        return authService.registerKhachHang(requestDto);
    }

    @PostMapping("/login/khachhang")
    public AuthResponseDto loginKhachHang(@RequestBody AuthRequestDto requestDto) {
        return authService.loginKhachHang(requestDto);
    }

    @PostMapping("/register/nhanvien")
    public AuthResponseDto registerNhanVien(@RequestBody AuthRequestDto requestDto) {
        return authService.registerNhanVien(requestDto);
    }

    @PostMapping("/login/nhanvien")
    public AuthResponseDto loginNhanVien(@RequestBody AuthRequestDto requestDto) {
        return authService.loginNhanVien(requestDto);
    }
}
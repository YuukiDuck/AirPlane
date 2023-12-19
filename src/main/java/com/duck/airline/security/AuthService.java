package com.duck.airline.security;

import com.duck.airline.dto.AuthRequestDto;
import com.duck.airline.dto.AuthResponseDto;
import com.duck.airline.model.ERole;
import com.duck.airline.model.KhachHang;
import com.duck.airline.model.NhanVien;
import com.duck.airline.repository.KhachHangRepository;
import com.duck.airline.repository.NhanVienRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final KhachHangRepository khachHangRepository;
    private final NhanVienRepository nhanVienRepository;
    private PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthService(KhachHangRepository khachHangRepository, NhanVienRepository nhanVienRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.khachHangRepository = khachHangRepository;
        this.nhanVienRepository = nhanVienRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthResponseDto registerKhachHang(AuthRequestDto requestDto) {
        var khachhang = KhachHang.builder()
                .email(requestDto.getEmail())
                .password(passwordEncoder.encode(requestDto.getPassword()))
                .role(ERole.USER)
                .build();

        khachHangRepository.save(khachhang);

        return AuthResponseDto.builder().token(jwtService.generateToken(khachhang.getEmail())).build();
    }

    public AuthResponseDto loginKhachHang(AuthRequestDto requestDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestDto.getEmail(), requestDto.getPassword()));
        var khachHang = khachHangRepository.findByEmail(requestDto.getEmail());
        return AuthResponseDto.builder().token(jwtService.generateToken(khachHang.get().getEmail())).build();
    }

    public AuthResponseDto registerNhanVien(AuthRequestDto requestDto) {
        var nhanVien = NhanVien.builder()
                .email(requestDto.getEmail())
                .password(passwordEncoder.encode(requestDto.getPassword()))
                .role(ERole.NHANVIEN)
                .build();

                nhanVienRepository.save(nhanVien);

                return AuthResponseDto.builder().token(jwtService.generateToken(nhanVien.getEmail())).build();
        }

    public AuthResponseDto loginNhanVien(AuthRequestDto requestDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestDto.getEmail(), requestDto.getPassword()));
        var nhanVien = nhanVienRepository.findByEmail(requestDto.getEmail());
        return AuthResponseDto.builder().token(jwtService.generateToken(nhanVien.get().getEmail())).build();
    }

    public boolean authenticateKhachHang(String email, String password) {
        Optional<KhachHang> optionalUser = khachHangRepository.findByEmail(email);

        if (optionalUser.isPresent()) {
            KhachHang khachHang = optionalUser.get();
            return passwordEncoder.matches(password, khachHang.getPassword());
        }
        return false;
    }

    public boolean authenticateNhanVien(String email, String password) {
        Optional<NhanVien> optionalNhanVien = nhanVienRepository.findByEmail(email);

        if (optionalNhanVien.isPresent()) {
            NhanVien nhanVien = optionalNhanVien.get();
            return passwordEncoder.matches(password, nhanVien.getPassword());
        }
        return false;
    }
}
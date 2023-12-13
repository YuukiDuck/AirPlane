package com.duck.airline.security;

import com.duck.airline.dto.AuthRequestDto;
import com.duck.airline.dto.AuthResponseDto;
import com.duck.airline.model.ERole;
import com.duck.airline.model.KhachHang;
import com.duck.airline.repository.KhachHangRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final KhachHangRepository khachHangRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponseDto register(AuthRequestDto requestDto){
        var khachhang = KhachHang.builder()
                .email(requestDto.getEmail())
                .password(passwordEncoder.encode(requestDto.getPassword()))
                .role(ERole.USER)
                .build();

        khachHangRepository.save(khachhang);

        return AuthResponseDto.builder().token(jwtService.generateToken(khachhang.getEmail())).build();
    }

    public AuthResponseDto login(AuthRequestDto requestDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestDto.getEmail(), requestDto.getPassword()));
        var user = khachHangRepository.findByEmail(requestDto.getEmail());
        return AuthResponseDto.builder().token(jwtService.generateToken(user.get().getEmail())).build();
    }

    public boolean authenticateUser(String email, String password) {
        Optional<KhachHang> optionalUser = khachHangRepository.findByEmail(email);

        if (optionalUser.isPresent()) {
            KhachHang khachHang = optionalUser.get();
            return passwordEncoder.matches(password, khachHang.getPassword());
        }
        return false;
    }
}
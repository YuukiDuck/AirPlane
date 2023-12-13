package com.duck.airline.security.service;

import com.duck.airline.model.KhachHang;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private long id;
    private Long maKH;
    private String ten;
    private String diaChi;
    private String dienThoai;
    private String email;
    private String password;

    public UserDetailsImpl(long id, Long maKH, String ten, String diaChi, String dienThoai, String email, String password) {
        this.id = id;
        this.maKH = maKH;
        this.ten = ten;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
        this.email = email;
        this.password = password;
    }

    private Collection<? extends GrantedAuthority> authorities;

    public static UserDetailsImpl build(KhachHang khachHang) {
        return new UserDetailsImpl(
                khachHang.getId(),
                khachHang.getMaKH(),
                khachHang.getTen(),
                khachHang.getDiaChi(),
                khachHang.getDienThoai(),
                khachHang.getEmail(),
                khachHang.getPassword()
        );
    }


    public UserDetailsImpl(long id, Long maKH, String ten, String email, String password,
                           Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.maKH = maKH;
        this.ten = ten;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Có thể cần triển khai sau này nếu người dùng có các quyền (roles) cụ thể
        return authorities;
    }


    public long getId() {
        return id;
    }

    public Long getMaKH() {
        return maKH;
    }

    public String getTen() {
        return ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

package com.duck.airline.service;

import com.duck.airline.model.KhachHang;

import java.util.List;
import java.util.Optional;

public interface KhachHangService {
    List<KhachHang> getAllKhachHang();

    Optional<KhachHang> getKhachHangById(Long id);

    KhachHang createKhachHang(KhachHang khachHang);

    KhachHang updateKhachHang(KhachHang khachHang);

    void deleteKhachHangById(Long id);
}


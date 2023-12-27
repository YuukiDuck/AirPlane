package com.duck.airline.service;

import com.duck.airline.model.NhanVien;

import java.util.List;
import java.util.Optional;

public interface NhanVienService {
    List<NhanVien> getAllNhanVien();

//    List<NhanVien> findAllNhanVienWithPhanCong();

    Optional<NhanVien> getNhanVienById(Long id);

    NhanVien createNhanVien(NhanVien nhanVien);

    NhanVien updateNhanVien(NhanVien nhanVien);

    void deleteNhanVienById(Long id);
}


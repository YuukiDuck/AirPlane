package com.duck.airline.service.impl;

import com.duck.airline.model.NhanVien;
import com.duck.airline.repository.NhanVienRepository;
import com.duck.airline.service.NhanVienService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NhanVienServiceImpl implements NhanVienService {
    private final NhanVienRepository nhanVienRepository;
    @Override
    public List<NhanVien> getAllNhanVien() {
        return nhanVienRepository.findAll();
    }

//    @Override
//    public List<NhanVien> findAllNhanVienWithPhanCong() {
//        return nhanVienRepository.findAllNhanVienWithPhanCong();
//    }

    @Override
    public Optional<NhanVien> getNhanVienById(Long maNV) {
        return nhanVienRepository.findById(maNV);
    }

    @Override
    public NhanVien createNhanVien(NhanVien nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }

    @Override
    public NhanVien updateNhanVien(NhanVien nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }

    @Override
    public void deleteNhanVienById(Long maNV) {
        nhanVienRepository.deleteById(maNV);
    }
}

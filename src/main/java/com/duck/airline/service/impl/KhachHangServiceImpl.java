package com.duck.airline.service.impl;

import com.duck.airline.model.KhaNang;
import com.duck.airline.model.KhachHang;
import com.duck.airline.repository.KhachHangRepository;
import com.duck.airline.service.KhaNangService;
import com.duck.airline.service.KhachHangService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class KhachHangServiceImpl implements KhachHangService {
    private final KhachHangRepository khachHangRepository;

    @Override
    public List<KhachHang> getAllKhachHang() {
        return khachHangRepository.findAll();
    }

    @Override
    public Optional<KhachHang> getKhachHangById(Long id) {
        return khachHangRepository.findById(id);
    }

    @Override
    public KhachHang createKhachHang(KhachHang khachHang) {
        return khachHangRepository.save(khachHang);
    }

    @Override
    public KhachHang updateKhachHang(KhachHang khachHang) {
        return khachHangRepository.save(khachHang);
    }

    @Override
    public void deleteKhachHangById(Long id) {
        khachHangRepository.deleteById(id);
    }
}

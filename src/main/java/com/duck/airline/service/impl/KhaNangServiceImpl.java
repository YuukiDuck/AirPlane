package com.duck.airline.service.impl;

import com.duck.airline.model.KhaNang;
import com.duck.airline.model.KhachHang;
import com.duck.airline.repository.KhaNangRepository;
import com.duck.airline.service.KhaNangService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class KhaNangServiceImpl implements KhaNangService {
private final KhaNangRepository khaNangRepository;
    @Override
    public List<KhaNang> getAllKhaNang() {
        return khaNangRepository.findAll();
    }

    @Override
    public Optional<KhaNang> getKhaNangById(Long id) {
        return khaNangRepository.findById(id);
    }

    @Override
    public KhaNang createKhaNang(KhaNang khaNang) {
        return khaNangRepository.save(khaNang);
    }

    @Override
    public KhaNang updateKhaNang(KhaNang khaNang) {
        return khaNangRepository.save(khaNang);
    }

    @Override
    public void deleteKhaNangById(Long id) {
        khaNangRepository.deleteById(id);
    }
}

package com.duck.airline.service.impl;

import com.duck.airline.model.LoaiMayBay;
import com.duck.airline.repository.LoaiMayBayRepository;
import com.duck.airline.service.LoaiMayBayService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LoaiMayBayServiceImpl implements LoaiMayBayService {
    private final LoaiMayBayRepository loaiMayBayRepository;
    @Override
    public List<LoaiMayBay> getAllLoaiMayBay() {
        return loaiMayBayRepository.findAll();
    }

    @Override
    public Optional<LoaiMayBay> getLoaiMayBayById(Long maLoai) {
        return loaiMayBayRepository.findById(maLoai);
    }

    @Override
    public LoaiMayBay createLoaiMayBay(LoaiMayBay loaiMayBay) {
        return loaiMayBayRepository.save(loaiMayBay);
    }

    @Override
    public LoaiMayBay updateLoaiMayBay(LoaiMayBay loaiMayBay) {
        return loaiMayBayRepository.save(loaiMayBay);
    }

    @Override
    public void deleteLoaiMayBayById(Long maLoai) {
        loaiMayBayRepository.deleteById(maLoai);
    }
}

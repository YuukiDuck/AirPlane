package com.duck.airline.service.impl;

import com.duck.airline.model.ChuyenBay;
import com.duck.airline.repository.ChuyenBayRepository;
import com.duck.airline.service.ChuyenBayService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ChuyenBayServiceImpl implements ChuyenBayService {

    private final ChuyenBayRepository chuyenBayRepository;

    @Override
    public List<ChuyenBay> getAllChuyenBay() {
        return chuyenBayRepository.findAll();
    }

    @Override
    public Optional<ChuyenBay> getUserById(Long id) {
        return chuyenBayRepository.findById(id);
    }

    @Override
    public ChuyenBay createChuyenBay(ChuyenBay chuyenBay) {
        return chuyenBayRepository.save(chuyenBay);
    }

    @Override
    public ChuyenBay updateChuyenBay(ChuyenBay chuyenBay) {
        return chuyenBayRepository.save(chuyenBay);
    }

    @Override
    public void deleteChuyenBayById(Long id) {
        chuyenBayRepository.deleteAllById(id);
    }
}

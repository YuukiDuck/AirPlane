package com.duck.airline.service.impl;

import com.duck.airline.model.LichBay;
import com.duck.airline.repository.LichBayRepository;
import com.duck.airline.service.LichBayService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LichBayServiceImpl implements LichBayService {
private LichBayRepository lichBayRepository;
    @Override
    public List<LichBay> getAllLichBay() {
        return lichBayRepository.findAll();
    }

    @Override
    public Optional<LichBay> getLichBayById(Long id) {
        return lichBayRepository.findById(id);
    }

    @Override
    public LichBay createLichBay(LichBay lichBay) {
        return lichBayRepository.save(lichBay);
    }

    @Override
    public LichBay updateLichBay(LichBay lichBay) {
        return lichBayRepository.save(lichBay);
    }

    @Override
    public void deleteLichBayById(Long id) {
        lichBayRepository.deleteById(id);
    }
}

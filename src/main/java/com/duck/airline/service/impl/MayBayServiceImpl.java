package com.duck.airline.service.impl;

import com.duck.airline.model.MayBay;
import com.duck.airline.repository.MayBayRepository;
import com.duck.airline.service.MayBayService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MayBayServiceImpl implements MayBayService {
private final MayBayRepository mayBayRepository;
    @Override
    public List<MayBay> getAllMayBay() {
        return mayBayRepository.findAll();
    }

    @Override
    public Optional<MayBay> getMayBayById(Long id) {
        return mayBayRepository.findById(id);
    }

    @Override
    public MayBay createMayBay(MayBay mayBay) {
        return mayBayRepository.save(mayBay);
    }

    @Override
    public MayBay updateMayBay(MayBay mayBay) {
        return mayBayRepository.save(mayBay);
    }

    @Override
    public void deleteMayBayById(Long id) {
        mayBayRepository.deleteById(id);
    }
}

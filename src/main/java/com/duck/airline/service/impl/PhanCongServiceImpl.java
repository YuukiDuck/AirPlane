package com.duck.airline.service.impl;

import com.duck.airline.model.PhanCong;
import com.duck.airline.repository.PhanCongRepository;
import com.duck.airline.service.PhanCongService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PhanCongServiceImpl implements PhanCongService {

    private final PhanCongRepository phanCongRepository;

    @Override
    public List<PhanCong> getAllPhanCong() {
        return phanCongRepository.findAll();
    }

    @Override
    public Optional<PhanCong> getPhanCongById(Long id) {
        return phanCongRepository.findById(id);
    }

    @Override
    public PhanCong createPhanCong(PhanCong phanCong) {
        return phanCongRepository.save(phanCong);
    }

    @Override
    public PhanCong updatePhanCong(PhanCong phanCong) {
        return phanCongRepository.save(phanCong);
    }

    @Override
    public void deletePhanCongById(Long id) {
        phanCongRepository.deleteById(id);
    }
}

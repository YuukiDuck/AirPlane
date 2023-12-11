package com.duck.airline.service.impl;

import com.duck.airline.model.DatCho;
import com.duck.airline.repository.DatChoRepository;
import com.duck.airline.service.DatChoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DatChoServiceImpl implements DatChoService {
    private final DatChoRepository datChoRepository;

    @Override
    public List<DatCho> getAllDatCho() {
        return datChoRepository.findAll();
    }

    @Override
    public Optional<DatCho> getDatChoById(Long id) {
        return datChoRepository.findAllById(id);
    }

    @Override
    public DatCho createDatCho(DatCho datCho) {
        return datChoRepository.save(datCho);
    }

    @Override
    public DatCho updateDatCho(DatCho datCho) {
        return datChoRepository.save(datCho);
    }

    @Override
    public void deleteDatChoById(Long id) {
        datChoRepository.deleteById(id);
    }
}

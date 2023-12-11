package com.duck.airline.service;

import com.duck.airline.model.DatCho;

import java.util.List;
import java.util.Optional;

public interface DatChoService {
    List<DatCho> getAllDatCho();

    Optional<DatCho> getDatChoById(Long id);

    DatCho createDatCho(DatCho datCho);

    DatCho updateDatCho(DatCho datCho);

    void deleteDatChoById(Long id);
}

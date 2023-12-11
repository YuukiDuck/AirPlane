package com.duck.airline.service;

import com.duck.airline.model.LichBay;

import java.util.List;
import java.util.Optional;

public interface LichBayService {
    List<LichBay> getAllLichBay();

    Optional<LichBay> getLichBayById(Long id);

    LichBay createLichBay(LichBay lichBay);

    LichBay updateLichBay(LichBay lichBay);

    void deleteLichBayById(Long id);
}


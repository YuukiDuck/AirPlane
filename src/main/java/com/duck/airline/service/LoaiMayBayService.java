package com.duck.airline.service;

import com.duck.airline.model.LoaiMayBay;

import java.util.List;
import java.util.Optional;

public interface LoaiMayBayService {
    List<LoaiMayBay> getAllLoaiMayBay();

    Optional<LoaiMayBay> getLoaiMayBayById(Long id);

    LoaiMayBay createLoaiMayBay(LoaiMayBay loaiMayBay);

    LoaiMayBay updateLoaiMayBay(LoaiMayBay loaiMayBay);

    void deleteLoaiMayBayById(Long id);
}


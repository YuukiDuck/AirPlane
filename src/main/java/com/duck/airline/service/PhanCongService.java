package com.duck.airline.service;

import com.duck.airline.model.PhanCong;

import java.util.List;
import java.util.Optional;

public interface PhanCongService {
    List<PhanCong> getAllPhanCong();

    Optional<PhanCong> getPhanCongById(Long id);

    PhanCong createPhanCong(PhanCong phanCong);

    PhanCong updatePhanCong(PhanCong phanCong);

    void deletePhanCongById(Long id);
}

package com.duck.airline.service;

import com.duck.airline.model.MayBay;

import java.util.List;

import java.util.Optional;

public interface MayBayService {
    List<MayBay> getAllMayBay();

    Optional<MayBay> getMayBayById(Long id);

    MayBay createMayBay(MayBay mayBay);

    MayBay updateMayBay(MayBay mayBay);

    void deleteMayBayById(Long id);
}


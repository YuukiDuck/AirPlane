package com.duck.airline.service;

import com.duck.airline.dto.MayBayDto;
import com.duck.airline.model.MayBay;

import java.util.List;

import java.util.Optional;

public interface MayBayService {
    List<MayBay> getAllMayBay();

    Optional<MayBay> getMayBayById(Long soHieu);

    MayBay createMayBay(MayBayDto mayBayDto);

    MayBay updateMayBay(MayBay mayBay);

    void deleteMayBayById(Long soHieu);
}


package com.duck.airline.service;

import com.duck.airline.model.ChuyenBay;
import com.duck.airline.model.LoaiMayBay;

import java.util.List;
import java.util.Optional;

public interface ChuyenBayService {
    List<ChuyenBay> getAllChuyenBay();

    Optional<ChuyenBay> getChuyenBayById(String maCB );

    ChuyenBay createChuyenBay(ChuyenBay chuyenBay);

    ChuyenBay updateChuyenBay(ChuyenBay chuyenBay);

    void deleteChuyenBayByMaCB(String maCB);
}
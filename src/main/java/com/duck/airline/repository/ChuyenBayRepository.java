package com.duck.airline.repository;

import com.duck.airline.model.ChuyenBay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChuyenBayRepository extends JpaRepository<ChuyenBay, String> {
    void deleteChuyenBayByMaCB(String maCB); // Thay vì deleteById, sử dụng deleteChuyenBayByMaCB
}


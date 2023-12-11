package com.duck.airline.repository;

import com.duck.airline.model.ChuyenBay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChuyenBayRepository extends JpaRepository<ChuyenBay, Long> {

    void deleteAllById(Long maCB);
}

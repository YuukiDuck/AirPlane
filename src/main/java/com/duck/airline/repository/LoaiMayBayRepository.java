package com.duck.airline.repository;

import com.duck.airline.model.LoaiMayBay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LoaiMayBayRepository extends JpaRepository<LoaiMayBay, Long> {

}

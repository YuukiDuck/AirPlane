package com.duck.airline.repository;

import com.duck.airline.model.LichBay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LichBayRepository extends JpaRepository<LichBay, Long> {

}

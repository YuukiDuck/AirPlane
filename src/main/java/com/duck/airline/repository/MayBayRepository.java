package com.duck.airline.repository;

import com.duck.airline.model.MayBay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MayBayRepository extends JpaRepository<MayBay, Long> {

    Optional<MayBay> findById(Long id);
}

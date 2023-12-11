package com.duck.airline.repository;

import com.duck.airline.model.DatCho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DatChoRepository extends JpaRepository<DatCho, Long> {
    Optional<DatCho> findAllById(Long id);
}

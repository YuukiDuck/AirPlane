package com.duck.airline.repository;

import com.duck.airline.model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Long> {

    Optional<NhanVien> findByEmail(String email);

    boolean existsByEmail(String email);
}

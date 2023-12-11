package com.duck.airline.repository;

import com.duck.airline.model.KhaNang;
import com.duck.airline.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Long> {

    Optional<KhachHang> findAllById(Long id);
}

package com.duck.airline.repository;

import com.duck.airline.model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Long> {

//    @Query("SELECT e FROM NhanVien e JOIN PhanCong p ON e.manv = p.manv")
//    List<NhanVien> findAllNhanVienWithPhanCong();

    Optional<NhanVien> findByEmail(String email);

    boolean existsByEmail(String email);
}

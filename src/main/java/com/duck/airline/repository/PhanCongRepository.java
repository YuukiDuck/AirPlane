package com.duck.airline.repository;

import com.duck.airline.model.PhanCong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhanCongRepository extends JpaRepository<PhanCong, Long> {

}

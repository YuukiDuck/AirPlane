package com.duck.airline.repository;

import com.duck.airline.model.KhaNang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhaNangRepository extends JpaRepository<KhaNang, Long> {

}

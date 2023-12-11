package com.duck.airline.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "NHANVIEN")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long maNV;
    private String ten;
    private String diaChi;
    private String dienThoai;
    private double luong;
    private int loaiNV;
    private String email;
    @JsonIgnore
    private String password;

}

package com.duck.airline.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "nhanvien")
public class NhanVien implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long maNV;
    private String ten;
    private String diaChi;
    private String dienThoai;
    private double luong;
    private int loaiNV;
    private String email;
    @Enumerated(EnumType.STRING)
    private ERole role;
    @JsonIgnore
    private String password;

//    public void ERole(String admin) {
//    }
}

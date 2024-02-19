package com.duck.airline.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "NHANVIEN")
public class NhanVien implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MANV")
    private Long maNV;

    @Column(name = "TEN")
    private String ten;

    private String diaChi;
    private String dienThoai;
    private double luong;
    @Column(name = "LOAINV")
    private Integer loaiNhanVien; // Sử dụng Integer thay vì int để cho phép giá trị null

    @OneToMany(mappedBy = "nhanVien")
    private List<KhaNang> khaNangs;

    @Column(name = "email")
    private String email;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    private ERole role;

    @ManyToMany
    @JoinTable(
            name = "PHANCONG",
            joinColumns = @JoinColumn(name = "MANV"),
            inverseJoinColumns = @JoinColumn(name = "MALOAI")
    )
    private List<LoaiMayBay> loaiMayBay;

    public Integer getLoaiNhanVien() {
        return loaiNhanVien;
    }

    public void setLoaiNhanVien(Integer loaiNhanVien) {
        if (loaiNhanVien == null || loaiNhanVien == 0 || loaiNhanVien == 1) {
            this.loaiNhanVien = loaiNhanVien;
        } else {
            throw new IllegalArgumentException("Giá trị LOAINV không hợp lệ");
        }
    }
}

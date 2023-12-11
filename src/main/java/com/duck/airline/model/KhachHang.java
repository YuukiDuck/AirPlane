package com.duck.airline.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "khachhang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "makh")
    private Long maKH;

    @Column(name = "ten")
    private String ten;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "dien_thoai")
    private String dienThoai;

    @Column(name = "email")
    private String email;

    @JsonIgnore
    private String password;


}

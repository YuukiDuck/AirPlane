package com.duck.airline.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "khanang")
public class KhaNang {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "maNV")
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "maLoai")
    private LoaiMayBay loaiMayBay;

    // Getters, setters và constructors
}

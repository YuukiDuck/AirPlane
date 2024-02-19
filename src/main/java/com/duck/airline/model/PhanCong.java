package com.duck.airline.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PHANCONG")
public class PhanCong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NGAYDI")
    private LocalDate ngayDi;

    @ManyToOne
    @JoinColumn(name = "MANV")
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "MACB")
    private ChuyenBay chuyenBay;
}


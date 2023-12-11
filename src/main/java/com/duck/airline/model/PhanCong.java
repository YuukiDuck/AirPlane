package com.duck.airline.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "phancong")
public class PhanCong {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "maNV")
    private NhanVien nhanVien;

    private LocalDate ngayDi;

    @ManyToOne
    @JoinColumn(name = "maCB")
    private ChuyenBay chuyenBay;

}


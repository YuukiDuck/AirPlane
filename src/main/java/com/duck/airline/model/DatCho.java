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
@Table(name = "datcho")
public class DatCho {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "maKH") // Khóa ngoại liên kết đến bảng KhachHang
    private KhachHang khachHang;

    private LocalDate ngayDi;

    @ManyToOne
    @JoinColumn(name = "maCB") // Khóa ngoại liên kết đến bảng ChuyenBay
    private ChuyenBay chuyenBay;

    // Getters, setters và constructors
}


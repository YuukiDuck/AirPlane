package com.duck.airline.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DATCHO")
public class DatCho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MAKH")
    private KhachHang khachHang;

    private LocalDate ngayDi;

    @ManyToOne
    @JoinColumn(name = "MACB") // Khóa ngoại liên kết đến bảng ChuyenBay
    private ChuyenBay chuyenBay;
}


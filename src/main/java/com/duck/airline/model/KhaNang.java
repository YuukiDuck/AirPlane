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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MANV")
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "MALOAI")
    private LoaiMayBay loaiMayBay;
}

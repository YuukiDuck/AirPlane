package com.duck.airline.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LOAIMB")
public class LoaiMayBay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MALOAI")
    private Long maLoai;

    @Column(name = "HANGSX")
    private String hangSanXuat;

    @ManyToMany(mappedBy = "loaiMayBay")
    private List<NhanVien> nhanViens;
}



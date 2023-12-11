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
@Table(name = "maybay")
public class MayBay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String soHieu;

    @ManyToOne
    @JoinColumn(name = "maLoai")
    private LoaiMayBay loaiMayBay;

    @OneToMany(mappedBy = "mayBay")
    private List<LichBay> lichBayList;
}


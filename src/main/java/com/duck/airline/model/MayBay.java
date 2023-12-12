package com.duck.airline.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ma_loai")
    private LoaiMayBay loaiMayBay;

    @JsonIgnore
    @OneToMany(mappedBy = "mayBay")
    private List<LichBay> lichBayList;
}


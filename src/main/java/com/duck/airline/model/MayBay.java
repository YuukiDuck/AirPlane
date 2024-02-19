package com.duck.airline.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MAYBAY")
public class MayBay {

    @Id
    @Column(name = "SOHIEU")
    private String soHieu;

    @ManyToOne
    @JoinColumn(name = "MALOAI")
    private LoaiMayBay loaiMayBay;
}


package com.duck.airline.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CHUYENBAY")
public class ChuyenBay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MACB")
    private String  maCB;

    @Column(name = "SBDI")
    private String sanBayDi;

    @Column(name = "SBDEN")
    private String sanBayDen;

    @Column(name = "GIODI")
    private String gioDi;

    @Column(name = "GIODEN")
    private String gioDen;

    @OneToOne(mappedBy = "chuyenBay")
    private LichBay lichBay;
}

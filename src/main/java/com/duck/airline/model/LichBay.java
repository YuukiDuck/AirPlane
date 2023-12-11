package com.duck.airline.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "lichbay")
public class LichBay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate ngayDi;

    @ManyToOne
    @JoinColumn(name = "maCB")
    private ChuyenBay chuyenBay;

    @ManyToOne
    @JoinColumn(name = "soHieu")
    private MayBay mayBay;
}
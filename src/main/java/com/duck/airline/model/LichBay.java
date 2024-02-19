package com.duck.airline.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LICHBAY")
public class LichBay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NGAYDI")
    private Date ngayDi;

    @OneToOne
    @JoinColumn(name = "MACB")
    private ChuyenBay chuyenBay;

    @ManyToOne
    @JoinColumn(name = "so_hieu")
    private MayBay mayBay;
}
package com.duck.airline.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "loaimaybay")
public class LoaiMayBay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long maLoai;
    private String hangSanXuat;

    @OneToMany(mappedBy = "loaiMayBay")
    private List<MayBay> mayBayList;


}



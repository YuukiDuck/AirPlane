package com.duck.airline.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "chuyenbay")
@Entity
public class ChuyenBay {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "macb")
    private String maCB;

    @Column(name = "sb_di")
    private String sbDi;

    @Column(name = "sb_den")
    private String sbDen;

    @Column(name = "gio_di")
    private LocalDateTime gioDi;

    @Column(name = "gio_den")
    private LocalDateTime gioDen;

    public ChuyenBay(Long id, String maCB, String sbDi, String sbDen, LocalDateTime gioDi, LocalDateTime gioDen) {
        this.id = id;
        this.maCB = maCB;
        this.sbDi = sbDi;
        this.sbDen = sbDen;
        this.gioDi = gioDi;
        this.gioDen = gioDen;
    }

    public ChuyenBay() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaCB() {
        return maCB;
    }

    public void setMaCB(String maCB) {
        this.maCB = maCB;
    }

    public String getSbDi() {
        return sbDi;
    }

    public void setSbDi(String sbDi) {
        this.sbDi = sbDi;
    }

    public String getSbDen() {
        return sbDen;
    }

    public void setSbDen(String sbDen) {
        this.sbDen = sbDen;
    }

    public LocalDateTime getGioDi() {
        return gioDi;
    }

    public void setGioDi(LocalDateTime gioDi) {
        this.gioDi = gioDi;
    }

    public LocalDateTime getGioDen() {
        return gioDen;
    }

    public void setGioDen(LocalDateTime gioDen) {
        this.gioDen = gioDen;
    }
}
package com.crud.dental.model;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Data
@Entity
@Table(name = "DE")
public class DE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_de")
    private int maDe;

    @Column(name = "thong_tin_de", nullable = false)
    private String thongTinDe;

    @Column(name = "noi_dung_de", nullable = false)
    private String noiDungDe;
}

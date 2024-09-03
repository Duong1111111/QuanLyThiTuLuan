package com.crud.dental.model;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "HS")
public class HS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stt")
    private int stt;

    @Column(name = "so_bao_danh", nullable = false)
    private String soBaoDanh;

    @Column(name = "ho_va_ten", nullable = false)
    private String hoVaTen;

    @Column(name = "ngay_sinh", nullable = false)
    private LocalDate ngaySinh;

    @Column(name = "gioi_tinh", nullable = false, length = 10)
    private String gioiTinh;
}

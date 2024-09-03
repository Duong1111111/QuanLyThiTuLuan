package com.crud.dental.repository;

import com.crud.dental.model.HS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HSRepository implements IHSRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<HS> findAll() {
        String SQL = "SELECT * FROM HS";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(HS.class));
    }

    @Override
    public int save(HS hs) {
        String SQL = "INSERT INTO HS (so_bao_danh, ho_va_ten, ngay_sinh, gioi_tinh) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(SQL, hs.getSoBaoDanh(), hs.getHoVaTen(), hs.getNgaySinh(), hs.getGioiTinh());
    }

    @Override
    public int update(HS hs) {
        String SQL = "UPDATE HS SET so_bao_danh = ?, ho_va_ten = ?, ngay_sinh = ?, gioi_tinh = ? WHERE stt = ?";
        return jdbcTemplate.update(SQL, hs.getSoBaoDanh(), hs.getHoVaTen(), hs.getNgaySinh(), hs.getGioiTinh(), hs.getStt());
    }

    @Override
    public int deleteById(int id) {
        String SQL = "DELETE FROM HS WHERE stt = ?";
        return jdbcTemplate.update(SQL, id);
    }

    @Override
    public HS findById(int id) {
        String SQL = "SELECT * FROM HS WHERE stt = ?";
        return jdbcTemplate.queryForObject(SQL, BeanPropertyRowMapper.newInstance(HS.class), id);
    }
}

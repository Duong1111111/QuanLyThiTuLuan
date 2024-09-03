package com.crud.dental.repository;

import com.crud.dental.model.DE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DERepository implements IDERepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<DE> findAll() {
        String SQL = "SELECT * FROM DE";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(DE.class));
    }

    @Override
    public int save(DE de) {
        String SQL = "INSERT INTO DE (thong_tin_de, noi_dung_de) VALUES (?, ?)";
        return jdbcTemplate.update(SQL, de.getThongTinDe(), de.getNoiDungDe());
    }

    @Override
    public int update(DE de) {
        String SQL = "UPDATE DE SET thong_tin_de = ?, noi_dung_de = ? WHERE ma_de = ?";
        return jdbcTemplate.update(SQL, de.getThongTinDe(), de.getNoiDungDe(), de.getMaDe());
    }

    @Override
    public int deleteById(int id) {
        String SQL = "DELETE FROM DE WHERE ma_de = ?";
        return jdbcTemplate.update(SQL, id);
    }

    @Override
    public DE findById(int id) {
        String SQL = "SELECT * FROM DE WHERE ma_de = ?";
        return jdbcTemplate.queryForObject(SQL, BeanPropertyRowMapper.newInstance(DE.class), id);
    }
}

package com.crud.dental.repository;

import com.crud.dental.model.DE;

import java.util.List;

public interface IDERepository {
    List<DE> findAll();
    int save(DE de);
    int update(DE de);
    int deleteById(int id);
    DE findById(int id);
}

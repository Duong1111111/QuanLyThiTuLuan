package com.crud.dental.repository;

import com.crud.dental.model.HS;

import java.util.List;

public interface IHSRepository {
    List<HS> findAll();
    int save(HS hs);
    int update(HS hs);
    int deleteById(int id);
    HS findById(int id);
}

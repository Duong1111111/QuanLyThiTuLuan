package com.crud.dental.service;

import com.crud.dental.model.DE;

import java.util.List;

public interface IDEService {
    List<DE> findAll();
    int save(DE de);
    int update(DE de);
    int deleteById(int id);
    DE findById(int id);
}

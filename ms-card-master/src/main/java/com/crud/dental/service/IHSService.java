package com.crud.dental.service;

import com.crud.dental.model.HS;

import java.util.List;

public interface IHSService {
    List<HS> findAll();
    int save(HS hs);
    int update(HS hs);
    int deleteById(int stt);
    HS findById(int stt); // Updated to work with the "stt" field
}

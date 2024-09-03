package com.crud.dental.service;

import com.crud.dental.model.HS;
import com.crud.dental.repository.IHSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HSService implements IHSService {

    @Autowired
    private IHSRepository iHSRepository;

    @Override
    public List<HS> findAll() {
        List<HS> list;
        try {
            list = iHSRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
        return list;
    }

    @Override
    public int save(HS hs) {
        int row;
        try {
            row = iHSRepository.save(hs);
        } catch (Exception ex) {
            throw ex;
        }
        return row;
    }

    @Override
    public int update(HS hs) {
        try {
            return iHSRepository.update(hs);
        } catch (Exception ex) {
            // Log the exception (optional)
            throw new RuntimeException("Error updating HS: " + ex.getMessage(), ex);
        }
    }

    @Override
    public int deleteById(int stt) {
        int row;
        try {
            row = iHSRepository.deleteById(stt);
        } catch (Exception ex) {
            throw ex;
        }
        return row;
    }

    @Override
    public HS findById(int stt) {
        return iHSRepository.findById(stt);
    }
}

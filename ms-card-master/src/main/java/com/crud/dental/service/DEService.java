package com.crud.dental.service;

import com.crud.dental.model.DE;
import com.crud.dental.repository.IDERepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DEService implements IDEService {

    @Autowired
    private IDERepository iDERepository;

    @Override
    public List<DE> findAll() {
        try {
            return iDERepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public int save(DE de) {
        try {
            return iDERepository.save(de);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public int update(DE de) {
        try {
            return iDERepository.update(de);
        } catch (Exception ex) {
            throw new RuntimeException("Error updating DE: " + ex.getMessage(), ex);
        }
    }

    @Override
    public int deleteById(int id) {
        try {
            return iDERepository.deleteById(id);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public DE findById(int id) {
        return iDERepository.findById(id);
    }
}

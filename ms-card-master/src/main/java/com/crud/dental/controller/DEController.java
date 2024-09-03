package com.crud.dental.controller;

import com.crud.dental.model.DE;
import com.crud.dental.model.ServiceResponse;
import com.crud.dental.service.IDEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/de")
@CrossOrigin("*")
public class DEController {

    @Autowired
    private IDEService iDEService;

    @GetMapping("/list")
    public ResponseEntity<List<DE>> list() {
        List<DE> result = iDEService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody DE de) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iDEService.save(de);
        if (result == 1) {
            serviceResponse.setMessage("Dữ liệu đã được lưu thành công");
        } else {
            serviceResponse.setMessage("Lưu dữ liệu thất bại");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> updateDE(@RequestBody DE de) {
        ServiceResponse serviceResponse = new ServiceResponse();

        try {
            int result = iDEService.update(de);
            if (result == 1) {
                serviceResponse.setMessage("Cập nhật dữ liệu thành công");
            } else {
                serviceResponse.setMessage("Cập nhật dữ liệu thất bại");
            }
        } catch (Exception e) {
            serviceResponse.setMessage("Đã xảy ra lỗi khi cập nhật dữ liệu: " + e.getMessage());
            return new ResponseEntity<>(serviceResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> delete(@PathVariable int id) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iDEService.deleteById(id);
        if (result == 1) {
            serviceResponse.setMessage("Xóa dữ liệu thành công");
        } else {
            serviceResponse.setMessage("Xóa dữ liệu thất bại");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ServiceResponse> findById(@PathVariable int id) {
        ServiceResponse serviceResponse = new ServiceResponse();
        try {
            DE de = iDEService.findById(id);
            if (de != null) {
                serviceResponse.setSuccess(true);
                serviceResponse.setMessage("Tìm thấy dữ liệu.");
                serviceResponse.setData(de);
            } else {
                serviceResponse.setSuccess(false);
                serviceResponse.setMessage("Không tìm thấy dữ liệu.");
            }
        } catch (Exception e) {
            serviceResponse.setSuccess(false);
            serviceResponse.setMessage("Lỗi: " + e.getMessage());
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
}

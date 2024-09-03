package com.crud.dental.controller;

import com.crud.dental.model.HS;
import com.crud.dental.model.ServiceResponse;
import com.crud.dental.service.IHSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/hs")
@CrossOrigin("*")
public class HSController {

    @Autowired
    private IHSService iHSService;

    @GetMapping("/list")
    public ResponseEntity<List<HS>> list(){
        List<HS> result = iHSService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody HS hs){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iHSService.save(hs);
        if(result == 1){
            serviceResponse.setMessage("Học sinh đã được lưu thành công");
        } else {
            serviceResponse.setMessage("Lưu học sinh thất bại");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> updateHS(@RequestBody HS hs) {
        ServiceResponse serviceResponse = new ServiceResponse();

        try {
            int result = iHSService.update(hs);
            if (result == 1) {
                serviceResponse.setMessage("Cập nhật học sinh thành công");
            } else {
                serviceResponse.setMessage("Cập nhật học sinh thất bại");
            }
        } catch (Exception e) {
            serviceResponse.setMessage("Đã xảy ra lỗi khi cập nhật học sinh: " + e.getMessage());
            return new ResponseEntity<>(serviceResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/delete/{stt}")
    public ResponseEntity<ServiceResponse> delete(@PathVariable int stt){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iHSService.deleteById(stt);
        if(result == 1){
            serviceResponse.setMessage("Xóa học sinh thành công");
        } else {
            serviceResponse.setMessage("Xóa học sinh thất bại");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/find/{stt}")
    public ResponseEntity<ServiceResponse> findById(@PathVariable int stt) {
        ServiceResponse serviceResponse = new ServiceResponse();
        try {
            HS hs = iHSService.findById(stt);
            if (hs != null) {
                serviceResponse.setSuccess(true);
                serviceResponse.setMessage("Tìm thấy học sinh.");
                serviceResponse.setData(hs);
            } else {
                serviceResponse.setSuccess(false);
                serviceResponse.setMessage("Không tìm thấy học sinh.");
            }
        } catch (Exception e) {
            serviceResponse.setSuccess(false);
            serviceResponse.setMessage("Lỗi: " + e.getMessage());
            return new ResponseEntity<>(serviceResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
}

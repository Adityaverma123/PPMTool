package com.example.demo.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;

@Service
public class MapValidationService {
    public ResponseEntity<?> mapValidationService(BindingResult result){

            HashMap<String, String> map = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                map.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<HashMap<String,String>>(map, HttpStatus.BAD_REQUEST);

    }
}

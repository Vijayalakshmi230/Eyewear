package com.examly.service;

import java.util.List;

import com.examly.entity.Eyewear;

public interface  EyewearService {
    
    String addEyewear(Eyewear eyewear);
    String updateEyewear(Eyewear eyewear);
    String deleteEyewear(int eyewearId);
    Eyewear getEyewearById(int eyewearId);
    List<Eyewear> getAllEyewear();
    Eyewear searchByBrand(String brand);
    Eyewear filterBygender(String gender);
}

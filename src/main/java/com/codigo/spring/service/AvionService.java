package com.codigo.spring.service;

import com.codigo.spring.entity.AvionEntity;
import com.codigo.spring.request.AvionRequest;
import com.codigo.spring.response.AvionResponse;

import java.util.List;

public interface AvionService {
    AvionEntity save(AvionRequest avionRequest);
    List<AvionResponse> findAll();
    List<AvionResponse> findAllCapacidad(int min, int max);
}
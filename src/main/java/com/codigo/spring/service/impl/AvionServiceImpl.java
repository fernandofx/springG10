package com.codigo.spring.service.impl;



import com.codigo.spring.entity.AerolineaEntity;
import com.codigo.spring.entity.AvionEntity;
import com.codigo.spring.repository.AerolineaRepository;
import com.codigo.spring.repository.AvionRepository;
import com.codigo.spring.request.AvionRequest;
import com.codigo.spring.response.AvionResponse;
import com.codigo.spring.service.AerolineaService;
import com.codigo.spring.service.AvionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AvionServiceImpl implements AvionService {
    private final AvionRepository avionRepository;
    private final AerolineaRepository aerolineaRepository;


    public AvionServiceImpl(AvionRepository avionRepository, AerolineaRepository aerolineaRepository) {
        this.avionRepository = avionRepository;
        this.aerolineaRepository = aerolineaRepository;
    }

    @Override
    public AvionEntity save(AvionRequest avionRequest) {

       AerolineaEntity aerolinea = aerolineaRepository.findByNombre(avionRequest.getAerolinea());

       AvionEntity avionEntity = new AvionEntity();

       if(aerolinea !=  null){

           avionEntity.setAerolinea(aerolinea);
           avionEntity.setPeso(avionRequest.getPeso());
           avionEntity.setCapacidad(avionRequest.getCapacidad());
           avionEntity.setModelo(avionRequest.getModelo());
           avionRepository.save(avionEntity);
           return avionEntity;
       }

       return null;
    }

    @Override
    public List<AvionResponse> findAll() {
        return List.of();
    }

    @Override
    public List<AvionResponse> findAllCapacidad(int min, int max) {
        List<AvionEntity> list = avionRepository.findByCapacidad(min, max);
        List<AvionResponse> responseList = new ArrayList<>();
        for(AvionEntity avionEntity : list){
            responseList.add(new AvionResponse(
                    avionEntity.getCapacidad(),
                    avionEntity.getModelo(),
                    avionEntity.getPeso(),
                    avionEntity.getAerolinea().getNombre()
            ));
        }
        return responseList;
    }
}
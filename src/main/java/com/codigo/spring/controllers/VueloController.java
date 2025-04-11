package com.codigo.spring.controllers;

import com.codigo.spring.entity.VueloEntity;
import com.codigo.spring.request.VueloRequest;
import com.codigo.spring.response.VueloResponse;
import com.codigo.spring.service.VueloService;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/vuelo")
public class VueloController {

    private VueloService vueloService;

    public VueloController(VueloService vueloService) {
        this.vueloService = vueloService;
    }

    @PostMapping("/save")
    public VueloEntity save(@RequestBody VueloRequest vueloRequest) {
        return vueloService.save(vueloRequest);
    }

    @GetMapping("/find/{id}")
    public VueloResponse findById(@PathVariable int id) {
        return vueloService.findById(id);
    }

    @GetMapping("/find")
    public List<VueloResponse> findByFecha(@RequestParam Date fechaSalida) {
        return vueloService.findAllByFechaSalida(fechaSalida);
    }
}
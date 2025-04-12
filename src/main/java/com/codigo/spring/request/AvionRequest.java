package com.codigo.spring.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvionRequest {

    private int capacidad;
    private int peso;
    private String modelo;
    private String aerolinea;

}

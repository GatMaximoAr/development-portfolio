/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProyectoDto {
    
    private Long id;
    
    private String titulo;
    
    private String imagen;
    
    private String vinculo_img;
    
    private String sobre_proyecto;

    public ProyectoDto() {
    }

    public ProyectoDto(Long id, String titulo, String imagen, String vinculo_img, String sobre_proyecto) {
        this.id = id;
        this.titulo = titulo;
        this.imagen = imagen;
        this.vinculo_img = vinculo_img;
        this.sobre_proyecto = sobre_proyecto;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EducacionDto {
    
    private Long id;
    
    private String titulo_des;
    
    private String imagen;
    
    private String vinculo_img;
    
    private String sobre_educacion;
    

    public EducacionDto() {
    }

    public EducacionDto(Long id, String titulo_des, String imagen, String vinculo_img, String sobre_educacion) {
        this.id = id;
        this.titulo_des = titulo_des;
        this.imagen = imagen;
        this.vinculo_img = vinculo_img;
        this.sobre_educacion = sobre_educacion;
    }
    
    
}

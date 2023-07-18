/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExperienciaDto {
    
    private Long id;
    
    private String img_experiencia;
    
    private String img_href;
    
    private String sobre_experiencia;
    
    private Set<String> actividad = new HashSet<>();

    public ExperienciaDto() {
    }

    public ExperienciaDto(Long id, String img_experiencia, String img_href, String sobre_experiencia) {
        this.id = id;
        this.img_experiencia = img_experiencia;
        this.img_href = img_href;
        this.sobre_experiencia = sobre_experiencia;
    }
    
    public void addActividad(String Act) {
        
        this.actividad.add(Act);
    }
}

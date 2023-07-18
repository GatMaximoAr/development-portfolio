/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SkillDto {
    
    private Long id;
    private String titulo;
    private int porcentaje;
    private String color;

    public SkillDto() {
    }

    public SkillDto(Long id, String titulo, int porcentaje, String color) {
        this.id = id;
        this.titulo = titulo;
        this.porcentaje = porcentaje;
        this.color = color;
    }
    
    
}

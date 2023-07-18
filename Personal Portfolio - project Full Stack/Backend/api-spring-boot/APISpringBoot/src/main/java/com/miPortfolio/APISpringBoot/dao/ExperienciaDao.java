/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.dao;

import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class ExperienciaDao {
    
    private String img_experiencia;
    
    private String img_href;
    
    private String sobre_experiencia;
    
    private List<String> actividad;
    

    public ExperienciaDao() {
    }

    public ExperienciaDao(String img_experiencia, String img_href, String sobre_experiencia, List<String> actividad) {
        this.img_experiencia = img_experiencia;
        this.img_href = img_href;
        this.sobre_experiencia = sobre_experiencia;
        this.actividad = actividad;
    }
    
    
}

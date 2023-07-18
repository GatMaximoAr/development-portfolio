/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.dao;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EducacionDao {
    
    private String titulo_des;
    
    private String imagen;
    
    private String vinculo_img;
    
    private String sobre_educacion;

    public EducacionDao() {
    }

    public EducacionDao(String titulo_des, String imagen, String vinculo_img, String sobre_educacion) {
        this.titulo_des = titulo_des;
        this.imagen = imagen;
        this.vinculo_img = vinculo_img;
        this.sobre_educacion = sobre_educacion;
    }
    
    
}

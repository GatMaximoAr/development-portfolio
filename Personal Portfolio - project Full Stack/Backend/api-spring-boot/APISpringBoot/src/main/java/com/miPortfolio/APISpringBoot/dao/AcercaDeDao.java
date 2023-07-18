/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.dao;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AcercaDeDao {
    
    private String nombre_usuario;
    
    private String apellido_usuario;
    
    private String imagen;
    
    private String sobre_usuario;
    
    private String ocupacion;

    private String img_portada;

    
    public AcercaDeDao() {
    }

    public AcercaDeDao(String nombre_usuario, String apellido_usuario, String imagen, String sobre_usuario, String ocupacion, String img_portada) {
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.imagen = imagen;
        this.sobre_usuario = sobre_usuario;
        this.ocupacion = ocupacion;
        this.img_portada = img_portada;
    }
    
    
}

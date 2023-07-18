
package com.miPortfolio.APISpringBoot.dao;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class ProyectoDao {

    private String titulo;
    
    private String imagen;
    
    private String vinculo_img;
    
    private String sobre_proyecto;

    public ProyectoDao() {
    }

    public ProyectoDao(String titulo, String imagen, String vinculo_img, String sobre_proyecto) {
        this.titulo = titulo;
        this.imagen = imagen;
        this.vinculo_img = vinculo_img;
        this.sobre_proyecto = sobre_proyecto;
    }
    
    
}

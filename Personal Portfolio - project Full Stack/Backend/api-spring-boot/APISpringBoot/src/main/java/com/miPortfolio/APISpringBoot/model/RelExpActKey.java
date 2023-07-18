/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Embeddable
public class RelExpActKey implements Serializable {
    
    @Column(name = "usaurio_id")
    private Long usuarioId;
    
    @Column(name = "experiencia_id")
    private Long experienciaId;
    
    @Column(name = "actividad_id")
    private Long actividadId;

    public RelExpActKey() {
    }

    public RelExpActKey(Long usuarioId, Long experienciaId, Long actividadId) {
        this.usuarioId = usuarioId;
        this.experienciaId = experienciaId;
        this.actividadId = actividadId;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public int hashCode() {
        return super.hashCode(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
   
   
}

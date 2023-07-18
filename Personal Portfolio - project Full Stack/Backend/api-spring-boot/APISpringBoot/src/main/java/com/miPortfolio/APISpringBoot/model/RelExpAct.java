/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class RelExpAct implements Serializable {
    
    @EmbeddedId
    private RelExpActKey id;
    
    @ManyToOne
    @MapsId("experienciaId")
    @JsonBackReference(value = "exp")
    @JoinColumn(name = "experiencia_id")
    Experiencia experiencia;
    
    @ManyToOne
    @MapsId("actividadId")
    @JsonBackReference(value = "act")
    @JoinColumn(name = "actividad_id")
    ActividadExp actividadExp;

    public RelExpAct() {
    }

    public RelExpAct(Experiencia experiencia, ActividadExp actividadExp) {
        this.id = new RelExpActKey(experiencia.getUser().getId(), experiencia.getId(),
                actividadExp.getId());
        this.experiencia = experiencia;
        this.actividadExp = actividadExp;
    }
    
    
}

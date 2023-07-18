/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.model;

import com.miPortfolio.APISpringBoot.security.model.Usuario;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "skills")
@Getter @Setter
@Entity
public class Skill implements Serializable{
    
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "skill_generator")
    @SequenceGenerator (name = "skill_generator", sequenceName = "proyecto_sq")
    private Long id;
    
    private String titulo;
    
    private int porcentaje;
    
    private String color;
    
    
    @ManyToOne
    @JoinColumn (name = "usuario_id")
    private Usuario user;

    public Skill() {
    }

    public Skill(String titulo, int porcentaje, String color, Usuario user) {
        this.titulo = titulo;
        this.porcentaje = porcentaje;
        this.color = color;
        this.user = user;
    }

    
    
    
}

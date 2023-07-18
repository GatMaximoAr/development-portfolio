
package com.miPortfolio.APISpringBoot.model;

import com.miPortfolio.APISpringBoot.security.model.Usuario;
import java.io.Serializable;
import javax.persistence.Column;
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


@Table (name = "proyectos")
@Setter @Getter
@Entity
public class Proyecto implements Serializable{
    
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "proyecto_generator")
    @SequenceGenerator (name = "proyecto_generator", sequenceName = "proyecto_sq", initialValue = 1)
    private Long id;
    
    private String titulo;
    
    private String imagen;
    
    private String vinculo_img;
    
    @Column (columnDefinition = "TEXT")
    private String sobre_proyecto;
    
    /*Relacion muchos a uno con clase entity "Usuario" */
    
    
    //@JsonManagedReference(value = "el pro1")//Serializacion "Json de referencia"
    @ManyToOne
    @JoinColumn (name = "usuario_id")
    private Usuario user;
    
    
    /*Relacion ManyToMany entre Experiencia --> Actividades*/
    
    
    
    /* Costructores*/

    public Proyecto() {
    }

    public Proyecto(String titulo, String imagen, String vinculo_img, String sobre_proyecto, Usuario user) {
        this.titulo = titulo;
        this.imagen = imagen;
        this.vinculo_img = vinculo_img;
        this.sobre_proyecto = sobre_proyecto;
        this.user = user;
    }

    
    
    
}

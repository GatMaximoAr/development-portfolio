
package com.miPortfolio.APISpringBoot.model;

import com.miPortfolio.APISpringBoot.security.model.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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


@Table (name = "formaciones")
@Setter @Getter
@Entity
public class Educacion implements Serializable{
    
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "educacion_generator")
    @SequenceGenerator (name = "educacion_generator", sequenceName = "educacion_sq", initialValue = 1)
    private Long id;
    
    @Column (name = "titulo")
    private String titulo_des;
    
    @Column (columnDefinition = "TEXT")
    private String imagen;
    
    private String vinculo_img;
    
    @Column (columnDefinition = "TEXT")
    private String sobre_educacion;
    
    
    /*Relacion muchos a uno con clase entity "Usuario" */
    
    
    //@JsonManagedReference(value = "eduUser")  //Serializacion "Json de referencia"
    @ManyToOne
    @JoinColumn (name = "usuario_id")
    private Usuario user;

    /* Costructores*/
    
    public Educacion() {
    }

    public Educacion(String titulo_des, String imagen, String vinculo_img, String sobre_educacion, Usuario user) {
        this.titulo_des = titulo_des;
        this.imagen = imagen;
        this.vinculo_img = vinculo_img;
        this.sobre_educacion = sobre_educacion;
        this.user = user;
    }

    

}

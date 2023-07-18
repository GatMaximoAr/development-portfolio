
package com.miPortfolio.APISpringBoot.model;

import com.miPortfolio.APISpringBoot.security.model.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;


//proximo inicio de 0 BD custimizar table name
@Table (name = "acercaDe_usuarios")
@Entity
@Getter @Setter
public class AcercaDe implements Serializable{
    
    /* 
        Tabla Acerca_de_usuario Primary key generada automaticamente de forma
        secuencial, tabla de secuencia propia
    */
    
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "acercaDe_generator")
    @SequenceGenerator (name = "acercaDe_generator", sequenceName = "acercaDe_sq")
    private Long id;
    
    /* Nombre de las columnas customizado*/
    
    @Column (name = "nombre")
    private String nombre_usuario;
    
    @Column (name = "apellido")
    private String apellido_usuario;
    
    @Column (name = "imagen_perfil")
    private String imagen;
    
    @Column (columnDefinition = "TEXT", name = "sobre_usuario")
    private String sobre_usuario;
    
    @Column (name = "ocupacion")
    private String ocupacion;

    @Column (name = "portada")
    private String img_portada;
    
    
    /* Relacion 1-1 con clase entidad "Usuario", (no fuciona como quisiera: no se
        se puede borrar unicamente el registro AcercaDe asociado, depende de 
        la existencia de father) children */
    
    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    /* Costructores*/
    
    public AcercaDe() {
    }

    public AcercaDe(String nombre_usuario, String apellido_usuario, String imagen, String sobre_usuario, String ocupacion, String img_portada, Usuario usuario) {
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.imagen = imagen;
        this.sobre_usuario = sobre_usuario;
        this.ocupacion = ocupacion;
        this.img_portada = img_portada;
        this.usuario = usuario;
    }

    

    

    
    
    
}

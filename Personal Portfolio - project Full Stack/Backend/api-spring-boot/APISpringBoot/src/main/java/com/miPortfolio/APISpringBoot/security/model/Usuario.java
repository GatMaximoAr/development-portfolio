
package com.miPortfolio.APISpringBoot.security.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.miPortfolio.APISpringBoot.model.Educacion;
import com.miPortfolio.APISpringBoot.model.Experiencia;
import com.miPortfolio.APISpringBoot.model.Proyecto;
import com.miPortfolio.APISpringBoot.model.Skill;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
@Table (name = "usuarios")
public class Usuario implements Serializable{
    
    /* 
        Tabla usuario Primary key generada automaticamente de forma
        secuencial, tabla de secuencia propia
    */
    
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "usuario_generator")
    @SequenceGenerator (name = "usuario_generator", sequenceName = "usuario_sq")
    private Long id;
    
    /* Nombre de las columnas customizado*/
    @Column (name = "usuario", unique = true, nullable = false)
    private String nombreUsuario;
    
    
    @Column (name = "password", nullable = false)
    private String password;
    
    @Column(nullable = false)
    private String email;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();
    
    
    /* Relacion 1-1 con clase entidad "AcercaDe", (no fuciona como quisiera)  */
    
  
    
    /*Relacion uno a muchos con clase entity "Experiencia" */
    
    @JsonBackReference (value = "experiencia")
    @OneToMany (mappedBy = "user",
                cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Experiencia> exp;  // cambiar a experiencias
    
    
    /*Relacion uno a muchos con clase entity "Educacion" */
    
    @JsonBackReference (value = "formaciones")
    @OneToMany (mappedBy = "user",
                cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Educacion> formaciones;
    
    /*Relacion uno a muchos con clase entity "Proyecto" */
    
    @JsonBackReference (value = "proyectos")
    @OneToMany (mappedBy = "user",
                cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Proyecto> proyectos;
    
    /*Relacion uno a muchos con clase entity "Skill" */
    
    @JsonBackReference (value = "skills")
    @OneToMany (mappedBy = "user",
                cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Skill> skills;
    
    /* Costructores*/
    
    public Usuario() {}

    public Usuario(String nombreUsuario, String password, String email) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.email = email;
    }

    
}

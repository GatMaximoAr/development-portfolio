
package com.miPortfolio.APISpringBoot.model;

import com.miPortfolio.APISpringBoot.security.model.Usuario;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;


//@Transactional
@Getter @Setter
@Entity
//proximo inicio de 0 BD custimizar table name
public class Experiencia implements Serializable{
    
    /* 
        Tabla experiencia Primary key generada automaticamente de forma
        secuencial, tabla de secuencia propia
    */
    
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "exp_generator")
    @SequenceGenerator (name = "exp_generator", sequenceName = "exp_sq", initialValue = 1)
    private Long id;
    
    /* Nombre de las columnas customizado*/
    
    @Column(name ="imgen_experiencia" )
    private String img_experiencia;
    
    private String img_href;
    
    @Column(columnDefinition = "TEXT")
    private String sobre_experiencia;
    
    /*Relacion muchos a uno con clase entity "Usuario" */

    //@JsonManagedReference(value = "userxp") //Serializacion "Json de referencia"
    @ManyToOne
    @JoinColumn (name = "usuario_id")
    private Usuario user;
    
    
   /*Relacion ManyToMany entre Experiencia --> Actividades*/
    
    
    //@JsonBackReference(value = "act")
    @OneToMany(mappedBy = "experiencia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<RelExpAct> relaciones;
    
    
    
    /*Metodos: agregar y remover, coleccion de Actividades*/
    
  /*  public void addActividad(ActividadExp act) {
        
        this.actividad.add(act);
    }
    
    public void removeObject(ActividadExp actividad) {
        this.actividad.remove(actividad);
    } */
    
    /* Costructores*/
    
    public Experiencia() {
    }

    public Experiencia(String img_experiencia, String img_href, String sobre_experiencia, Usuario user) {
        this.img_experiencia = img_experiencia;
        this.img_href = img_href;
        this.sobre_experiencia = sobre_experiencia;
        this.user = user;
    } 

    public Experiencia(Long id, String img_experiencia, String img_href, String sobre_experiencia, Usuario user) {
        this.id = id;
        this.img_experiencia = img_experiencia;
        this.img_href = img_href;
        this.sobre_experiencia = sobre_experiencia;
        this.user = user;
    }
    
    
    
}


package com.miPortfolio.APISpringBoot.interfaces;

import com.miPortfolio.APISpringBoot.model.Proyecto;
import java.util.List;



public interface IProyecto {
    
    public void saveProyecto(Proyecto proyecto);
    
    public void deleteProyectoById(Long id);
    
    public List<Proyecto> getAllProyectos();
    
    public Proyecto getProyectoById(Long id);
}

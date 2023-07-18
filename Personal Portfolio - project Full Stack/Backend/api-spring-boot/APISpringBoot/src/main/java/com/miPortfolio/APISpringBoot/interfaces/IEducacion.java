
package com.miPortfolio.APISpringBoot.interfaces;

import com.miPortfolio.APISpringBoot.model.Educacion;
import java.util.List;


public interface IEducacion {
    
    public void saveEducacion(Educacion educacion);
    
    public void deleteEducacionById(Long id);
    
    public List<Educacion> getAllFormaciones();
    
    public Educacion getEducacionById(Long id);
}

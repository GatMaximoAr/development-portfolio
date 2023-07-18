
package com.miPortfolio.APISpringBoot.interfaces;

import com.miPortfolio.APISpringBoot.model.Experiencia;
import java.util.List;

/*interface Experiencia metodos CRUD basicos*/

public interface IExperiencia {
    
    public void saveExperiencia(Experiencia experiencia);
    
    public void deleteExperienciaById(Long id);
    
    public List<Experiencia> getAllExperiencias();
    
    public Experiencia getExperienciaById(Long id);
}

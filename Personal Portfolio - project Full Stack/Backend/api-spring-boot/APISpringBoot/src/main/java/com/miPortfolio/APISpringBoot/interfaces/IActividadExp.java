
package com.miPortfolio.APISpringBoot.interfaces;

import com.miPortfolio.APISpringBoot.model.ActividadExp;
import java.util.List;
import java.util.Set;

/*interface ActividadExp metodos CRUD basicos*/

public interface IActividadExp {
    
    public void saveActividadExp(ActividadExp actExp);
    
    public void deleteActividadExpById(Long id);
    
    public List<ActividadExp> getAllActividadExps();
    
    public ActividadExp getActividadExpById(Long id);
    
    public boolean existById(Long id);
    
    public boolean existByActividad(String act);
    
    public ActividadExp findByActividad(String act);
    
    public boolean verificaExistenciaAct(Set<ActividadExp> _exp, List<ActividadExp> _act);
}

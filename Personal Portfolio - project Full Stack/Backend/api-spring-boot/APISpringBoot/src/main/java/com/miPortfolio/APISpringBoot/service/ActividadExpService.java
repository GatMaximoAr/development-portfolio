
package com.miPortfolio.APISpringBoot.service;

import com.miPortfolio.APISpringBoot.interfaces.IActividadExp;
import com.miPortfolio.APISpringBoot.model.ActividadExp;
import com.miPortfolio.APISpringBoot.repository.ActividadExpRepository;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class ActividadExpService implements IActividadExp{

    @Autowired
    private ActividadExpRepository repository;
    
    @Override
    public void saveActividadExp(ActividadExp actExp) {
        
        repository.save(actExp);
    }

    @Override
    public void deleteActividadExpById(Long id) {
        
        repository.deleteById(id);
    }

    @Override
    public List<ActividadExp> getAllActividadExps() {

        return repository.findAll();
    }

    @Override
    public ActividadExp getActividadExpById(Long id) {

        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "No se encontro el recurso solicitado"));
    }

    @Override
    public boolean existById(Long id) {
        
        return repository.existsById(id);
    }
    
    /* Si existe Actividad recibe String, devuelve true si hay
       registros, else false*/
    
    @Override
    public boolean existByActividad(String act) {
        
        return repository.existsByActividad(act);
    }
    
    /* Devuelve un objeto Actividad que coincida con el parametro String */
    
    @Override
    public ActividadExp findByActividad(String act) {
        
        return repository.findByActividad(act);
    }
    
    /* Verifica que un registro de actividad este en las dos listas Actividades
       una es de Actividad entity y la otra esta enlazada con Experiencia,
       en caso de que los registros coincidan devuelve true, else false*/
    
    @Override
    public boolean verificaExistenciaAct(Set<ActividadExp> _exp, List<ActividadExp> _act) {
        
        boolean retorno = false;
        
        for (ActividadExp actividadExp : _act) {
            for (ActividadExp actividadExp1 : _exp) {
                if (actividadExp.getActividad().equalsIgnoreCase(actividadExp1.getActividad())) {
                    retorno = true;
                }
            }
        }
        return retorno;
    }
    
}

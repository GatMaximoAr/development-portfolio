
package com.miPortfolio.APISpringBoot.service;

import com.miPortfolio.APISpringBoot.interfaces.IEducacion;
import com.miPortfolio.APISpringBoot.model.Educacion;
import com.miPortfolio.APISpringBoot.repository.EducacionRepository;
import com.miPortfolio.APISpringBoot.security.model.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class EducacionService implements IEducacion{
    
    @Autowired private EducacionRepository repository;

    @Override
    public void saveEducacion(Educacion educacion) {
        
        repository.save(educacion);
    }

    @Override
    public void deleteEducacionById(Long id) {
        
        repository.deleteById(id);
    }

    @Override
    public List<Educacion> getAllFormaciones() {
        
        return repository.findAll();
    }

    @Override
    public Educacion getEducacionById(Long id) {
        
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "No se encontro el recurso solicitado"));
        
        //NO_CONTENT seria interesante de explorar
    }
    
    
    public List<Educacion> findAllByUser(Usuario user) {
        return repository.findAllByUser(user);
    }
}

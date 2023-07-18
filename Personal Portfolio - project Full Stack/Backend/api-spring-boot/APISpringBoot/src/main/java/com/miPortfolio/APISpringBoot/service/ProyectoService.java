
package com.miPortfolio.APISpringBoot.service;

import com.miPortfolio.APISpringBoot.interfaces.IProyecto;
import com.miPortfolio.APISpringBoot.model.Proyecto;
import com.miPortfolio.APISpringBoot.repository.ProyectoRepository;
import com.miPortfolio.APISpringBoot.security.model.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class ProyectoService implements IProyecto{
  
    @Autowired private ProyectoRepository repository;

    @Override
    public void saveProyecto(Proyecto proyecto) {
        
        repository.save(proyecto);
    }

    @Override
    public void deleteProyectoById(Long id) {
        
        repository.deleteById(id);
    }

    @Override
    public List<Proyecto> getAllProyectos() {
        
        return repository.findAll();
    }

    @Override
    public Proyecto getProyectoById(Long id) {
        
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "No se encontro el recurso solicitado"));
    }
    
    public List<Proyecto> findAllByUser(Usuario user) {
        return repository.findAllByUser(user);
    }
    
}

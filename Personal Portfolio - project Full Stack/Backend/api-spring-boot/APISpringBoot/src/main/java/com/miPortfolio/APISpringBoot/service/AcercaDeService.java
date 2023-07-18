/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.service;

import com.miPortfolio.APISpringBoot.interfaces.IAcercaDe;
import com.miPortfolio.APISpringBoot.model.AcercaDe;
import com.miPortfolio.APISpringBoot.repository.AcercaDeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AcercaDeService implements IAcercaDe{
    
    @Autowired
    private AcercaDeRepository repository;

    @Override
    public void saveAcercaDe(AcercaDe acercaDe) {
        
        repository.save(acercaDe);
    }

    
    @Override
    public void deleteAcercaDeById(Long id) {
        
        repository.deleteById(id);
    }

    @Override
    public List<AcercaDe> getAllAcercaDe() {
        
        return repository.findAll();
    }
 
   
    @Override
    public AcercaDe getAcercaDeById(Long id) {
        
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "No se encontro el recurso solicitado"));
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.service;

import com.miPortfolio.APISpringBoot.model.Experiencia;
import com.miPortfolio.APISpringBoot.model.RelExpAct;
import com.miPortfolio.APISpringBoot.model.RelExpActKey;
import com.miPortfolio.APISpringBoot.repository.RelExpActRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelExpActService {
    
    @Autowired RelExpActRepository repostory;
    
    public void saveRelacion(RelExpAct entity) {
        
        repostory.save(entity);
    }
    
    public List<RelExpAct> findAllRelaciones() {
        
        return repostory.findAll();
    }
    
    public void deleteById(RelExpActKey key) {
        
        repostory.deleteById(key);
    }
    
    public void deleteAllByExperiencia(Experiencia experiencia) {
        repostory.deleteAllByExperiencia(experiencia);
    }
}

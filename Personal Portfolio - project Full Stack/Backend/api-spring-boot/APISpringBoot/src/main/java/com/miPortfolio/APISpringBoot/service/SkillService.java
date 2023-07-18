/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.service;

import com.miPortfolio.APISpringBoot.model.Skill;
import com.miPortfolio.APISpringBoot.repository.SkillRepository;
import com.miPortfolio.APISpringBoot.security.model.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SkillService {
    
    @Autowired private SkillRepository repository;
    
    public void saveSkill(Skill skill) {
        repository.save(skill);
    }
    
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
    public List<Skill> getAllSkills() {
        return repository.findAll();
    }
    
    public Skill getSkillById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "No se encontro el recurso solicitado"));
    }
    
    
    public List<Skill> findAllByUser(Usuario user) {
        
        return repository.findAllByUser(user);
    }
    
}

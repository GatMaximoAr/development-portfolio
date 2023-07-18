/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.security.service;

import com.miPortfolio.APISpringBoot.security.enums.RolNombre;
import com.miPortfolio.APISpringBoot.security.model.Rol;
import com.miPortfolio.APISpringBoot.security.repository.RolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    
    @Autowired private RolRepository repository;
    
    public Optional<Rol> findByRolNombre(RolNombre rolNombre) {
        return repository.findByRolNombre(rolNombre);
    }
    
    public void saveRol(Rol rol) {
        repository.save(rol);
    }
}

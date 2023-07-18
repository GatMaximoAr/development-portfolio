/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.security.service;

import com.miPortfolio.APISpringBoot.interfaces.IUsuario;
import com.miPortfolio.APISpringBoot.security.model.Usuario;
import com.miPortfolio.APISpringBoot.security.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
@Transactional
public class UsuarioService implements IUsuario{

    @Autowired
            
    private UsuarioRepository repository;
    
    @Override
    public void saveUsuario(Usuario usuario) {
        repository.save(usuario);
    }

    @Override
    public void deleteUsuarioById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return repository.findAll();
    }
    

    @Override
    public Usuario getUsuarioById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "No se encontro el recurso solicitado"));
    }
    
    public Usuario findByNombreUsuario(String nombreUsuario) {
        return repository.findByNombreUsuario(nombreUsuario).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "No se encontro el recurso solicitado"));
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario) {
        return repository.existsByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }
    
}

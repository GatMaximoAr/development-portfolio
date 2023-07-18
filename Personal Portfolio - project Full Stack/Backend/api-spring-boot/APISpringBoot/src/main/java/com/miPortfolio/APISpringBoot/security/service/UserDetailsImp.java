/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.security.service;

import com.miPortfolio.APISpringBoot.security.model.Usuario;
import com.miPortfolio.APISpringBoot.security.model.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class UserDetailsImp implements UserDetailsService{
    
    @Autowired UsuarioService userService;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = userService.findByNombreUsuario(nombreUsuario);
        
        UsuarioPrincipal principal = new UsuarioPrincipal(usuario.getNombreUsuario(),
                usuario.getEmail(), usuario.getPassword());
        
        principal.build(usuario);
        
        return principal;
    }
    
}

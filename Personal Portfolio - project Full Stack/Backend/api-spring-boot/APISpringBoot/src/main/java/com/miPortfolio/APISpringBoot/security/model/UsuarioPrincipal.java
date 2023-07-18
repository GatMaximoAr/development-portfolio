/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.security.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author maximo
 */
public class UsuarioPrincipal implements UserDetails{
    
    private String nombreUsuario;
    
    private String email;
    
    private String password;
    
    private Collection<? extends GrantedAuthority> authorities;

    public UsuarioPrincipal(String nombreUsuario, String email, String password) {
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
    }
    
    public void build(Usuario usuario) {
        
        List<GrantedAuthority> authorities = new ArrayList<>();
        
        for (Rol rol : usuario.getRoles()) {
            
           SimpleGrantedAuthority role = new SimpleGrantedAuthority(rol.getRolNombre()
                   .name());
           
           authorities.add(role);
           
        }
        setAuthorities(authorities);
        
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setAuthorities(List<GrantedAuthority> authorities){
        this.authorities = authorities;
    }
    
}

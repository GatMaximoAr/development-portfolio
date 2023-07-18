/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.security.controller;

import com.miPortfolio.APISpringBoot.logica.Mensaje;
import com.miPortfolio.APISpringBoot.security.dto.JwtDto;
import com.miPortfolio.APISpringBoot.security.dto.LoginUsuario;
import com.miPortfolio.APISpringBoot.security.dto.NuevoUsuario;
import com.miPortfolio.APISpringBoot.security.enums.RolNombre;
import com.miPortfolio.APISpringBoot.security.jwt.JwtProvider;
import com.miPortfolio.APISpringBoot.security.model.Rol;
import com.miPortfolio.APISpringBoot.security.model.Usuario;
import com.miPortfolio.APISpringBoot.security.service.RolService;
import com.miPortfolio.APISpringBoot.security.service.UsuarioService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired private PasswordEncoder passwordEncoder;
    
    @Autowired private AuthenticationManager authenticationManager;
    
    @Autowired private UsuarioService usuarioService;
    
    @Autowired private RolService rolService;
    
    @Autowired private JwtProvider jwtProvider;
    
    @PostMapping("/singUp")
    public ResponseEntity<?> nuevo(@Validated @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult ) {
        if (bindingResult.hasErrors()) {
            
            return new ResponseEntity<>(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
        }
        
        if (usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario())) {
            return new ResponseEntity<>(new Mensaje("el usuario ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        if (usuarioService.existsByEmail(nuevoUsuario.getEmail())) {
            return new ResponseEntity<>(new Mensaje("el email ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Usuario usuario =
                new Usuario(nuevoUsuario.getNombreUsuario(),
                        passwordEncoder.encode(nuevoUsuario.getPassword()),
                        nuevoUsuario.getEmail());
        
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.findByRolNombre(RolNombre.ROLE_USER).get());
        if (nuevoUsuario.getRoles().contains("admin")) {
            roles.add(rolService.findByRolNombre(RolNombre.ROLE_ADMIN).get());
        }
        usuario.setRoles(roles);
        usuarioService.saveUsuario(usuario);
        return new ResponseEntity<>(new Mensaje("usuario creado"), HttpStatus.CREATED);
    }
    
    @PostMapping("/singIn")
    public ResponseEntity<JwtDto> login(@Validated @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
        
        System.out.println("aca llego");
        
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
        
        //System.out.println(authentication.getName());
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtProvider.generateToken(authentication);
      
        //System.out.println(jwt);
        
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity<>(jwtDto, HttpStatus.OK );
        
    }
    
    @GetMapping("/usuario/exist/{usuario}")
    public boolean exitsByUsuario(@PathVariable String usuario) {
        
        return usuarioService.existsByNombreUsuario(usuario);
    }
    
}

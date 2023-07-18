/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.controller;

import com.miPortfolio.APISpringBoot.dao.AcercaDeDao;
import com.miPortfolio.APISpringBoot.dto.AcercaDeDto;
import com.miPortfolio.APISpringBoot.logica.LogicaAcercaDe;
import com.miPortfolio.APISpringBoot.logica.Mensaje;
import com.miPortfolio.APISpringBoot.service.AcercaDeService;
import com.miPortfolio.APISpringBoot.model.AcercaDe;
import com.miPortfolio.APISpringBoot.security.model.Usuario;
import com.miPortfolio.APISpringBoot.security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/* Controler de end point AcercaDe */


//@CrossOrigin (origins = "http://localhost:4200/")
@RestController
public class AcercaDeController {
    
    // 2 injecciones necesarias
    
    @Autowired private AcercaDeService serviceAcerca;
    
    @Autowired private UsuarioService serviceUsuario;
    
    @Autowired private LogicaAcercaDe logicaAcercaDe;
    
    //Crea si no hay registros, else Mensaje
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("acerca/usuario/{id}/crear")
    public ResponseEntity<AcercaDeDto> saveUsuarios(@PathVariable String id, @RequestBody AcercaDeDao dao) {
        
        Usuario user = serviceUsuario.findByNombreUsuario(id);
        
        return logicaAcercaDe.crearAcerca(dao, user);
    }
    
    //Trae todos
    
    @GetMapping ("/acerca/{usuario}/")
    public AcercaDeDto getAllUsuarios(@PathVariable String usuario) {
        
        Usuario user = serviceUsuario.findByNombreUsuario(usuario);
        
        return logicaAcercaDe.getUserAcerca(user);
    }
    
    //trae 1 por id
    
    @GetMapping ("/acerca/{id}/traer")
    public AcercaDe getAcercaDeById(@PathVariable Long id) {
        
        return serviceAcerca.getAcercaDeById(id);
    }
    
    
    //edita 1 por id 
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/acerca/editar/{id}")
    public ResponseEntity<Mensaje> editAcercaDe(@PathVariable Long id,
                                                 @RequestBody AcercaDeDao dao) {
        
        AcercaDe editAcerca = serviceAcerca.getAcercaDeById(id);
        
        
        return logicaAcercaDe.editAcerca(dao, editAcerca);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/delete/acerca/{id}")
    public ResponseEntity<Mensaje> deleteAcercaDe(@PathVariable Long id) {
        
        serviceAcerca.deleteAcercaDeById(id);
        
        return new ResponseEntity<>(new Mensaje("Acerca de eliminado"), HttpStatus.OK);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.controller;

import com.miPortfolio.APISpringBoot.dao.ProyectoDao;
import com.miPortfolio.APISpringBoot.dto.ProyectoDto;
import com.miPortfolio.APISpringBoot.logica.LogicaProyecto;
import com.miPortfolio.APISpringBoot.logica.Mensaje;
import com.miPortfolio.APISpringBoot.model.Proyecto;
import com.miPortfolio.APISpringBoot.security.model.Usuario;
import com.miPortfolio.APISpringBoot.service.ProyectoService;
import com.miPortfolio.APISpringBoot.security.service.UsuarioService;
import java.util.List;
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


//@CrossOrigin (origins = "http://localhost:4200/")
@RestController
public class ProyectoController {
    
    @Autowired private ProyectoService proService;
    
    @Autowired private UsuarioService userService;
    
    @Autowired private LogicaProyecto logicaService;
    
    // Crea
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/proyecto/usuario/{id}/crear")
    public ResponseEntity<ProyectoDto> saveProyecto(@PathVariable String id,
                                   @RequestBody ProyectoDao dao) {
                                   
        Usuario user = userService.findByNombreUsuario(id);
        
        
        return logicaService.crearProyecto(dao, user);
    }
    
    
    //Trae todos
    
    @GetMapping ("/proyecto/traer")
    public List<ProyectoDto> getAllProyectos() {
        
        return logicaService.traerDtos();
    }
    
    //Trae 1 por id
    
    @GetMapping ("/proyecto/{id}/traer")
    public Proyecto getProyectoById(@PathVariable Long id) {
        
        return proService.getProyectoById(id);
    }
    
    @GetMapping("/proyectos/{usuario}/traer")
    public List<ProyectoDto> getProyectosUsuario(@PathVariable String usuario) {
        
        Usuario user = userService.findByNombreUsuario(usuario);
        
        return logicaService.getProyectosUsuario(user);
    }
    
    //Elimina 1 por id
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/proyecto/delete/{id}")
    public ResponseEntity<Mensaje> deleteProyectoById(@PathVariable Long id) {
        
        proService.deleteProyectoById(id);
        
        return new ResponseEntity<>(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
    
    //Edita 1 por id 
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/proyecto/editar/{id}")
    public ResponseEntity<Mensaje>editarProyecto(@PathVariable Long id,
                                                @RequestBody ProyectoDao dao) {
        
        
        Proyecto editProyec = proService.getProyectoById(id);
        
        
        return logicaService.editarProyecto(editProyec, dao);
    }
}

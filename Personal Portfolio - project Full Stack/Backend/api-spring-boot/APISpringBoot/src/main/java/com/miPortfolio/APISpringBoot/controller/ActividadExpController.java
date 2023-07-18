/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.controller;

import com.miPortfolio.APISpringBoot.model.ActividadExp;
import com.miPortfolio.APISpringBoot.model.Experiencia;
import com.miPortfolio.APISpringBoot.service.ActividadExpService;
import com.miPortfolio.APISpringBoot.service.ExperienciaService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ActividadExpController {
    
    @Autowired private ActividadExpService ActExpService;
    
    @Autowired private ExperienciaService expService;
    
   /* @GetMapping ("/booleano")
    public String qteEncuentro() {
        
        if (ActExpService.findIntento("cuartetoooo!")) {
            return "funciona";
        }else {
            return "No funciona";
        }
    }*/
    
    // Crea
    
    /* Si no existe un registro de actividad lo crea y añade a la lista enlaszada
       en experiencia*/
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/actividad/exp/crear")
    public ResponseEntity<ActividadExp> saveActividadExps(//@PathVariable Long id
                                   @RequestBody ActividadExp postAct) {
         
        /* Busca la experiencia en base al id que recibe, puede lanzar una excepcion*/
        
            //Experiencia exp = expService.getExperienciaById(id);
            
            /* Si no existe un registro de actividad lo crea y añade a la lista enlaszada
            en experiencia*/
            
        if (!ActExpService.existByActividad(postAct.getActividad()) ) {
            
           // exp.addActividad(postAct);
        
            ActExpService.saveActividadExp(postAct);
            return new ResponseEntity<>(postAct, HttpStatus.OK);
       
            
            /*Si el registro existe en ambos extremos no hace nada */
        }/*else if (ActExpService.verificaExistenciaAct(exp.getActividad(), ActExpService.getAllActividadExps()) ) {
       
            
            return new ResponseEntity<>(new ActividadExp("ya existe un registro con ese nombre, en la experiencia indicada"), HttpStatus.CONFLICT);
        }*/else {
            
            // Si existe la actividad solo la agrega a la lista en experiencia
             ActividadExp existAct = ActExpService.findByActividad(postAct.getActividad());
            
            //exp.addActividad(existAct);
            
            return new ResponseEntity<>(new ActividadExp("ya existe un registro con ese nombre, Agregado a experiencia"), HttpStatus.CONFLICT);
        }
         
    }
    
    
    //Trae todos
    
    @GetMapping ("/actividades/traer")
    public List<ActividadExp> getAllActividadExps() {
        
        return ActExpService.getAllActividadExps();
    }
    
    //Trae 1 por id
    
    @GetMapping ("/actividades/{id}/traer")
    public ActividadExp getActividadExpById(@PathVariable Long id) {
        
        return ActExpService.getActividadExpById(id);
    }
    
    //Elimina 1 por id
    
    /* Para borrar una actividad hay que eliminarla primero de la lista de Experiencia */
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/actividades/delete/{id}")
    public String deleteActividadById(@PathVariable Long id) {
        
        ActExpService.deleteActividadExpById(id);
        
        return "ActividadExp elimanado";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/delete/actividades/{id}/exp/{idExp}")
    public String deleteUserById(@PathVariable Long id,
                                 @PathVariable Long idExp) {
        
        ActividadExp act = ActExpService.getActividadExpById(id);
        
        Experiencia exp = expService.getExperienciaById(idExp);
        
        //exp.removeObject(act);
        
        expService.saveExperiencia(exp);
        
        return "ActividadExp elimanada de experiencia";
    }
    
    //Edita 1 por id 
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/actividades/editar/{id}")
    public ResponseEntity<ActividadExp>editarActividadExp(@PathVariable Long id,
                                                @RequestParam String actividad) {
        
        
        ActividadExp editAct = ActExpService.getActividadExpById(id);
        editAct.setActividad(actividad);
        ActExpService.saveActividadExp(editAct);
        
        
        return new ResponseEntity<>(editAct, HttpStatus.OK);
    }
}

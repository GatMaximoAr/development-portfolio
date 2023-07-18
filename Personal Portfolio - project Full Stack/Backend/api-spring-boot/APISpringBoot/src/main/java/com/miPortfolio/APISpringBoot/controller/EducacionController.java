
package com.miPortfolio.APISpringBoot.controller;

import com.miPortfolio.APISpringBoot.dao.EducacionDao;
import com.miPortfolio.APISpringBoot.dto.EducacionDto;
import com.miPortfolio.APISpringBoot.logica.LogicaEducacion;
import com.miPortfolio.APISpringBoot.logica.Mensaje;
import com.miPortfolio.APISpringBoot.model.Educacion;
import com.miPortfolio.APISpringBoot.security.model.Usuario;
import com.miPortfolio.APISpringBoot.service.EducacionService;
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
public class EducacionController {
    
    @Autowired private EducacionService eduService;
    
    @Autowired private UsuarioService userService;
    
    @Autowired private LogicaEducacion logicaEdu;
    
    // Crea
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/educacion/usuario/{id}/crear")
    public ResponseEntity<Mensaje> saveEducacion(@PathVariable String id,
                                   @RequestBody EducacionDao dao) {
                                   
        Usuario user = userService.findByNombreUsuario(id);
        
        
        return logicaEdu.crearItemEducacion(dao, user);
    }
    
    
    //Trae todos
    
    @GetMapping ("/educacion/traer")
    public List<EducacionDto> getAllFormaciones() {
        
        return logicaEdu.getListEducacion();
    }
    
    @GetMapping("/formaciones/{usuario}/traer")
    public List<EducacionDto> getformaciones(@PathVariable String usuario) {
        
        Usuario user = userService.findByNombreUsuario(usuario);
        
        return logicaEdu.getFormacionesUsuario(user);
    }
    
    //Trae 1 por id
    
    @GetMapping ("/educacion/{id}/traer")
    public Educacion getEducacionById(@PathVariable Long id) {
        
        return eduService.getEducacionById(id);
    }
    
    //Elimina 1 por id
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/educacion/delete/{id}")
    public ResponseEntity<Mensaje> deleteEducacionById(@PathVariable Long id) {
        
        eduService.deleteEducacionById(id);
        
        return new ResponseEntity<>(new Mensaje("educacion eliminada"), HttpStatus.OK);
    }
    
    //Edita 1 por id 
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/educacion/editar/{id}")
    public ResponseEntity<EducacionDto>editarEducacion(@PathVariable Long id,
                                                    @RequestBody EducacionDao dao) {
        
        Educacion edu = eduService.getEducacionById(id);
        
        
        return logicaEdu.modificaEducacion(edu, dao);
    }
}

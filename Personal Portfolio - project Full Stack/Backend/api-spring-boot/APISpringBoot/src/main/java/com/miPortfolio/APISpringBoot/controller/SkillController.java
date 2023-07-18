/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.controller;

import com.miPortfolio.APISpringBoot.dto.SkillDto;
import com.miPortfolio.APISpringBoot.logica.LogicaSkill;
import com.miPortfolio.APISpringBoot.logica.Mensaje;
import com.miPortfolio.APISpringBoot.model.Skill;
import com.miPortfolio.APISpringBoot.security.model.Usuario;
import com.miPortfolio.APISpringBoot.security.service.UsuarioService;
import com.miPortfolio.APISpringBoot.service.SkillService;
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

@RestController
public class SkillController {
    
    @Autowired private SkillService skillService;
    @Autowired private UsuarioService UsuarioService;
    @Autowired private LogicaSkill logicaSkill;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/skill/usuario/{id}/crear")
    public ResponseEntity<Mensaje> saveSkill(@PathVariable String id, @RequestBody Skill skill) {
        
        Usuario user = UsuarioService.findByNombreUsuario(id);
        
        Skill newSkill = new Skill(skill.getTitulo(), skill.getPorcentaje(),
                skill.getColor(), user);
        
        skillService.saveSkill(newSkill);
        
        return new ResponseEntity<>(new Mensaje("Skill guardada correctamente"), HttpStatus.CREATED);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/skill/{id}/editar")
    public ResponseEntity<Skill> editSkill(@RequestBody Skill skill, @PathVariable Long id) {
        
        Skill oldSkill = skillService.getSkillById(id);
        
        oldSkill.setTitulo(skill.getTitulo());
        oldSkill.setPorcentaje(skill.getPorcentaje());
        oldSkill.setColor(skill.getColor());
        
        skillService.saveSkill(oldSkill);
        
        return new ResponseEntity<>(oldSkill, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/skill/{id}/delete")
    public ResponseEntity<Mensaje> deleteSkill(@PathVariable Long id) {
        
        skillService.deleteById(id);
        
        return new ResponseEntity<>(new Mensaje("Skill eliminada correctamente"), HttpStatus.OK);
    }
    
    @GetMapping("/skills/traer")
    public List<SkillDto> getAllSkill() {
        return logicaSkill.listaSkills();
    }
    
    @GetMapping("/skills/{usuario}/traer")
    public List<SkillDto> getSkillsUsuario(@PathVariable String usuario) {
        
        Usuario user = UsuarioService.findByNombreUsuario(usuario);
        
        return logicaSkill.getSkillsUsuario(user);
    }
}

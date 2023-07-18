/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.logica;

import com.miPortfolio.APISpringBoot.dto.SkillDto;
import com.miPortfolio.APISpringBoot.model.Skill;
import com.miPortfolio.APISpringBoot.security.model.Usuario;
import com.miPortfolio.APISpringBoot.service.SkillService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogicaSkill {
    
    @Autowired private SkillService skillService;
    
    public List<SkillDto> listaSkills() {
        
        List<SkillDto> listaDto = new ArrayList<>();
        
        skillService.getAllSkills().forEach(skill -> {
            SkillDto dto = new SkillDto(skill.getId(), skill.getTitulo(),
                    skill.getPorcentaje(), skill.getColor());
            
            listaDto.add(dto);
        });
        
        return listaDto;
    }
    
    public List<SkillDto> getSkillsUsuario(Usuario user) {
        
        List<SkillDto> listaDto = new ArrayList<>();
        
        List<Skill> listaSkill = skillService.findAllByUser(user);
        
        for (Skill skill : listaSkill) {
            
            SkillDto dto = new SkillDto(skill.getId(), skill.getTitulo(), skill.getPorcentaje(),
            skill.getColor());
            
            listaDto.add(dto);
        }
        
        return listaDto;
    }
    
}

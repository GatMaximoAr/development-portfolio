/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.logica;

import com.miPortfolio.APISpringBoot.dao.ProyectoDao;
import com.miPortfolio.APISpringBoot.dto.ProyectoDto;
import com.miPortfolio.APISpringBoot.model.Proyecto;
import com.miPortfolio.APISpringBoot.security.model.Usuario;
import com.miPortfolio.APISpringBoot.service.ProyectoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LogicaProyecto {
    
    @Autowired private ProyectoService proService;
    
    public ResponseEntity<ProyectoDto> crearProyecto(ProyectoDao dao, Usuario user) {
        
        Proyecto newProyecto = new Proyecto(dao.getTitulo(), dao.getImagen(),
                dao.getVinculo_img(), dao.getSobre_proyecto(), user);
        
        proService.saveProyecto(newProyecto);
        
        ProyectoDto proDto = new ProyectoDto(newProyecto.getId(), newProyecto.getTitulo(),
                newProyecto.getImagen(), newProyecto.getVinculo_img(),
                newProyecto.getSobre_proyecto());
        
        return new ResponseEntity<>(proDto, HttpStatus.CREATED);
    }
    
    public List<ProyectoDto> traerDtos() {
        
        List<ProyectoDto> listaDto = new ArrayList<>();
        
        List<Proyecto> listaProyecto = proService.getAllProyectos();
        
        for (Proyecto proyecto : listaProyecto) {
            
            ProyectoDto proDto = new ProyectoDto(proyecto.getId(), proyecto.getTitulo(), proyecto.getImagen(),
            proyecto.getVinculo_img(), proyecto.getSobre_proyecto());
            
            listaDto.add(proDto);
        }
        
        return listaDto;
    }
    
    public List<ProyectoDto> getProyectosUsuario(Usuario user) {
        
        List<ProyectoDto> listaDto = new ArrayList<>();
        
        List<Proyecto> listaProyecto = proService.findAllByUser(user);
        
        for (Proyecto proyecto : listaProyecto) {
            
            ProyectoDto dto = new ProyectoDto(proyecto.getId(),
                    proyecto.getTitulo(), proyecto.getImagen(), proyecto.getVinculo_img(),
                    proyecto.getSobre_proyecto());
            
            listaDto.add(dto);
        }
        
        return listaDto;
    }
    
    public ResponseEntity<Mensaje> editarProyecto(Proyecto proyecto, ProyectoDao dao) {
        
        proyecto.setTitulo(dao.getTitulo());
        proyecto.setImagen(dao.getImagen());
        proyecto.setVinculo_img(dao.getVinculo_img());
        proyecto.setSobre_proyecto(dao.getSobre_proyecto());
        
        proService.saveProyecto(proyecto);
        
        return new ResponseEntity<>(new Mensaje("Proyecto editado"), HttpStatus.OK);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.logica;

import com.miPortfolio.APISpringBoot.dao.EducacionDao;
import com.miPortfolio.APISpringBoot.dto.EducacionDto;
import com.miPortfolio.APISpringBoot.model.Educacion;
import com.miPortfolio.APISpringBoot.security.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.miPortfolio.APISpringBoot.service.EducacionService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Service
public class LogicaEducacion {
    
    @Autowired private EducacionService eduService;
    
    public List<EducacionDto> getListEducacion() {
        
        List<Educacion> listaEducacion = eduService.getAllFormaciones();
        
        List<EducacionDto> listDto = new ArrayList<>();
        
        for (Educacion educacion : listaEducacion) {
            
            EducacionDto eduDto = new EducacionDto(educacion.getId(), educacion.getTitulo_des(),
                    educacion.getImagen(), educacion.getVinculo_img(),
                    educacion.getSobre_educacion());
            
            listDto.add(eduDto);
        }
        
        return listDto;
    }
    
    public List<EducacionDto> getFormacionesUsuario(Usuario user) {
        
        List<EducacionDto> listaDto = new ArrayList<>();
        
        List<Educacion> listaProyecto = eduService.findAllByUser(user);
        
        for (Educacion formacion : listaProyecto) {
            
            EducacionDto dto = new EducacionDto(formacion.getId(),
                    formacion.getTitulo_des(), formacion.getImagen(), formacion.getVinculo_img(),
                    formacion.getSobre_educacion());
            
            listaDto.add(dto);
        }
        
        return listaDto;
    }
    
    public ResponseEntity<Mensaje> crearItemEducacion(EducacionDao dao, Usuario user) {
        
        Educacion NuevaEdu = new Educacion(dao.getTitulo_des(), dao.getImagen(),
        dao.getVinculo_img(), dao.getSobre_educacion(), user);
        
        eduService.saveEducacion(NuevaEdu);
        
        return new ResponseEntity<>(new Mensaje("Item Educacion creado"), HttpStatus.CREATED);
    }
    
    public ResponseEntity<EducacionDto> modificaEducacion(Educacion edu, EducacionDao dao) {
        
        
        edu.setTitulo_des(dao.getTitulo_des());
        edu.setImagen(dao.getImagen());
        edu.setVinculo_img(dao.getVinculo_img());
        edu.setSobre_educacion(dao.getSobre_educacion());
        
        eduService.saveEducacion(edu);
        
        EducacionDto eduDto = new EducacionDto(edu.getId(), edu.getTitulo_des(),
                edu.getImagen(), edu.getVinculo_img(),
                edu.getSobre_educacion());
        
        return new ResponseEntity<>(eduDto, HttpStatus.OK);
    }
}

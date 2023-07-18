/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.APISpringBoot.logica;

import com.miPortfolio.APISpringBoot.dao.AcercaDeDao;
import com.miPortfolio.APISpringBoot.dto.AcercaDeDto;
import com.miPortfolio.APISpringBoot.model.AcercaDe;
import com.miPortfolio.APISpringBoot.security.model.Usuario;
import com.miPortfolio.APISpringBoot.service.AcercaDeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LogicaAcercaDe {
    
    @Autowired AcercaDeService acercaService;
    
    public ResponseEntity<AcercaDeDto> crearAcerca(AcercaDeDao dao, Usuario user) {
        
        AcercaDe newAcerca = new AcercaDe(dao.getNombre_usuario(), dao.getApellido_usuario(),
                dao.getImagen(), dao.getSobre_usuario(), dao.getOcupacion(),
                dao.getImg_portada(), user);
        
        acercaService.saveAcercaDe(newAcerca);
        
        AcercaDeDto acercaDto = new AcercaDeDto(newAcerca.getId(), newAcerca.getNombre_usuario(), newAcerca.getApellido_usuario(),
                newAcerca.getImagen(), newAcerca.getSobre_usuario(), newAcerca.getOcupacion(),
                newAcerca.getImg_portada());
        
        return new ResponseEntity<>(acercaDto, HttpStatus.CREATED);
    }
    
    public AcercaDeDto getUserAcerca(Usuario user) {
        
        AcercaDe acerca = acercaService.getAcercaDeById(user.getId());
        
        AcercaDeDto dto =  new AcercaDeDto(acerca.getId(), acerca.getNombre_usuario(),
                acerca.getApellido_usuario(), acerca.getImagen(),
                acerca.getSobre_usuario(), acerca.getOcupacion(), acerca.getImg_portada());
        
        return dto;
    }
    
    public ResponseEntity<Mensaje> editAcerca(AcercaDeDao dao, AcercaDe acercaDe) {
        
     acercaDe.setNombre_usuario(dao.getNombre_usuario());
     acercaDe.setApellido_usuario(dao.getApellido_usuario());
     acercaDe.setImagen(dao.getImagen());
     acercaDe.setSobre_usuario(dao.getSobre_usuario());
     acercaDe.setOcupacion(dao.getOcupacion());
     acercaDe.setImg_portada(dao.getImg_portada());
     
     acercaService.saveAcercaDe(acercaDe);
        
        return new ResponseEntity<>(new Mensaje("Acerca de, Editado"), HttpStatus.OK);
    }
}

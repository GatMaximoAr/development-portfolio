/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.miPortfolio.APISpringBoot.repository;

import com.miPortfolio.APISpringBoot.model.ActividadExp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ActividadExpRepository extends JpaRepository<ActividadExp, Long>{

    /* Query derivada, devuelve booleanos en caso de que exista 
       un registro coincidente con el parametro String */
    
     boolean existsByActividad(String act);
    
     /* Devuelve un objeto Actividad que coincida con el parametro String */
     
     ActividadExp findByActividad(String act);
    
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.miPortfolio.APISpringBoot.repository;

import com.miPortfolio.APISpringBoot.model.Experiencia;
import com.miPortfolio.APISpringBoot.model.RelExpAct;
import com.miPortfolio.APISpringBoot.model.RelExpActKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface RelExpActRepository extends JpaRepository<RelExpAct, RelExpActKey>{
    
    @Transactional
    void deleteAllByExperiencia(Experiencia experiencia);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.miPortfolio.APISpringBoot.security.repository;

import com.miPortfolio.APISpringBoot.security.enums.RolNombre;
import com.miPortfolio.APISpringBoot.security.model.Rol;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{
    
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
    
}

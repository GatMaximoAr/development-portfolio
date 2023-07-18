
package com.miPortfolio.APISpringBoot.repository;

import com.miPortfolio.APISpringBoot.model.Proyecto;
import com.miPortfolio.APISpringBoot.security.model.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long>{
    
    List<Proyecto> findAllByUser(Usuario user);
}

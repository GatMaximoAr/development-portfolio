
package com.miPortfolio.APISpringBoot.repository;

import com.miPortfolio.APISpringBoot.model.Educacion;
import com.miPortfolio.APISpringBoot.security.model.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Long>{
    
    List<Educacion> findAllByUser(Usuario user);
}


package com.miPortfolio.APISpringBoot.interfaces;

import com.miPortfolio.APISpringBoot.security.model.Usuario;
import java.util.List;

/*interface Usuario metodos CRUD basicos*/

public interface IUsuario {
    
    public void saveUsuario(Usuario usuario);
    
    public void deleteUsuarioById(Long id);
    
    public List<Usuario> getAllUsuarios();
    
    public Usuario getUsuarioById(Long id);
    
    
}

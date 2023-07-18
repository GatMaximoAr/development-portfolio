
package com.miPortfolio.APISpringBoot.interfaces;

import com.miPortfolio.APISpringBoot.model.AcercaDe;
import java.util.List;


 /*interface AcercaDe metodos CRUD basicos*/

public interface IAcercaDe {
    
    public void saveAcercaDe(AcercaDe acercaDe);
    
    public void deleteAcercaDeById(Long id);
    
    public List<AcercaDe> getAllAcercaDe();
    
    public AcercaDe getAcercaDeById(Long id);
}

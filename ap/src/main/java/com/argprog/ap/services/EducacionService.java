
package com.argprog.ap.services;

import com.argprog.ap.model.Educacion;
import com.argprog.ap.repository.EducacionRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class EducacionService {
    
    private final EducacionRepo educacionRepo;
    
    
    @Autowired
    
    public EducacionService(EducacionRepo educacionRepo) {this.educacionRepo = educacionRepo;}
    
    
    public Educacion addEducaccion(Educacion educacion) {
        return educacionRepo.save(educacion);
    }
   
    
    
    public List<Educacion> buscarEducaciones(){
        
        return educacionRepo.findAll();
        
        
    }
    
     public Educacion editarEducacion(Educacion educacion)  {
        
        return educacionRepo.save(educacion);
        
    }
    
    public void borrarEducacion(Long id) {
        educacionRepo.deleteById(id);
    }
    
    
   
    
    /*
    public EducacionService(EducacionRepo educacionRepo) {
        this.educacionRepo = educacionRepo;
    }    
    
   
    
    public List<Educacion> buscarEducaciones(Long id) {
        return educacionRepo.findAll();
    }
    
    public Educacion editarEducacion(Educacion educacion)  {
        
        return educacionRepo.save(educacion);
        
    }
    
    public void borrarEducacion(Long id) {
        educacionRepo.deleteById(id);
    }
*/
}

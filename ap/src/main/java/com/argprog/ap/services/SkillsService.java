/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprog.ap.services;

import com.argprog.ap.model.Skills;
import com.argprog.ap.repository.SkillsRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class SkillsService {
    
    private final SkillsRepo skillsRepo;
    
    
    @Autowired
    
    public SkillsService(SkillsRepo skillsRepo) {this.skillsRepo = skillsRepo;}
    
    
    public Skills addSkills(Skills skills) {
        return skillsRepo.save(skills);
    }
   
    
    
    public List<Skills> buscarSkillss(){
        
        return skillsRepo.findAll();
        
        
    }
    
     public Skills editarSkills(Skills skills)  {
        
        return skillsRepo.save(skills);
        
    }
    
    public void borrarSkills(Long id) {
        skillsRepo.deleteById(id);
    }
    
    
}

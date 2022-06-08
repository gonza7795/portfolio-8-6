/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprog.ap.controller;

import com.argprog.ap.model.Educacion;
import com.argprog.ap.services.EducacionService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Gonzalo
 */

@RestController
@RequestMapping("/educacion")
public class EducacionController {
    
     private final EducacionService educacionService;
    
    public EducacionController(EducacionService educacionService) {
    this.educacionService = educacionService;   
    
    }
    
    @PutMapping("/update")
    
    public ResponseEntity<Educacion> editarEducacion(@RequestBody Educacion educacion) {
        Educacion updateEducacion=educacionService.editarEducacion(educacion);
        
        return new ResponseEntity<> (updateEducacion,HttpStatus.OK);
    }

    
    @GetMapping("/all")
    
    public ResponseEntity<List<Educacion>> obtenerEducacion()  {
        List<Educacion> educaciones=educacionService.buscarEducaciones();
        return new ResponseEntity<>(educaciones, HttpStatus.OK);
        
    }
    
    
    @PostMapping("/add")
    
    public ResponseEntity<Educacion> crearEducacion (@RequestBody Educacion educacion){
        Educacion nuevaEducacion=educacionService.addEducaccion(educacion);
        return new ResponseEntity<>(nuevaEducacion,HttpStatus.CREATED);
    }
    
    @DeleteMapping("/delete/{id}")
    
    public ResponseEntity<?> borrarEducacion(@PathVariable("id") Long id)  {
        
        educacionService.borrarEducacion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprog.ap.controller;

import com.argprog.ap.model.Proyectos;
import com.argprog.ap.services.ProyectosService;
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
 * @author gonzalo
 */


@RestController
@RequestMapping("/proyectos")


public class ProyectosController {
    
     private final ProyectosService proyectosService;
     
     
         public ProyectosController(ProyectosService proyectosService) {
    this.proyectosService = proyectosService;   
    
    }
         
         
           @PutMapping("/update")
    
    public ResponseEntity<Proyectos> editarProyectos(@RequestBody Proyectos proyectos) {
        Proyectos updateProyectos=proyectosService.editarProyectos(proyectos);
        
        return new ResponseEntity<> (updateProyectos,HttpStatus.OK);
    }
    
    
    
       @GetMapping("/all")
    
    public ResponseEntity<List<Proyectos>> obtenerProyectos()  {
        List<Proyectos> proyectoss=proyectosService.buscarProyectos();
        return new ResponseEntity<>(proyectoss, HttpStatus.OK);
        
    }
    
    
    
     @PostMapping("/add")
    
    public ResponseEntity<Proyectos> crearProyectos (@RequestBody Proyectos proyectos){
        Proyectos nuevaProyectos=proyectosService.addProyectos(proyectos);
        return new ResponseEntity<>(nuevaProyectos,HttpStatus.CREATED);
    }
    
    
    
    
    
     @DeleteMapping("/delete/{id}")
    
    public ResponseEntity<?> borrarProyectos(@PathVariable("id") Long id)  {
        
        proyectosService.borrarProyectos(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}

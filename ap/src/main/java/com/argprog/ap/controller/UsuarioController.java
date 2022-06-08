
package com.argprog.ap.controller;

import com.argprog.ap.model.Usuario;
import com.argprog.ap.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/usuario")

//@CrossOrigin(origin = "http/localhost:4200")


public class UsuarioController {
    
    private final UsuarioService usuarioService;
    
    public UsuarioController(UsuarioService usuarioService) {
    this.usuarioService = usuarioService;   
}
    
    @GetMapping("id/{id}")
    
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable("id") Long id)  {
        Usuario usuario=usuarioService.buscaUsuarioPorId(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
        
    }
    
    
    @PutMapping("/update")
    
    public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario usuario) {
        Usuario updateUsuario=usuarioService.editarUsuario(usuario);
        
        return new ResponseEntity<> (updateUsuario,HttpStatus.OK);
    }
    
    
    
    
}

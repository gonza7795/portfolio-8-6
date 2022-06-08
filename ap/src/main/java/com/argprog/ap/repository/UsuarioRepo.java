
package com.argprog.ap.repository;

import com.argprog.ap.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepo extends  JpaRepository<Usuario, Long>{
    
}

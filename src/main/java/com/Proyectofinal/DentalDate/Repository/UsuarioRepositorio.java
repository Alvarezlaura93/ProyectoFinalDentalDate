/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Proyectofinal.DentalDate.Repository;

import com.Proyectofinal.DentalDate.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Laura Alvarez
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,String>{
    
    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    public Usuario buscarPorEmail(@Param("email")String email);
    
    
    
    
}

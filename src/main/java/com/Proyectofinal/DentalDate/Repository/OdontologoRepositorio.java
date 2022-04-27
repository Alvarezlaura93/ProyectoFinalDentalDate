/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Proyectofinal.DentalDate.Repository;

import com.Proyectofinal.DentalDate.Entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Laura Alvarez
 */
@Repository
public interface OdontologoRepositorio extends JpaRepository<Odontologo,String> {
    
    @Query("SELECT o FROM Odontologo o WHERE o.especialidad = :especialidad")
    public Odontologo buscarPorEspecialidad(@Param("especialidad")String especialidad);
    
    
    
    
}

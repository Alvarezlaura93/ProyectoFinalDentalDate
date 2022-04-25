/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Proyectofinal.DentalDate.Repository;

import com.Proyectofinal.DentalDate.Entity.Paciente;
import com.Proyectofinal.DentalDate.Entity.Turno;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Laura Alvarez
 */
public interface TurnoRepositorio extends JpaRepository<Paciente,String>{
    
    @Query("SELECT t FROM Turnos t WHERE t.fecha = :fecha")
    public Turno buscarPorFecha(@Param("fecha") Date fecha);
    
    
    
    
    
}

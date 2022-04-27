/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Proyectofinal.DentalDate.Repository;

import com.Proyectofinal.DentalDate.Entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Laura Alvarez
 */
@Repository
public interface TurnoRepositorio extends JpaRepository<Turno,String>{
    @Query("SELECT t FROM Turno t WHERE t.id = :id")
    public Turno buscarPorId(@Param("id")String id);
}

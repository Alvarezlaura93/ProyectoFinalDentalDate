/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Proyectofinal.DentalDate.Repository;

import com.Proyectofinal.DentalDate.Entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepositorio extends JpaRepository<Paciente, String>{

    
    @Query("SELECT l FROM Paciente l WHERE l.Dni = :Dni")
    public Paciente buscarPorDni(@Param("Dni") String Dni);
    
    @Query("SELECT l FROM Paciente l WHERE l.apellido = :apellido")
    public Paciente buscarPorApellido(@Param("apellido") String apellido);

    @Query("SELECT l FROM Paciente l WHERE l.id = : id")
    public Paciente buscarPorid(@Param ("id") String id);
    
    
    
}

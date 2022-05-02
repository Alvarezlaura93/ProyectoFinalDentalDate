/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Proyectofinal.DentalDate.Entity;


import com.Proyectofinal.DentalDate.Roles.Role;
import javax.persistence.Entity;

import javax.persistence.ManyToOne;


@Entity
public class Odontologo extends Usuario {
    
    
   
    private String matricula;
    private String especialidad;
    
    @ManyToOne
    private Paciente paciente;
    
   
    
    public Odontologo() {
        super();
    }

    public Odontologo(String nombre, String apellido,String email, String contraseña,Role role, String matricula, String especialidad, Paciente paciente) {
        super(nombre,apellido,email, contraseña, role);
        this.matricula = matricula;
        this.especialidad = especialidad;
        this.paciente = paciente;
    }


    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
}

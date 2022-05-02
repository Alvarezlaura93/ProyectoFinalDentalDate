/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Proyectofinal.DentalDate.Entity;

import com.Proyectofinal.DentalDate.Roles.Role;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Paciente extends Usuario {

    
 
    private Long Dni;
 
    
    @OneToOne
    private Odontologo odontologo;
   
    

    public Paciente() {
        super();
    }

    public Paciente(String nombre, String apellido, Long Dni, String email, String contraseña, Odontologo odontologo, Role role) {
        super(nombre, apellido ,email,contraseña, role);
        this.Dni = Dni;
        this.odontologo = odontologo;
      
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Long getDni() {
        return Dni;
    }

    public void setDni(Long Dni) {
        this.Dni = Dni;
    }


    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    
}

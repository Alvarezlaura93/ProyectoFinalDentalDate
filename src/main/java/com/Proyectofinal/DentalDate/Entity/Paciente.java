/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Proyectofinal.DentalDate.Entity;

import com.Proyectofinal.DentalDate.Roles.Role;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Paciente extends Usuario {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator( name ="uuid",strategy="uuid2")
    private String id;
    private String nombre;
    private String apellido;
    private Long Dni;
 
    
    @OneToOne
    private Odontologo odontologo;
    
    @Enumerated(EnumType.STRING)
    private Role role; 
    

    public Paciente() {
        super();
    }

    public Paciente(String nombre, String apellido, Long Dni, String email, String contraseña, Odontologo odontologo) {
        super(email,contraseña);
        this.nombre = nombre;
        this.apellido = apellido;
        this.Dni = Dni;
        this.odontologo = odontologo;
      
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
   

    
}

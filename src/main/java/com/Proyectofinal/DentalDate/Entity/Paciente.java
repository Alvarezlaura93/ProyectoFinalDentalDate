/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Proyectofinal.DentalDate.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Paciente {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator( name ="uuid",strategy="uuid2")
    private String id;
    private String nombre;
    private String apellido;
    private Long Dni;
    private String email;
    private String contraseña;
    
    @OneToOne
    private Odontologo odontologo;
    

    public Paciente() {
    }

    public Paciente(String nombre, String apellido, Long Dni, String email, String contraseña, Odontologo odontologo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.Dni = Dni;
        this.email = email;
        this.contraseña = contraseña;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    @Override
    public String toString() {
        return "Paciente{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", Dni=" + Dni + ", email=" + email + ", contrase\u00f1a=" + contraseña + ", odontologo=" + odontologo + '}';
    }


    
}

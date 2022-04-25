/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Proyectofinal.DentalDate.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Odontologo {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator( name ="uuid",strategy="uuid2")
    private String id;
    private String nombre;
    private String apellido;
    private Long matricula;
    private String especialidad;
    
    @ManyToOne
    private Paciente paciente;

    public Odontologo() {
    }

    public Odontologo(String nombre, String apellido, Long matricula, String especialidad, Paciente paciente) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
        this.especialidad = especialidad;
        this.paciente = paciente;
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

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
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

    @Override
    public String toString() {
        return "Odontologo{" + "nombre=" + nombre + ", apellido=" + apellido + ", matricula=" + matricula + ", especialidad=" + especialidad + ", paciente=" + paciente + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
}

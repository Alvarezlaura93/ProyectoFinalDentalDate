/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Proyectofinal.DentalDate.Entity;

import java.util.Date;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


public class Turno {

    private Date fecha;
    //trabajar con dias
    //private String hora; "12:30"
    
    @ManyToOne
    private Odontologo odontologo;
    
    @OneToOne
    private Paciente paciente;

    public Turno() {
    }

    public Turno(Date fecha, Odontologo odontologo, Paciente paciente) {
        this.fecha = fecha;
        this.odontologo = odontologo;
        this.paciente = paciente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Turno{" + "fecha=" + fecha + ", odontologo=" + odontologo + ", paciente=" + paciente + '}';
    }
    
    
  
    
    
    
    
}

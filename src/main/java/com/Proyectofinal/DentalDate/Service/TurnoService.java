/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Proyectofinal.DentalDate.Service;

import com.Proyectofinal.DentalDate.Entity.Odontologo;
import com.Proyectofinal.DentalDate.Entity.Paciente;
import com.Proyectofinal.DentalDate.Entity.Turno;
import com.Proyectofinal.DentalDate.Repository.TurnoRepositorio;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurnoService  {
    
    @Autowired
    private TurnoRepositorio turno;
    
    public Turno guardarTurno( Date fecha, Odontologo odontologo, Paciente paciente){
        Turno t = new Turno();
        t.setPaciente(paciente);
        t.setFecha(fecha);
        t.setOdontologo(odontologo);
        
        return turno.save(t);
    }
 
    public Turno ModificarTurno( String id, Date fecha, Odontologo odontologo, Paciente paciente){
        Turno t = turno.getOne(id);
        t.setFecha(fecha);
        t.setOdontologo(odontologo);
        t.setPaciente(paciente);
        
        return turno.save(t);
    }
    
    public void EliminarTurno(String id ){
        turno.deleteById(id);
    }
    
    public List<Turno>ListarTurnos(){
        return turno.findAll();
    }
    
    public void Validar(Date fecha) throws Exception{
        if(fecha==null|| fecha.before(fecha)){
            throw new Exception("debe ingresar una fecha posterior");
        }
    }

}

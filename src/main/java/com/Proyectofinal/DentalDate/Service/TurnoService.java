/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Proyectofinal.DentalDate.Service;


import com.Proyectofinal.DentalDate.Entity.Paciente;
import com.Proyectofinal.DentalDate.Entity.Turno;
import com.Proyectofinal.DentalDate.Repository.TurnoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurnoService  {
    
    @Autowired
    private TurnoRepositorio turno;
    
    public Turno guardarTurno( String fecha, Paciente paciente){
        Turno t = new Turno();
        t.setPaciente(paciente);
        t.setFecha(fecha);
        
        
        return turno.save(t);
    }
 
    public Turno ModificarTurno( String id, String fecha, Paciente paciente){
        Turno t = turno.getOne(id); //porue subralladooo
        t.setFecha(fecha);
      
        t.setPaciente(paciente);
        
        return turno.save(t);
    }
    
    public void EliminarTurno(String id ){
        turno.deleteById(id);
    }
    
//    public List<Turno>ListarTurnos(String fecha){
//        
//        return  (List<Turno>) turno.listarFecha(fecha);
//    }
    
        public List<Turno>listaTurno(){
        
        
        return turno.findAll();
    }   
    
    public void Validar(String fecha) throws Exception{
       // if(fecha==null|| fecha.before(fecha)){
            throw new Exception("debe ingresar una fecha posterior");
        
    }

}

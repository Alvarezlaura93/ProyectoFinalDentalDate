/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Proyectofinal.DentalDate.Service;

import com.Proyectofinal.DentalDate.Entity.Paciente;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class PacienteService {

    public Paciente GuardarUsuario(String nombre, String apellido, Long Dni, String email,String contraseña) throws Exception{
         validator(nombre,apellido,Dni, email, contraseña);
         Paciente p= new Paciente();
         BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
         p.setNombre(nombre);
         p.getApellido();
         p.setDni(Dni);
         p.setEmail(email);
         p.setContraseña(contraseña);
     
        return p;
    }
    
    
    public Paciente modificarUsuario(String email,String contraseña) throws Exception{
        validator2(email, contraseña, contraseña);
        
        
        
        
        
        return p
    }
    // valida los datos del usuario
    public void validator(String nombre, String apellido, Long Dni, String email,String contraseña) throws Exception{
        
        if(nombre==null|| nombre.isEmpty()){
            throw new Exception("debe ingresar su nombre");
        }
        if(apellido==null|| nombre.isEmpty()){
            throw new Exception("debe ingresar su apellido");
        }
        
        if(Dni==null|| nombre.isEmpty()){
            throw new Exception("debe ingresar su Dni");
        }
        
        if(email==null|| nombre.isEmpty()){
            throw new Exception("debe ingresar su email");
        }
        if(contraseña==null|| nombre.isEmpty()){
            throw new Exception("debe ingresar su contraseña");
        }
        
    }
    //valida las modificaciones del usuario
    public void validator2(String email,String contraseña, String nuevacontraseña) throws Exception{
       
        if(email==null|| email.isEmpty()){
            throw new Exception("debe ingresar su email");
        }
        if(contraseña==null|| contraseña.isEmpty()){
            throw new Exception("debe ingresar su contraseña");
    }
        
        if (nuevacontraseña == null || nuevacontraseña.isEmpty()){
            throw new Exception(" debe ingresar una nueva contraseña");
        }
        if (contraseña.equals(nuevacontraseña)){
            throw new Exception("las contraseñas no deben coincidir ");
        }
    
}

}
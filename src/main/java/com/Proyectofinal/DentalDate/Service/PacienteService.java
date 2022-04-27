/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Proyectofinal.DentalDate.Service;

import com.Proyectofinal.DentalDate.Entity.Paciente;
import com.Proyectofinal.DentalDate.Repository.PacienteRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

public class PacienteService implements UserDetailsService {

    @Autowired
    private PacienteRepositorio pacienteRepositorio;

    @Transactional
    public Paciente GuardarUsuario(String nombre, String apellido, Long Dni, String email, String contraseña) throws Exception {
        validator(nombre, apellido, Dni, email, contraseña);
        Paciente p = new Paciente();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        p.setNombre(nombre);
        p.getApellido();
        p.setDni(Dni);
        p.setEmail(email);
        p.setContraseña(contraseña);

        return p;
    }

    //modifica la contraseña del usuario
    @Transactional
    public Paciente modificarUsuario(String id, String email, String contraseña, String nuevacontraseña) throws Exception {
        validator2(email, contraseña, nuevacontraseña);
        Paciente p = pacienteRepositorio.getOne(id);

        p.setEmail(email);
        p.setContraseña(contraseña);
        p.setContraseña(nuevacontraseña);

        return pacienteRepositorio.save(p);
    }
    
     @Transactional
    public Paciente getOne(String id){
        return pacienteRepositorio.getOne(id);
    }
    
    @Transactional
    public void eliminarPaciente(String id){
        Paciente u = getOne(id);
        pacienteRepositorio.delete(u);
     
    }
    
    public List<Paciente>listaPaciente(){
        return pacienteRepositorio.findAll();
    }

    // valida los datos del usuario
    public void validator(String nombre, String apellido, Long Dni, String email, String contraseña) throws Exception {

        if (nombre == null || nombre.isEmpty()) {
            throw new Exception("debe ingresar su nombre");
        }
        if (apellido == null || nombre.isEmpty()) {
            throw new Exception("debe ingresar su apellido");
        }

        if (Dni == null || nombre.isEmpty()) {
            throw new Exception("debe ingresar su Dni");
        }

        if (email == null || nombre.isEmpty()) {
            throw new Exception("debe ingresar su email");
        }
        if (contraseña == null || nombre.isEmpty()) {
            throw new Exception("debe ingresar su contraseña");
        }

    }

    //valida las modificaciones del usuario
    public void validator2(String email, String contraseña, String nuevacontraseña) throws Exception {

        if (email == null || email.isEmpty()) {
            throw new Exception("debe ingresar su email");
        }
        if (contraseña == null || contraseña.isEmpty()) {
            throw new Exception("debe ingresar su contraseña");
        }

        if (nuevacontraseña == null || nuevacontraseña.isEmpty()) {
            throw new Exception(" debe ingresar una nueva contraseña");
        }
        if (contraseña.equals(nuevacontraseña)) {
            throw new Exception("las contraseñas no deben coincidir ");
        }

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

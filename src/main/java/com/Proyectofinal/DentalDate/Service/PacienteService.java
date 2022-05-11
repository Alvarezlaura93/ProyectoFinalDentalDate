/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Proyectofinal.DentalDate.Service;

import com.Proyectofinal.DentalDate.Entity.Paciente;
import com.Proyectofinal.DentalDate.Repository.PacienteRepositorio;
import com.Proyectofinal.DentalDate.Roles.Role;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PacienteService {

    @Autowired
    private PacienteRepositorio pacienteRepositorio;
    
    private UsuarioServicio usuarioservice;

    @Transactional
    public Paciente GuardarPaciente(String nombre, String apellido, String Dni, String email, String contraseña) throws Exception {
        validator(nombre, apellido, Dni, email, contraseña);
        Paciente p = new Paciente();
        BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
        p.setNombre(nombre);
        p.setApellido(apellido);
//        Paciente p = (Paciente) usuarioservice.crearUsuario(nombre, apellido, email, contraseña, Role.USER);
        p.setDni(Dni);
        p.setEmail(email);
        p.setContraseña(enc.encode(contraseña));
        p.setRole(Role.USER);
        return pacienteRepositorio.save(p);
    }

    //modifica la contraseña del usuario
    @Transactional
    public Paciente modificarUsuario(String id, String email, String contraseña, String nuevacontraseña) throws Exception {
        validator2(email, contraseña, nuevacontraseña);
        Paciente p = pacienteRepositorio.getById(id);
        BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
        if (p==null) {
            throw new Exception("No existe un Paciente con esa ID");
        }    
        p.setEmail(email);
        p.setContraseña(enc.encode(contraseña));

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
    public void validator(String nombre, String apellido, String Dni, String email, String contraseña) throws Exception {

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

    }



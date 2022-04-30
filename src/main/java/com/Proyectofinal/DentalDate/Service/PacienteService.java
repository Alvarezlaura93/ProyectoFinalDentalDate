/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Proyectofinal.DentalDate.Service;

import com.Proyectofinal.DentalDate.Entity.Paciente;
import com.Proyectofinal.DentalDate.Repository.PacienteRepositorio;
import com.Proyectofinal.DentalDate.Roles.Role;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class PacienteService implements UserDetailsService {

    @Autowired
    private PacienteRepositorio pacienteRepositorio;

    @Transactional
    public Paciente GuardarUsuario(String nombre, String apellido, Long Dni, String email, String contraseña) throws Exception {
        validator(nombre, apellido, Dni, email, contraseña);
        Paciente p = new Paciente();
        BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
        p.setNombre(nombre);
        p.getApellido();
        p.setDni(Dni);
        p.setEmail(email);
        p.setContraseña(contraseña);
        p.setRole(Role.USER);

        return p;
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

    
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       Paciente p = pacienteRepositorio.buscarPorEmail(email);
         if (p != null) {
            List<GrantedAuthority> permisos = new ArrayList<>();

            GrantedAuthority p1 = new SimpleGrantedAuthority("ROLE_" + p.getRole());//ROLE_ADMIN O ROLE_USER
            permisos.add(p1);

            //Esto me permite guardar el OBJETO USUARIO LOG, para luego ser utilizado
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(true);
            session.setAttribute("pacientesession", p);

            User user = new User(p.getEmail(),p.getContraseña(), permisos);
            return user;

        } else {
            return null;
        }
    }
    }



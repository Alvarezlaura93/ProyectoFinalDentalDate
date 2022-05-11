/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Proyectofinal.DentalDate.Service;

import com.Proyectofinal.DentalDate.Entity.Odontologo;
import com.Proyectofinal.DentalDate.Repository.OdontologoRepositorio;
import com.Proyectofinal.DentalDate.Roles.Role;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author Laura Alvarez
 */
@Service
public class OdontologoService {

    @Autowired
    private OdontologoRepositorio Odrepositorio;
    


    @Transactional
    //cargo un odontologo
    public Odontologo GuardarOdontologo(String nombre, String apellido, String email, String contraseña, String Matricula, String especialidad) {
        Odontologo odn = new Odontologo();
        odn.setNombre(nombre);
        odn.setApellido(apellido);
        BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
        odn.setEmail(email);
        odn.setContraseña(enc.encode(contraseña));
        odn.setMatricula(Matricula);
        odn.setEspecialidad(especialidad);
        odn.setRole(Role.ADMIN);

        return Odrepositorio.save(odn);
    }

    @Transactional
    public Odontologo modificarOdontologo(String id, String email, String contraseña, String nuevacontraseña) throws Exception {
        validator2(email, contraseña, nuevacontraseña);
        Odontologo odon = Odrepositorio.getById(id);
        BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
        if (odon == null) {
            throw new Exception("No existe un Odontologo con esa ID");
        }
        odon.setEmail(email);
        odon.setContraseña(enc.encode(contraseña));

        return Odrepositorio.save(odon);
    }

    //elimino el odontologo creado
    @Transactional
    public void Eliminar(String id) {
        Odontologo Od = Odrepositorio.getById(id);
        Odrepositorio.deleteById(id);

    }

    public List<Odontologo> listaOdontologo() {
        return Odrepositorio.findAll();
    }

    //valida las modificaciones del odontologo
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

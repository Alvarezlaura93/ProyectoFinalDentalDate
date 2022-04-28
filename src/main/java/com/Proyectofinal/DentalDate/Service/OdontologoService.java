/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Proyectofinal.DentalDate.Service;

import com.Proyectofinal.DentalDate.Entity.Odontologo;
import com.Proyectofinal.DentalDate.Repository.OdontologoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author Laura Alvarez
 */
@Service
public class OdontologoService  {

    @Autowired
    private OdontologoRepositorio Odrepositorio;

    @Transactional
    //cargo un odontologo
    public Odontologo Guardar(String nombre, String apellido, String Matricula, String especialidad) {
        Odontologo od = new Odontologo();
        od.setNombre(nombre);
        od.setApellido(apellido);
        od.setMatricula(Matricula);
        od.setEspecialidad(especialidad);
        
        

        return Odrepositorio.save(od);
    }

    //modifico la especialidad (ya que la matricula es un numero unico e intransferible
    @Transactional
    public Odontologo Modificar(String especialidad) {
        Odontologo od = Odrepositorio.getOne(especialidad);
        od.setEspecialidad(especialidad);
        return Odrepositorio.save(od);
    }

    //elimino el odontologo creado
    @Transactional
    public void Eliminar(String id) {
        Odontologo Od = Odrepositorio.getById(id);
        Odrepositorio.deleteById(id);
        
    }

    public List<Odontologo>listaOdontologo(){
     return Odrepositorio.findAll();
}

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Proyectofinal.DentalDate.Controller;

import com.Proyectofinal.DentalDate.Entity.Odontologo;
import com.Proyectofinal.DentalDate.Entity.Paciente;
import com.Proyectofinal.DentalDate.Entity.Turno;
import com.Proyectofinal.DentalDate.Entity.Usuario;
import com.Proyectofinal.DentalDate.Service.OdontologoService;
import com.Proyectofinal.DentalDate.Service.PacienteService;
import com.Proyectofinal.DentalDate.Service.TurnoService;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import static org.hibernate.bytecode.BytecodeLogging.LOGGER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class UsuarioController {

    @Autowired
    private PacienteService pacienteServicio;

    @Autowired
    private TurnoService turnoService;

    @Autowired
    private OdontologoService odontologoService;

    //nos posicionamos en el esecenario formulario
    @RequestMapping("/formulario")
    public String mostrameformularioRegistro(Model modelo) {

        return "formulario";
    }
//
    @RequestMapping("/formTurno")
    public String formularioRegistroTurno(ModelMap modelo) {
   
           return "formTurno";
      
        
    
   }
//click en el boton guardar 
//
    //creamos y guardamos el registro del usuario

    @PostMapping("/guardarRegistro")
    public String guardar_el_formulario(ModelMap modelo, @RequestBody String nombre, @RequestBody String apellido, @RequestBody String Dni, @RequestParam String email, @RequestBody String contraseña) throws Exception {

        try { //si no agrego em metodo guartadrTurno dentro de guardarPaciente

            Paciente GuardarUsuario = pacienteServicio.GuardarPaciente(nombre, apellido, Dni, email, contraseña);
            modelo.put("Exito", "Guardado con exito");

           
            //modelo.put("Bienvenide", GuardarUsuario );
            return "index"; // si no aca agregamos un html
        } catch (Exception ex) {
            ex.printStackTrace();
            modelo.put("Error", "vuelva a intentarlo");
            
            return "formulario";
        }
    }
    @GetMapping("/formTurno")
	public String guardarFomularioConTurno( ModelMap model, HttpSession session ) {
            try{
            
                Usuario u = (Usuario) session.getAttribute("usuariosession"); 
//		Paciente paciente= pacienteServicio.getOne(u.getId());
		model.put("paciente", u);
	//need la session 
                
		return "formTurno";
	}   catch (Exception e) {
              System.out.println(e);
       }
       return "formTurno"; //creo un html y css re
   }

        
    @PostMapping("/guardarTurno")
    public String  guardar_el_formulario_con_turno(ModelMap modelo,  String fecha, Paciente paciente) throws Exception {
        //Guardame el turno
        try {      
            turnoService.guardarTurno(fecha,  paciente);
           
              
            return "redirect:"; // si no aca agregamos un html
        } catch (Exception ex) {
            modelo.put("Error", "vuelva a intentarlo");
            return "formTurno";
        }
    }     

    @GetMapping("/editar")
    public String editar(ModelMap model, HttpSession session) {
        try {
            Usuario u = (Usuario) session.getAttribute("usuariosession");
            model.put("usuario", u);
        } catch (Exception e) {
        }

        return "editar-perfil";
    }

}

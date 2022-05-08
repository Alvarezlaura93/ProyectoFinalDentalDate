/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Proyectofinal.DentalDate.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("/index")//localhost:8080/
    public String index(@RequestParam(required = false) String login, ModelMap model) {
        if (login != null) {
            model.put("exito", "Logueado con exito");

        }

        return "index.html";

    }

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error, @RequestParam(required = false) String logout, ModelMap model) {
        if (error != null) {
            model.put("error", "Usuario o Contraseña incorrectos");
        }
        if (logout != null) {
            model.put("logout", "Desconectado correctamente");
        }
        return "login";
    }

    @RequestMapping("/sucursales")
    public String mostrameSucursales(Model modelo) {

        return "sucursales";
    }

    @RequestMapping("/trabajaconnostros")
    public String subirCV(Model modelo) {

        return "cv";
    }



 @RequestMapping("/admin/Turnos")
    public String vistaDeTurnos(Model modelo) {

        return "adminTurnos";
}
}
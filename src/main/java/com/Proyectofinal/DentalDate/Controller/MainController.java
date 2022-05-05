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
      @GetMapping("/")//localhost:8080/
    public String index(@RequestParam(required = false)String login, ModelMap model) {
        if (login!=null) {
            model.put("exito","Logueado con exito");
           
        }
<<<<<<< HEAD
        return "index.html";
=======
         return "index.html";
>>>>>>> 7a7decf72d4e474a59024edff6641366cb400c28
    }
    
    @RequestMapping("/sucursales")
    public String mostrameSucursales(Model modelo){
    
    return "sucursales";
}
    
}

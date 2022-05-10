/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Proyectofinal.DentalDate.Service;


import com.Proyectofinal.DentalDate.Entity.Usuario;
import com.Proyectofinal.DentalDate.Repository.UsuarioRepositorio;
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
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class UsuarioServicio implements UserDetailsService{
    
@Autowired
private UsuarioRepositorio usuariorepositorio;
    
public Usuario crearUsuario(String id, String nombre, String apellido, String email, String contraseña, Role role){
    Usuario u= new Usuario() {};
    u.setNombre(nombre);
    u.setApellido(apellido);
    u.setEmail(email);
    u.setContraseña(contraseña);
    u.setRole(role);
    
   return usuariorepositorio.save(u);
    
}
    
    
    
    @Override
     public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario u = usuariorepositorio.buscarPorEmail(email);
        if (u!= null) {
            List<GrantedAuthority> permisos = new ArrayList<>();

            GrantedAuthority p1 = new SimpleGrantedAuthority("ROLE_" + u.getRole());//ROLE_ADMIN O ROLE_USER
            permisos.add(p1);

            //Esto me permite guardar el OBJETO USUARIO LOG, para luego ser utilizado
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(true);
            session.setAttribute("usuariosession", u); //traerme el usuario

            User user = new User(u.getEmail(), u.getContraseña(), permisos);
            return user;

        } else {
            return null;
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
}

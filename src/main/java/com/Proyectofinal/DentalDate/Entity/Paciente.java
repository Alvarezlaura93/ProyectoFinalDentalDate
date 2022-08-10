

package com.Proyectofinal.DentalDate.Entity;

import com.Proyectofinal.DentalDate.Roles.Role;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Paciente extends Usuario {

    
 
    private String Dni;
 
    
    @OneToOne
    private Odontologo odontologo;
   
    @OneToOne
    private Turno turno;


    public Paciente() {
        super();
    }

    public Paciente(String nombre, String apellido, String Dni, String email, String contraseña, Odontologo odontologo,Turno turno, Role role) {
        super(nombre, apellido ,email,contraseña, role);
        this.Dni = Dni;
        this.odontologo = odontologo;
      this.turno = turno;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getDni() {
        return Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }


    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

        public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }
}


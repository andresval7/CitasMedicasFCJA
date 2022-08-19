/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.lang.reflect.Constructor;

/**
 *
 * @author 106
 */
public class Medico {
   private String IdMedico;
   private String MdNombre1;
   private String MdNombre2;
   private String MdApellido1;
   private String MdApellido2;
   private String Fechanacimiento;
   private String MdEspecialidad;

    public Medico(String IdMedico,
            String MdNombre1,
            String MdNombre2,
            String MdApellido1,
            String MdApellido2,
            String Fechanacimiento,
            String MdEspecialidad)
    {
        this.IdMedico = IdMedico;
        this.MdNombre1 = MdNombre1;
        this.MdNombre2 = MdNombre2;
        this.MdApellido1 = MdApellido1;
        this.MdApellido2 = MdApellido2;
        this.Fechanacimiento = Fechanacimiento;
        this.MdEspecialidad = MdEspecialidad;
    }

    public String getIdMedico() {
        return IdMedico;
    }

    public String getMdNombre1() {
        return MdNombre1;
    }

    public String getMdNombre2() {
        return MdNombre2;
    }

    public String getMdApellido1() {
        return MdApellido1;
    }

    public String getMdApellido2() {
        return MdApellido2;
    }

    public String getFechanacimiento() {
        return Fechanacimiento;
    }

    public String getMdEspecialidad() {
        return MdEspecialidad;
    }

    public void setIdMedico(String IdMedico) {
        this.IdMedico = IdMedico;
    }

    public void setMdNombre1(String MdNombre1) {
        this.MdNombre1 = MdNombre1;
    }

    public void setMdNombre2(String MdNombre2) {
        this.MdNombre2 = MdNombre2;
    }

    public void setMdApellido1(String MdApellido1) {
        this.MdApellido1 = MdApellido1;
    }

    public void setMdApellido2(String MdApellido2) {
        this.MdApellido2 = MdApellido2;
    }

    public void setFechanacimiento(String Fechanacimiento) {
        this.Fechanacimiento = Fechanacimiento;
    }

    public void setMdEspecialidad(String MdEspecialidad) {
        this.MdEspecialidad = MdEspecialidad;
    }
   
     
   
}

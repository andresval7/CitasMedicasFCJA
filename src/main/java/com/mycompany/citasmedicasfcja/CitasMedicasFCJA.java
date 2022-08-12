/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.citasmedicasfcja;
 

/**
 *
 * @author elfos
 * 
 * Aplicacion citas médicas
 * Debe tener un menú de opciones. -> Andres Vallejo
 * Debe registrar paciente -> Andres Vallejo
 * registrar médico -> Andres Vallejo
 * Asignar cita
 * Consultar paciente
 * Consultar médico
 * Consultar cita
 */
import javax.swing.JOptionPane;
import org.json.*;
import java.util.Vector;

public class CitasMedicasFCJA {
    
    
    
    Vector <String> nombre = new Vector <>();
    Vector <String> apellido = new Vector <>();
    Vector <Integer> cedula = new Vector <>();
    
    Vector <Object> paciente = new Vector<>();

    public static void main(String[] args) {
        CitasMedicasFCJA miCita = new CitasMedicasFCJA();
        boolean flag=true;
        int opcion=0;
        do{
            String mensajeInicio="Bienvenidos a la app de citas médicas\nPresione:\n"
                    + "1. Registrar pacientes\n"
                    + "2. Registrar clientes\n"
                    + "3. Asignar cita\n"
                    + "4. Consultar paciente\n"
                    + "5. Consultar médico\n"
                    + "6. Consultar cita\n"
                    + "7. Salir";
            String datoEntrada=JOptionPane.showInputDialog(null, mensajeInicio);
            opcion=Integer.parseInt(datoEntrada);
            if(opcion==1)
                miCita.registrarPaciente();
            else if(opcion==2)
                miCita.registrarMedico();
            else if(opcion==7)
                flag=false;
        }while(flag);
    }
    
    void registrarPaciente()
    {
        String nombreIngreso=JOptionPane.showInputDialog(null, "Ingrese el nombre del paciente");
        nombre.add(nombreIngreso);
        String apellidoIngreso=JOptionPane.showInputDialog(null, "Ingrese el nombre del paciente");
        apellido.add(apellidoIngreso);
        String cedulaIngreso=JOptionPane.showInputDialog(null, "Ingrese el nombre del paciente");
        cedula.add(Integer.parseInt(cedulaIngreso));
        paciente.add(nombreIngreso);
        JOptionPane.showMessageDialog(null, "Paciente registrado");
    }
    
    void registrarMedico()
    {
        JOptionPane.showMessageDialog(null, "Médico registrado");
    }
}

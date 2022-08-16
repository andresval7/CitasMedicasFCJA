/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

/**
 *
 * @author Andrés Vallejo
 */
public class PacienteController implements ActionListener{
    Vista.RegPacienteFrame pacienteVista;
    Modelo.Paciente pacienteModelo;
    Modelo.GestorPaciente gestorPacienteModelo;
    
    public PacienteController(Vista.RegPacienteFrame pacienteVista){
        this.pacienteVista = pacienteVista;
        gestorPacienteModelo = new Modelo.GestorPaciente();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
      if(e.getSource().equals(pacienteVista.botonRegistrar)){
          String id = pacienteVista.txt_identificacion.getText();
          String n1 = pacienteVista.txt_nombre1.getText();
          String n2 = pacienteVista.txt_nombre2.getText();
          String a1 = pacienteVista.txt_apellido1.getText();
          String a2 = pacienteVista.txt_apellido2.getText();
          SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
          String fNac= formato.format(pacienteVista.fechaNacimientoBox.getDate());
          String genero = (String) pacienteVista.sexoBox.getSelectedItem();
          
          pacienteModelo = new Modelo.Paciente(id,n1,n2,a1,a2,fNac,genero);
          gestorPacienteModelo.RegistrarPaciente(pacienteModelo);
      }
      if(e.getSource().equals(pacienteVista.botonNuevo)){
          pacienteVista.txt_identificacion.setText("");
          pacienteVista.txt_nombre1.setText("");
          pacienteVista.txt_nombre2.setText("");
          pacienteVista.txt_apellido1.setText("");
          pacienteVista.txt_apellido2.setText("");
          pacienteVista.fechaNacimientoBox.setDate(null);
          pacienteVista.txt_identificacion.requestFocus();
      }
      if(e.getSource().equals(pacienteVista.botonCerrar)){
          pacienteVista.dispose();
      }
    }
    
    /*
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    */
    
}

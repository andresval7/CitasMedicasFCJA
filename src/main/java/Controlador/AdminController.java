/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author MegaProyecto
 */
public class AdminController implements ActionListener{
    

    Vista.RegPacienteFrame pacienteVista;
    Modelo.Paciente pacienteModelo;
    Modelo.GestorPaciente gestorPacienteModelo;
    
    public AdminController(Vista.RegPacienteFrame pacienteVista){
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
          //SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
          //String fNac= formato.format(pacienteVista.fechaNacimientoBox.getDate());
          try
          {
            java.util.Date fechaUtil = pacienteVista.fechaNacimientoBox.getDate();
            java.sql.Date fechaSql = new java.sql.Date(fechaUtil.getTime());
            String sexo = (String) pacienteVista.sexoBox.getSelectedItem();
            long miliseconds = System.currentTimeMillis();
            java.sql.Date hoy = new java.sql.Date(miliseconds);

            if(id.equals(""))
            {
                JOptionPane.showMessageDialog(null, "El campo de identificación debe estar diligenciado");
                pacienteVista.txt_identificacion.requestFocus();
            }
            else if(n1.equals(""))
            {
                JOptionPane.showMessageDialog(null, "El campo Nombre 1 debe estar diligenciado");
                pacienteVista.txt_nombre1.requestFocus();
            }
            else if(a1.equals("")){
                JOptionPane.showMessageDialog(null, "El campo Apellido 1 debe estar diligenciado");
                pacienteVista.txt_apellido1.requestFocus();
            }

            else{
                if(fechaSql.getTime()<=hoy.getTime())
                {
                    pacienteModelo = new Modelo.Paciente(id,n1,n2,a1,a2,fechaSql,sexo);
                    gestorPacienteModelo.RegistrarPaciente(pacienteModelo);
                    limpiar();
                }
                else
                    JOptionPane.showMessageDialog(null, "La fecha no debe ser posterior al día de hoy");
            }
          } catch(NullPointerException ex){
              JOptionPane.showMessageDialog(null, "El campo Fecha de nacimiento debe estar diligenciado");
              pacienteVista.fechaNacimientoBox.requestFocus();
          }
      }
      
      if(e.getSource().equals(pacienteVista.botonNuevo)){
          limpiar();
      }
      if(e.getSource().equals(pacienteVista.botonCerrar)){
          pacienteVista.dispose();
      }
    }
    
    public void limpiar(){
        pacienteVista.txt_identificacion.setText("");
        pacienteVista.txt_nombre1.setText("");
        pacienteVista.txt_nombre2.setText("");
        pacienteVista.txt_apellido1.setText("");
        pacienteVista.txt_apellido2.setText("");
        pacienteVista.fechaNacimientoBox.setDate(null);
        pacienteVista.txt_identificacion.requestFocus();
    }
}
    


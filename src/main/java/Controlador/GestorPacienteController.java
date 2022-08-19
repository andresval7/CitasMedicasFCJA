/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import java.awt.event.*;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author elfos
 */
public class GestorPacienteController implements ActionListener {
    
    Modelo.GestorPaciente pacientesModelo;
    Vista.ConsPacienteFrame consultarPacienteVista;
    
    public GestorPacienteController(Vista.ConsPacienteFrame consultarPacienteVista){
        this.consultarPacienteVista = consultarPacienteVista;
        pacientesModelo = new Modelo.GestorPaciente();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        DefaultTableModel tmodelo;
        String valor = consultarPacienteVista.valorABuscar.getText();
        int parametro=0;
        
        if(consultarPacienteVista.rdbIdentificacion.isSelected()){
            parametro = 1;
        }
        if(consultarPacienteVista.rdbNombre.isSelected()){
            parametro = 2;
        }
        if(consultarPacienteVista.rdbApellido.isSelected()){
            parametro = 3;
        }
        
        LinkedList<Modelo.Paciente> pacientes = pacientesModelo.getPacienteByParametro(parametro,valor);
        String registro [] = new String[7];
        String titulos []= {
            "identificacion",
            "nombre1",
            "nombre2",
            "apellido1",
            "apellido2",
            "fechaNacimiento",
            "sexo"
        };
        
        
        
        if(e.getSource().equals(consultarPacienteVista.btn_buscar)){
            tmodelo = new DefaultTableModel();
            tmodelo.setColumnIdentifiers(titulos);
        
            for(Modelo.Paciente p:pacientes){
                registro[0]=p.getIdentificacion();
                registro[1]=p.getNombre1();
                registro[2]=p.getNombre2();
                registro[3]=p.getApellido1();
                registro[4]=p.getApellido2();
                registro[5]=p.getFechaNacimiento();
                registro[6]=p.getSexo(); 
                
            }
            consultarPacienteVista.tableData.setModel(tmodelo);
        }
        
        if(e.getSource().equals(consultarPacienteVista.btn_cerrar)){
            consultarPacienteVista.dispose();
        }
        
        
    }
    
}

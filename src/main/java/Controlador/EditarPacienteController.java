/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author elfos
 */
public class EditarPacienteController implements ActionListener{
    
    Modelo.GestorPaciente pacientesModelo;
    Modelo.Paciente actualizadoPaciente;
    Vista.EditarPacienteFrame editarPacienteVista;
    LinkedList<Modelo.Paciente> pacientes;

    public EditarPacienteController() {
    }
    
    public EditarPacienteController(Vista.EditarPacienteFrame editarPacienteVista){
        this.editarPacienteVista = editarPacienteVista;
        pacientesModelo = new Modelo.GestorPaciente();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        DefaultTableModel tmodelo;
        String valor = editarPacienteVista.valorABuscar.getText();
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
        
        if(e.getSource().equals(editarPacienteVista.btn_buscar)){
            
            tmodelo = new DefaultTableModel();
            pacientes = pacientesModelo.getPacienteByParametro(1,valor);
            System.out.println("Entre al boton buscar y busqué el valor: " + valor);
            if(pacientes.isEmpty())
                JOptionPane.showMessageDialog(null, "No se encontraron pacientes con ese número de documento");
            
            tmodelo.setColumnIdentifiers(titulos);
        
            for(Modelo.Paciente p:pacientes){
                registro[0]=p.getIdentificacion();
                registro[1]=p.getNombre1();
                registro[2]=p.getNombre2();
                registro[3]=p.getApellido1();
                registro[4]=p.getApellido2();
                registro[5]=p.getFechaNacimiento().toString();
                registro[6]=p.getSexo(); 
                tmodelo.addRow(registro);
            }
            editarPacienteVista.tableData.setModel(tmodelo);
        }
        
        if(e.getSource().equals(editarPacienteVista.btn_actualizar)){
          
            if(pacientes.isEmpty())
                JOptionPane.showMessageDialog(null, "No se encontraron pacientes con ese número de documento");
            else{
                String id = editarPacienteVista.tableData.getValueAt(1, 0).toString();
                String n1 = editarPacienteVista.tableData.getValueAt(1, 1).toString();
                String n2 = editarPacienteVista.tableData.getValueAt(1, 2).toString();
                String a1 = editarPacienteVista.tableData.getValueAt(1, 3).toString();
                String a2 = editarPacienteVista.tableData.getValueAt(1, 4).toString();
                SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
                String fNac = editarPacienteVista.tableData.getValueAt(1, 5).toString();
                try
                {
                    java.util.Date fechaUtil = formato.parse(fNac);
                    java.sql.Date fechaSql = new java.sql.Date(fechaUtil.getTime());
                    String sexo = editarPacienteVista.tableData.getValueAt(1, 6).toString();
                    long miliseconds = System.currentTimeMillis();
                    java.sql.Date hoy = new java.sql.Date(miliseconds);

                    if(id.equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "El campo de identificación debe estar diligenciado");

                    }
                    else if(n1.equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "El campo Nombre 1 debe estar diligenciado");

                    }
                    else if(a1.equals("")){
                        JOptionPane.showMessageDialog(null, "El campo Apellido 1 debe estar diligenciado");

                    }

                    else{
                        if(fechaSql.getTime()<=hoy.getTime())
                        {
                            actualizadoPaciente = new Modelo.Paciente(id,n1,n2,a1,a2,fechaSql,sexo);
                            pacientesModelo.ActualizarPaciente(actualizadoPaciente);

                        }
                        else
                            JOptionPane.showMessageDialog(null, "La fecha no debe ser posterior al día de hoy");
                    }
                }
                catch(NullPointerException ex){
                    JOptionPane.showMessageDialog(null, "El campo Fecha de nacimiento debe estar diligenciado"); 
                }
                catch(ParseException pEx){
                      JOptionPane.showMessageDialog(null, "El campo Fecha de nacimiento debe ser de la forma yyyy/mm/dd");
                }
            }
            if(e.getSource().equals(editarPacienteVista.btn_cerrar)){
                editarPacienteVista.dispose();
            }
        }
    }
}
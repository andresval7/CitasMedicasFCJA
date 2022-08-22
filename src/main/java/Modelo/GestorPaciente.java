/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Recursos.Conexion;
/**
 *
 * @author Andrés Vallejo
 */
public class GestorPaciente {
    private static LinkedList<Paciente> pacientes;
    private static Connection conex;
    
    public GestorPaciente(){
        //pacientes = new LinkedList<>();
        conex = Recursos.Conexion.establecerConexion();
        
        
    }
    //1er metodo del CRUD -> Create paciente
    public void RegistrarPaciente (Paciente paciente){
        //pacientes.add(paciente);
        PreparedStatement pst;
        try{
            pst = conex.prepareStatement("insert into TblPacientes values(?,?,?,?,?,?,?)");
            pst.setString(1, paciente.getIdentificacion());
            pst.setString(2, paciente.getNombre1());
            pst.setString(3, paciente.getNombre2());
            pst.setString(4, paciente.getApellido1());
            pst.setString(5, paciente.getApellido2());
            pst.setDate(6, paciente.getFechaNacimiento());
            pst.setString(7, paciente.getSexo());
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Paciente registrado");
        }
        catch(SQLException ex){
            Logger.getLogger(GestorPaciente.class.getName()).log(Level.SEVERE, null, ex);
            if(ex.getErrorCode()==2627){
                JOptionPane.showMessageDialog(null, "Este número de documento ya existe, el registro no fue realizado");
            }
            
        }
    }
    //2do método del CRUD -> Read paciente de acuerdo a un parámetro
    public LinkedList<Paciente> getPacienteByParametro(int parametro, String valor){
        LinkedList<Paciente> resultado = new LinkedList<>();
        String instruccionSql="";
        switch(parametro)
        {
            case 1 -> {
                instruccionSql= "Select * from TblPacientes where IdPaciente ='" + valor+"' ";
                break;
            }
            case 2 -> {
                valor = valor.toUpperCase();
                valor = valor.trim();
                String[] newStr = valor.split("\\s+");
                if(newStr.length >1 )
                {
                    instruccionSql = "Select * from TblPacientes where Nombre1='"+newStr[0]+"' and Nombre2='"+newStr[1]+"'";
                }
                else {
                    instruccionSql = "Select * from TblPacientes where Nombre1='"+valor+"' ";                      
                }
                break;
            }
                        
            case 3 -> {
                valor = valor.trim();
                String[] newStr1 = valor.split("\\s+");
                if(newStr1.length >1 )
                {
                    instruccionSql = "Select * from TblPacientes where Apellido1='"+newStr1[0]+"' and Apellido2='"+newStr1[1]+"' ";
                }
                else {
                    instruccionSql = "Select * from TblPacientes where Apellido1='"+valor+"'";
                }
                break;
            }   
        }
        
        //JOptionPane.showMessageDialog(null, instruccionSql);
        
        try{
            PreparedStatement st=conex.prepareStatement(instruccionSql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                resultado.add(new Paciente(rs.getString("IdPaciente"),
                        rs.getString("Nombre1"),
                        rs.getString("Nombre2"),
                        rs.getString("Apellido1"),
                        rs.getString("Apellido2"), 
                        rs.getDate("Fechanacimiento"),
                        rs.getString("Sexo")));  
            }
            st.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
            
        
        return resultado;
    }
    
}

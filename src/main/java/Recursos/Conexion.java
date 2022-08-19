/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recursos;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author elfos
 */
public class Conexion {
    
    Connection conectarDB;
    
    String user = "userCitasMedicas";
    String pass = "citasMedicas";
    String bd = "DBCitasMedicas";
    String ip = "localhost";
    String port ="1433";
    
    String cadena = "jdbc:sqlserver://"+ip+":"+port+"/"+bd;
    
    public Connection establecerConexion(){
        try{
            String cadena = "jdbc:sqlserver://localhost:"+port+":"+"databaseName="+bd;
            conectarDB = DriverManager.getConnection(cadena,user,pass);
            JOptionPane.showMessageDialog(null,"Se conectó a la base de datos exitosamente");
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error al conectar a la Base de Datos."+ex.toString());
        }
        
        return conectarDB;
    }
    
}

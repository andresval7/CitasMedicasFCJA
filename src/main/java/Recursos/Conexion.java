/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recursos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author elfos
 */
public class Conexion {
    
    //Connection conectarDB;
    
    String user = "userCitasMedicas";
    String pass = "citasM";
    String bd = "DBCitasMedicas";
    String ip = "localhost";
    String port ="1433";
    
    //String cadena = "jdbc:sqlserver://"+ip+":"+port+"/"+bd;
    
    /*public Conexion(){
        
    }*/
    
    public static Connection establecerConexion(){
        try{
            String cadena = "jdbc:sqlserver://localhost:1433;"
                    +"databaseName=DBCitasMedicas;"
                    +"encrypt=true;"
                    +"trustServerCertificate=true;"
                    +"user=userCitasMedicas;"
                    +"password=citasM;";
            
            Connection conectarDB = DriverManager.getConnection(cadena);
            //JOptionPane.showMessageDialog(null,"Se conectó a la base de datos exitosamente");
            return conectarDB;
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al conectar a la Base de Datos."+ex.toString());
            System.out.println(ex.toString());
            return null;
        }   
    }
    
    /*
    public Connection CerrarConexion(){
        try{
           conectarDB.close();
            conectarDB = null; 
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al desconectar a la Base de Datos."+ex.toString());
            System.out.println(ex.toString());
        }
        
        return conectarDB;
    }
    */
    
}

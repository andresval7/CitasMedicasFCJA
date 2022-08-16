/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.*;
/**
 *
 * @author Andrés Vallejo
 */
public class GestorPaciente {
    private static LinkedList<Paciente> pacientes;
    
    public GestorPaciente(){
        pacientes = new LinkedList<>();
    }
    
    public void RegistrarPaciente (Paciente paciente){
        pacientes.add(paciente);
    }
    
    public static LinkedList<Paciente> getPacienteByParametro(int parametro, String valor){
        LinkedList<Paciente> resultado = new LinkedList<>();
        for(Paciente pac:pacientes)
        {
            switch(parametro){
                case 1 -> {
                    if(pac.getIdentificacion().equals(valor))
                        resultado.add(pac);
                }
                case 2 -> {
                    valor = valor.trim();
                    String[] newStr = valor.split("\\s+");
                    if(newStr.length >1 )
                    {
                        if(pac.getNombre1().equals(newStr[0]) || pac.getNombre2().equals(newStr[1]))
                            resultado.add(pac);
                        
                    }
                    else {
                        if(pac.getNombre1().equals(newStr[0]))
                            resultado.add(pac);
                    }
                }
                        
                case 3 -> {
                    valor = valor.trim();
                    String[] newStr1 = valor.split("\\s+");
                    if(newStr1.length >1 )
                    {
                        if(pac.getNombre1().equals(newStr1[0]) || pac.getNombre2().equals(newStr1[1]))
                            resultado.add(pac);
                        
                    }
                    else {
                        if(pac.getNombre1().equals(newStr1[0]))
                            resultado.add(pac);
                    }
                }
                
            }
        }
        return resultado;
    }
    
}

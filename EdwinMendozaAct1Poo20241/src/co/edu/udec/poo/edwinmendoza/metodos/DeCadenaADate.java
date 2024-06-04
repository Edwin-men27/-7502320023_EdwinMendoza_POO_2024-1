/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.edwinmendoza.metodos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edwin
 */
public class DeCadenaADate {
    
    
    
    public static Date convertir(String cadena){
        
        String fechaConvertir = cadena;
        Date fechaConvertida = null;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            fechaConvertida = formato.parse(fechaConvertir);
        } catch (ParseException ex) {
            Logger.getLogger(DeCadenaADate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return fechaConvertida;
    }
    
}

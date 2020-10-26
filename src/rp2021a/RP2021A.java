/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rp2021a;

import data.Clasificador;
import data.LeerDatos;
import data.Patron;
import data.PuntosCaracteristicos;
import java.util.ArrayList;
import data.Resultado;
import javax.swing.JOptionPane;

/**
 *
 * @author working
 */
public class RP2021A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Patron N = new Patron("","", new double[]{1.4,34.6,8,2.4});//Niño
        Patron A = new Patron("","", new double[]{1.83,74.2,35,11.9});//Adulto
        Patron V = new Patron("","", new double[]{1.83,75,11,2.03});//Viejo
        
        ArrayList<Patron> datos = LeerDatos.tokenizarDataSet();
        
        Resultado RN = Clasificador.calcularDistancia(PuntosCaracteristicos.calcular(datos), N);
        Resultado RA = Clasificador.calcularDistancia(PuntosCaracteristicos.calcular(datos), A);
        Resultado RV = Clasificador.calcularDistancia(PuntosCaracteristicos.calcular(datos), V);
        
        
        
        JOptionPane.showMessageDialog(null, "El patron: "+N.mostrarVector()+" pertenece a la clase "+RN.getClase(), "Mensaje en la barra de titulo", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "El patron: "+A.mostrarVector()+" pertenece a la clase "+RA.getClase(), "Mensaje en la barra de titulo", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "El patron: "+V.mostrarVector()+" pertenece a la clase "+RV.getClase(), "Mensaje en la barra de titulo", JOptionPane.INFORMATION_MESSAGE);
        
        
        System.out.println();
        // TODO: TOKENIZADOR PARA PODER SEPARAR POR COMAS Y GENERAR UN COLECCION DE PATRONES
        
    }
    
}

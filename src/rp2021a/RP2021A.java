/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rp2021a;

import data.LeerDatos;
import data.Patron;
import data.PuntosCaracteristicos;
import java.util.ArrayList;

/**
 *
 * @author working
 */
public class RP2021A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Patron j = new Patron("","", new double[]{5.1,3.5,1.4,0.2});  
        
        double miMelon2 = PuntosCaracteristicos.calcularDistancia(LeerDatos.tokenizarDataSet(), j);
        
        System.out.println();
        // TODO: TOKENIZADOR PARA PODER SEPARAR POR COMAS Y GENERAR UN COLECCION DE PATRONES
        
    }
    
}

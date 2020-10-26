/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import static data.PuntosCaracteristicos.calcular;
import java.util.ArrayList;

/**
 *
 * @author peper
 */
public class Clasificador 
{
    static double[] distancias = null;
    static String[] clases = null;
        
    public static Resultado calcularDistancia(ArrayList<Patron> instancias2, Patron p)
    {
        ArrayList<Patron> patronesCaracteristicos = calcular(instancias2);
        
        distancias = new double[patronesCaracteristicos.size()];
        clases = new String[patronesCaracteristicos.size()];
        
        for(int x=0; x< patronesCaracteristicos.size(); x++)
        {
            distancias[x] = p.calcularDistancia(patronesCaracteristicos.get(x));
            clases[x] = patronesCaracteristicos.get(x).getClase();
        }
        
        burbuja();
        
        Resultado R = new Resultado(clases[distancias.length-1] , distancias[distancias.length-1]);
        
        return R;
    }
    
    public static void burbuja()
    {
       for(int i = 0; i < distancias.length - 1; i++)
        {
            for(int j = 0; j < distancias.length - 1; j++)
            {
                if (distancias[j] < distancias[j + 1])
                {
                    double tmp = distancias[j+1];
                    distancias[j+1] = distancias[j];
                    distancias[j] = tmp;
                    
                    String tmp2 = clases[j+1];
                    clases[j+1] = clases[j];
                    clases[j] = tmp2;
                }
            }
        }
    }
}

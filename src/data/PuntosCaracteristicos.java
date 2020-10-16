/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author peper
 */
public class PuntosCaracteristicos
{   
    
    public static ArrayList<Patron> calcular(ArrayList<Patron> instancias2)
    {
        ArrayList<Patron> patronesCaracteristicos = new ArrayList<>();
        int numPatrones = 0;
        ArrayList<Patron> instancias = instancias2;
        double[] sumaCaracteristicas;
        
        
        sumaCaracteristicas = new double[instancias.get(0).getcarac()];
        for(int h = 0; h<instancias.get(0).getcarac(); h++)//metodo
        {
            sumaCaracteristicas[h] = 0;
        }   
        
        String claseActual = instancias.get(0).getClase();
        //String subclaseActual = instancias.get(0).getClase();
        
        for(int x = 0 ; x<  instancias.size();x++)
        {
            //subclaseActual = instancias.get(x).getClase();
            
            if(claseActual.equals(instancias.get(x).getClase()))
            {
                for(int h = 0; h<instancias.get(0).getcarac(); h++)
                {
                   sumaCaracteristicas[h] +=  instancias.get(x).getVectorC()[h];
                   
                }
                numPatrones++;
            }
            else
            {
                patronesCaracteristicos.add(patronCaracteristico(sumaCaracteristicas,claseActual,numPatrones));
                
                sumaCaracteristicas = new double[instancias.get(0).getcarac()];
                for(int h = 0; h<instancias.get(0).getcarac(); h++)//metodo
                {
                    sumaCaracteristicas[h] = 0;
                }   
                
                claseActual = instancias.get(x).getClase(); 
                numPatrones = 0;
                x--;
            }
        }
        
        
        patronesCaracteristicos.add(patronCaracteristico(sumaCaracteristicas,claseActual,numPatrones));
        System.out.println();
        return patronesCaracteristicos;     
    }
    
    
    public static Patron patronCaracteristico(double[] suma, String clase, int numPatrones)
    {
        
        for(int f = 0; f<suma.length; f++)
        {
            suma[f] = suma[f] / numPatrones;
        }
        Patron p = new Patron(clase, "", suma);
        return p;
    }
    
    
    public static double calcularDistancia(ArrayList<Patron> instancias2, Patron p)
    {
        ArrayList<Patron> patronesCaracteristicos = calcular(instancias2);
        
        double[] distancias = new double[patronesCaracteristicos.size()];
        for(int x=0; x< patronesCaracteristicos.size(); x++)
        {
            distancias[x] = p.calcularDistancia(patronesCaracteristicos.get(x));
        }
        distancias = burbuja(distancias);
        
        return distancias[distancias.length-1];
    }
    
    public static double[] burbuja(double[] arreglo)
    {
       for(int i = 0; i < arreglo.length - 1; i++)
        {
            for(int j = 0; j < arreglo.length - 1; j++)
            {
                if (arreglo[j] < arreglo[j + 1])
                {
                    double tmp = arreglo[j+1];
                    arreglo[j+1] = arreglo[j];
                    arreglo[j] = tmp;
                }
            }
        }
      return arreglo;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author peper
 */
public class Resultado 
{
    String clase;
    double distancia;

    public Resultado(String Clase, double distancia) 
    {
        this.clase = Clase;
        this.distancia = distancia;
    }
    
    public String getClase() {
        return clase;
    }

    public double getDistancia() {
        return distancia;
    }
    
}

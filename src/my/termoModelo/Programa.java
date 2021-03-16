/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.termoModelo;

import java.util.ArrayList;

/**
 *
 * @author Juan Antonio Pagés
 * @author Fernando San José
 */
public class Programa {
    private int max;
    private int min;
    ArrayList<Boolean> p;
    
    public Programa(){
        max = 25;
        min = 19;
        p = new ArrayList<>(6);
        
        for (int i=0; i<6; i++){
            p.add(false);
            
        }
    }
    
    /**
     * Obtiene la temperatura maxima
     * @return max
     */
    public int getMax(){
        return this.max;
    }
    /**
     * Almacena la temperatura maxima
     * @param maxima 
     */
    public void setMax(int maxima){
        this.max = maxima;
    }
    /**
     * Obtiene la temperatura minima
     * @return min
     */
    public int getMin(){
        return this.min;
    }
    /**
     * Almacena la temperatura minima
     * @param minima 
     */
    public void setMin(int minima){
        this.min = minima;
    }
    /**
     * Obtiene ArrayList de booleans 
     * @return ArrayList de booleans 
     */
    public ArrayList<Boolean> getProgramButtons(){
       
        return this.p;
    }
    /**
     * Almacena ArrayList de booleans
     * @param p 
     */
    public void setProgramButtons(ArrayList<Boolean> p){
        this.p = p;
    }
    
}

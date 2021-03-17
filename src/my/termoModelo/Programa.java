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
    private ArrayList<Boolean> p;
    private ArrayList<Integer> temps;
    
    public Programa(){
        
        max = 0;
        min = 0;
        
        p = new ArrayList<>(6);
        temps = new ArrayList<>(2);
        
        for (int i=0; i<6; i++){
            p.add(false);
            
        }
        
        for(int i =0;i<2;i++){
            temps.add(0);
        }
    }
    
    /**
     * Obtiene las temperaturas mínima y máxima
     * @return temps
     */
    public ArrayList<Integer> getProgramTemps(){
        return this.temps;
    }
    
    /**
     * Almacena las temperaturas mínima y máxima
     * @param temps
     */
    public void setProgramTemps(ArrayList<Integer> temps){
        this.temps = temps;
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

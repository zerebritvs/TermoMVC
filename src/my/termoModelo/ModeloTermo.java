/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.termoModelo;

import java.util.ArrayList;

/**
 * Clase Modelo del patrón de diseño MVC
 * @author Juan Antonio Pagés
 * @author Fernando San José
 */
public class ModeloTermo {
    
    private boolean power;
    private int modo;
    private ArrayList<Programa> programas;
    
    /**
     * Constructor de ModeloTermo
     */
    public ModeloTermo(){
        
        power = false;
        modo = 0;
        programas = new ArrayList<>(3);
        
        for(int i=0; i<3;i++){
            
            programas.add(new Programa());   
        }
    }
    
    /**
     * Alterna entre 0n/Off
     * @param power 
     */
    public void setPower(boolean power){
      this.power = power;
    }
    
    /**
     * Comprueba si el sistema esta On/Off
     * @return power
     */
    public boolean getPower(){
        return this.power;
    }
    
    /**
     * Alterna entre modos de funcionamiento del sistema
     * @param modo
     */
    public void setModo(int modo){
      this.modo = modo;
    }
    
    /**
     * Obtiene el modo de funcionamiento del sistema
     * @return modo
     */
    public int getModo(){
        return this.modo;
    }
    
    /**
     * Obtiene un ArrayList con los programas
     * @return programas
     */
    public ArrayList<Programa> getPrograma(){
        
        return this.programas;
    }
    
    /**
     * Almacena en un ArrayList los programas 
     * @param programas
     */
    public void setPrograma(ArrayList<Programa> programas){
        this.programas = programas;
    }
    
}

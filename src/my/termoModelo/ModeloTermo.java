/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.termoModelo;


/**
 *
 * @author Juan Antonio Pagés
 * @author Fernando San José
 */
public class ModeloTermo {
    private boolean power;
    private int modo;
    
    
    /**
     * Constructor de ModeloTermo
     */
    public ModeloTermo(){
        power = false;
        modo = 0;
 
       
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
     * Alterna entre modos
     * @param modo
     */
    public void setModo(int modo){
      this.modo = modo;
    }
    
    /**
     * Obtiene el modo del sistema
     * @return modo
     */
    public int getModo(){
        return this.modo;
    }
}

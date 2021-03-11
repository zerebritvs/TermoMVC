/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.termoModelo;


/**
 *
 * @author juan
 */
public class ModeloTermo {
    private boolean power;
    private boolean manual;
    private boolean auto;
    private boolean edit;
    
    
    /**
     * Constructor de ModeloTermo
     */
    public ModeloTermo(){
        power = false;
        manual = false;
        auto = false;
        edit = false;
 
       
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
     * Alterna entre Edit/No edit
     * @param edit
     */
    public void setEdit(boolean edit){
      this.edit = edit;
    }
    
    /**
     * Comprueba si el sistema esta en modo edición
     * @return edit
     */
    public boolean getEdit(){
        return this.edit;
    }
    
    /**
     * Alterna entre Manual/No manual
     * @param manual 
     */
    public void setManual(boolean manual){
      this.manual = manual;
    }
    
    /**
     * Comprueba si el sistema esta en modo Manual/No manual
     * @return power
     */
    public boolean getManual(){
        return this.manual;
    }
    
    /**
     * Alterna entre Auto/No auto
     * @param auto 
     */
    public void setAuto(boolean auto){
      this.auto = auto;
    }
    
    /**
     * Comprueba si el sistema esta en modo Auto/No auto
     * @return auto
     */
    public boolean getAuto(){
        return this.auto;
    }
   
}

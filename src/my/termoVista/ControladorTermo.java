/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.termoVista;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JPanel;
import my.termoModelo.ModeloTermo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.swing.ImageIcon;

/**
 *
 * @author Juan Antonio Pagés
 * @author Fernando San José
 */
public class ControladorTermo {
    private VistaUI miVista;
    private ModeloTermo miModelo;
    
    public ControladorTermo(VistaUI v, ModeloTermo m){
        
        miVista = v;
        miModelo = m;
    }
    

    private void setPanelEnabled(JPanel panel, Boolean isEnabled) {
        panel.setEnabled(isEnabled);

        Component[] components = panel.getComponents();

        for (Component component : components) {
            if (component instanceof JPanel) {
                setPanelEnabled((JPanel) component, isEnabled);
            }
            component.setEnabled(isEnabled);
        }
    }
    
    /**
     * Inicializa el sistema
     */
    public void initTermo(){
        
        setPanelEnabled(miVista.getPanelDias(), false);
        setPanelEnabled(miVista.getPanelMedio(), false);
        miVista.getToggleButtonAuto().setEnabled(false);
        miVista.getToggleButtonManual().setEnabled(false);
        miVista.getToggleButtonEdit().setEnabled(false);
        
        miVista.getLabelHoras().setVisible(false);
        miVista.getSpinnerSelectHora().setVisible(false);
        miVista.getButtonIniciar().setVisible(false);
        
        miVista.getSpinnerMaxima().setVisible(false);
        miVista.getSpinnerMinima().setVisible(false);
        miVista.getSpinnerMaxima().setVisible(false);
        miVista.getSpinnerMinima().setVisible(false);
        miVista.getLabelMaxima().setVisible(false);
        miVista.getLabelMinima().setVisible(false);
        
        miVista.getToggleButtonOn().setText("ON  ");
        
        
    }
    
    /**
     * 
     * Cambia entre los modos Automático, Manual y Editar
     * @param modo 
     */
    public void cambiaModo(int modo){
        
        miModelo.setModo(modo);
        
        switch(modo){
            
            case 0: //Auto
                
                setPanelEnabled(miVista.getPanelSelectHoras(), false);
                
                miVista.getLabelHoras().setVisible(false);
                miVista.getSpinnerSelectHora().setVisible(false);
                miVista.getButtonIniciar().setVisible(false);
                
                miVista.getSpinnerMaxima().setVisible(false);
                miVista.getSpinnerMinima().setVisible(false);
                miVista.getLabelMaxima().setVisible(false);
                miVista.getLabelMinima().setVisible(false);
                
                
                miVista.getLabelIcono().setIcon(new ImageIcon("Auto.png"));
                
                break;
            
            case 1: //Manual
                
                setPanelEnabled(miVista.getPanelSelectHoras(), false);
                
                miVista.getLabelHoras().setVisible(true);
                miVista.getSpinnerSelectHora().setVisible(true);
                miVista.getButtonIniciar().setVisible(true);
                
                miVista.getSpinnerMaxima().setVisible(false);
                miVista.getSpinnerMinima().setVisible(false);
                miVista.getLabelMaxima().setVisible(false);
                miVista.getLabelMinima().setVisible(false);
                
                miVista.getLabelIcono().setIcon(new ImageIcon("imagenManual.jpg"));
                
                break;
                
            case 2: //Editar
                
                setPanelEnabled(miVista.getPanelSelectHoras(), true);
                
                miVista.getSpinnerMaxima().setVisible(true);
                miVista.getSpinnerMinima().setVisible(true);
                miVista.getLabelMaxima().setVisible(true);
                miVista.getLabelMinima().setVisible(true);
            
                miVista.getLabelHoras().setVisible(false);
                miVista.getSpinnerSelectHora().setVisible(false);
                miVista.getButtonIniciar().setVisible(false);
                
                miVista.getLabelIcono().setIcon(null);
                
                break;
            
            
        }
        
        
    }
    
    /**
     * Alterna entre On/Off el sistema habilitando/deshabilitando los componentes
     */
    public void powerButtonSwitch(){
        
        if(!miModelo.getPower()){
            
            miModelo.setPower(true);
            setPanelEnabled(miVista.getPanelDias(), true);
            setPanelEnabled(miVista.getPanelMedio(), true);
            setPanelEnabled(miVista.getPanelOpciones(), true);
            setPanelEnabled(miVista.getPanelSelectHoras(), false);
            miVista.getToggleButtonOn().setText("OFF");
            
        }else{
            
            miModelo.setPower(false);
            setPanelEnabled(miVista.getPanelDias(), false);
            setPanelEnabled(miVista.getPanelMedio(), false);
            setPanelEnabled(miVista.getPanelSelectHoras(), false);
            miVista.getToggleButtonAuto().setEnabled(false);
            miVista.getToggleButtonManual().setEnabled(false);
            miVista.getToggleButtonEdit().setEnabled(false);
            miVista.getToggleButtonOn().setText("ON  ");
        }
    }
    
    /**
     * Establece la hora actual del sistema
     */
    public void setLocalHour(){
        
        LocalDateTime localDate = LocalDateTime.now();
        int hours = localDate.getHour();
        int minutes = localDate.getMinute();
        
        if(hours < 10 && minutes < 10){
            miVista.getTextFieldHora().setText("0"+hours+":0"+minutes);
        }
        else if(hours < 10 && minutes >= 10){
            miVista.getTextFieldHora().setText("0"+hours+":"+minutes);
        }
        else if(hours >= 10 && minutes < 10){
            miVista.getTextFieldHora().setText(hours+":0"+minutes);
        }
        else{
            miVista.getTextFieldHora().setText(hours+":"+minutes);
        }
        
    }
    
    /**
     * Establece el día de la semana del sistema
     */
    public void setDayOfWeek(){
        
        int day = LocalDate.now().getDayOfWeek().getValue();
        
        switch(day){
            
            case 1: //Lunes
                
                miVista.getLabelMartes().setForeground(Color.black);
                miVista.getLabelMiercoles().setForeground(Color.black);
                miVista.getLabelJueves().setForeground(Color.black);
                miVista.getLabelViernes().setForeground(Color.black);
                miVista.getLabelSabado().setForeground(Color.black);
                miVista.getLabelDomingo().setForeground(Color.black);
                miVista.getLabelLunes().setForeground(Color.red);
                
                break;
                
            case 2: //Martes
                
                miVista.getLabelMiercoles().setForeground(Color.black);
                miVista.getLabelJueves().setForeground(Color.black);
                miVista.getLabelViernes().setForeground(Color.black);
                miVista.getLabelSabado().setForeground(Color.black);
                miVista.getLabelDomingo().setForeground(Color.black);
                miVista.getLabelLunes().setForeground(Color.black);
                miVista.getLabelMartes().setForeground(Color.red);
                
                break;
                
            case 3: //Miercoles
                
                miVista.getLabelJueves().setForeground(Color.black);
                miVista.getLabelViernes().setForeground(Color.black);
                miVista.getLabelSabado().setForeground(Color.black);
                miVista.getLabelDomingo().setForeground(Color.black);
                miVista.getLabelLunes().setForeground(Color.black);
                miVista.getLabelMartes().setForeground(Color.black);
                miVista.getLabelMiercoles().setForeground(Color.red);
                
                break;
            
            case 4: //Jueves
                
                miVista.getLabelViernes().setForeground(Color.black);
                miVista.getLabelSabado().setForeground(Color.black);
                miVista.getLabelDomingo().setForeground(Color.black);
                miVista.getLabelLunes().setForeground(Color.black);
                miVista.getLabelMartes().setForeground(Color.black);
                miVista.getLabelMiercoles().setForeground(Color.black);
                miVista.getLabelJueves().setForeground(Color.red);
                
                break;
                
            case 5: //Viernes
                
                miVista.getLabelSabado().setForeground(Color.black);
                miVista.getLabelDomingo().setForeground(Color.black);
                miVista.getLabelLunes().setForeground(Color.black);
                miVista.getLabelMartes().setForeground(Color.black);
                miVista.getLabelMiercoles().setForeground(Color.black);
                miVista.getLabelJueves().setForeground(Color.black);
                miVista.getLabelViernes().setForeground(Color.red);
                
                break;
            
            case 6: //Sabado
               
                miVista.getLabelDomingo().setForeground(Color.black);
                miVista.getLabelLunes().setForeground(Color.black);
                miVista.getLabelMartes().setForeground(Color.black);
                miVista.getLabelMiercoles().setForeground(Color.black);
                miVista.getLabelJueves().setForeground(Color.black);
                miVista.getLabelViernes().setForeground(Color.black);
                miVista.getLabelSabado().setForeground(Color.red);
                
                break;
                
            case 7: //Domingo
                
                miVista.getLabelLunes().setForeground(Color.black);
                miVista.getLabelMartes().setForeground(Color.black);
                miVista.getLabelMiercoles().setForeground(Color.black);
                miVista.getLabelJueves().setForeground(Color.black);
                miVista.getLabelViernes().setForeground(Color.black);
                miVista.getLabelSabado().setForeground(Color.black);
                miVista.getLabelDomingo().setForeground(Color.red);
                
                break;
            
        }
    }
    
}


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
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import my.termoModelo.Programa;

/**
 * Clase Controlador del patrón de diseño MVC
 * @author Juan Antonio Pagés
 * @author Fernando San José
 */
public class ControladorTermo {
    
    private VistaUI miVista;
    private ModeloTermo miModelo;
    
    /**
     * Contructor de ControladorTermo
     * @param v
     * @param m 
     */
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
        
        miVista.getLabelIcono().setIcon(new ImageIcon(getClass().getResource("/my/termoVista/Vacio.png")));
        
        miVista.getToggleButtonOn().setText("ON  ");
        
        miVista.getSpinnerMinima().setValue(0);
        miVista.getSpinnerMaxima().setValue(0);
        
    }
    
    /**
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
                
                miVista.getSpinnerMaxima().setVisible(true);
                miVista.getSpinnerMinima().setVisible(true);
                miVista.getLabelMaxima().setVisible(true);
                miVista.getLabelMinima().setVisible(true);
                
                miVista.getSpinnerMaxima().setEnabled(false);
                miVista.getSpinnerMinima().setEnabled(false);
                miVista.getLabelMaxima().setEnabled(false);
                miVista.getLabelMinima().setEnabled(false);
                
                miVista.getLabelIcono().setIcon(new ImageIcon(getClass().getResource("/my/termoVista/Auto.png")));
                
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
                
                miVista.getLabelIcono().setIcon(new ImageIcon(getClass().getResource("/my/termoVista/Manual.png")));
                
                break;
                
            case 2: //Editar
                
                setPanelEnabled(miVista.getPanelSelectHoras(), true);
                
                miVista.getSpinnerMaxima().setVisible(true);
                miVista.getSpinnerMinima().setVisible(true);
                miVista.getLabelMaxima().setVisible(true);
                miVista.getLabelMinima().setVisible(true);
                
                miVista.getSpinnerMaxima().setEnabled(true);
                miVista.getSpinnerMinima().setEnabled(true);
                miVista.getLabelMaxima().setEnabled(true);
                miVista.getLabelMinima().setEnabled(true);
            
                miVista.getLabelHoras().setVisible(false);
                miVista.getSpinnerSelectHora().setVisible(false);
                miVista.getButtonIniciar().setVisible(false);
                
                miVista.getLabelIcono().setIcon(new ImageIcon(getClass().getResource("/my/termoVista/Vacio.png")));
                
                break;
        }
     
    }
    
    /**
     * Alterna entre On/Off el sistema habilitando/deshabilitando los componentes correspondientes
     */
    public void powerButtonSwitch(){
        
        if(!miModelo.getPower()){
            
            miModelo.setPower(true);
            setPanelEnabled(miVista.getPanelDias(), true);
            setPanelEnabled(miVista.getPanelMedio(), true);
            setPanelEnabled(miVista.getPanelOpciones(), true);
            setPanelEnabled(miVista.getPanelSelectHoras(), false);
            miVista.getLabelIcono().setVisible(true);
            miVista.getToggleButtonOn().setText("OFF");
            
        }else{
            
            miModelo.setPower(false);
            setPanelEnabled(miVista.getPanelDias(), false);
            setPanelEnabled(miVista.getPanelMedio(), false);
            setPanelEnabled(miVista.getPanelSelectHoras(), false);
            miVista.getToggleButtonAuto().setEnabled(false);
            miVista.getToggleButtonManual().setEnabled(false);
            miVista.getToggleButtonEdit().setEnabled(false);
            miVista.getLabelIcono().setVisible(false);
            miVista.getToggleButtonOn().setText("ON  ");
            
        }
    }
    
    /**
     * Alterna activando/desactivando la calefacción en el modo Manual
     */
    public void setIniciarManual(){
         
        if(!miVista.getTextFieldTemp().getForeground().equals(Color.red)){
                miVista.getTextFieldTemp().setForeground(Color.red);
                miVista.getButtonIniciar().setText("Finalizar");
        }else{
            miVista.getTextFieldTemp().setForeground(Color.black);
            miVista.getButtonIniciar().setText("Iniciar");
        }
        
    }
    
    /**
     * Alterna entre los diferentes programas mostrando en la interfaz la información correspondiente
     */
    public void selectPrograms(){
        
        Programa temp = miModelo.getPrograma().get(miVista.getComboBoxPrograms().getSelectedIndex());
        
        for(int i = 0; i < 2; i++){
            
            if(i==0){
                miVista.getSpinnerMinima().setValue(temp.getProgramTemps().get(i));
            }else{
                miVista.getSpinnerMaxima().setValue(temp.getProgramTemps().get(i));
            }
        }
        
        Component[]comps = miVista.getPanelSelectHoras().getComponents();
        JToggleButton []botones = new JToggleButton [6];
        
        for(int i = 0; i < comps.length; i++){
            botones[i] = (JToggleButton)comps[i];
        }
        
        for(int j = 0; j < botones.length; j++){
            
            if(temp.getProgramButtons().get(j)){
                botones[j].setSelected(true);
                
            }else{
                botones[j].setSelected(false);
            }
            
        }
        
    }
    
    /**
     * Almacena la información de los botones de los diferentes programas
     * @param button 
     */
    public void editPrograms(int button){
        
        int programa = miVista.getComboBoxPrograms().getSelectedIndex();
        
        switch(programa){
            
            case 0:
                
                boolean select = miModelo.getPrograma().get(0).getProgramButtons().get(button);
                miModelo.getPrograma().get(0).getProgramButtons().set(button, !select);
                
                break;
            
            case 1:
                
                boolean select2 = miModelo.getPrograma().get(1).getProgramButtons().get(button);
                miModelo.getPrograma().get(1).getProgramButtons().set(button, !select2);
                
                break;
                
            case 2:
                
                boolean select3 = miModelo.getPrograma().get(2).getProgramButtons().get(button);
                miModelo.getPrograma().get(2).getProgramButtons().set(button, !select3);
                
                break;  
        }
        
    }
    
    /**
     * Almacena las temperaturas máximas y mínimas de los diferentes programas en Programa
     * @param temp
     */
    public void editTemperatura(int temp){
        
        int programa = miVista.getComboBoxPrograms().getSelectedIndex();
        
        switch(programa){
            
            case 0:
                
                if(temp == 0){
                    miModelo.getPrograma().get(0).getProgramTemps().set(temp, (Integer)miVista.getSpinnerMinima().getValue());
                }else{
                    miModelo.getPrograma().get(0).getProgramTemps().set(temp, (Integer)miVista.getSpinnerMaxima().getValue());
                }
                
                break;
            
            case 1:
                
                if(temp == 0){
                    miModelo.getPrograma().get(1).getProgramTemps().set(temp, (Integer)miVista.getSpinnerMinima().getValue());
                }else{
                    miModelo.getPrograma().get(1).getProgramTemps().set(temp, (Integer)miVista.getSpinnerMaxima().getValue());
                }
                
                break;
                
            case 2:
                
                if(temp == 0){
                    miModelo.getPrograma().get(2).getProgramTemps().set(temp, (Integer)miVista.getSpinnerMinima().getValue());
                }else{
                    miModelo.getPrograma().get(2).getProgramTemps().set(temp, (Integer)miVista.getSpinnerMaxima().getValue());
                }
                            
                break;
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
            miVista.getTextFieldHora().setText("0" + hours + ":0" + minutes);
        }
        else if(hours < 10 && minutes >= 10){
            miVista.getTextFieldHora().setText("0" + hours + ":" + minutes);
        }
        else if(hours >= 10 && minutes < 10){
            miVista.getTextFieldHora().setText(hours + ":0" + minutes);
        }
        else{
            miVista.getTextFieldHora().setText(hours + ":" + minutes);
        }
        
    }
    
    /**
     * Establece el día de la semana en el sistema
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


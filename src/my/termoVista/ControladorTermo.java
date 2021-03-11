/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.termoVista;

import java.awt.Component;
import javax.swing.JPanel;
import my.termoModelo.ModeloTermo;

/**
 *
 * @author juan
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
     * Alterna entre On/Off el sistema habilitando/deshabilitando los componentes
     */
    public void powerButtonSwitch(){
        
        if(!miModelo.getPower()){
            
            miModelo.setPower(true);
            setPanelEnabled(miVista.getPanelDias(), true);
            setPanelEnabled(miVista.getPanelMedio(), true);
            setPanelEnabled(miVista.getPanelOpciones(), true);
            
        }else{
            
            miModelo.setPower(false);
            setPanelEnabled(miVista.getPanelDias(), false);
            setPanelEnabled(miVista.getPanelMedio(), false);
            miVista.getToggleButtonAuto().setEnabled(false);
            miVista.getToggleButtonManual().setEnabled(false);
            miVista.getToggleButtonEdit().setEnabled(false);
        }
    }
    /**
     * Cambia de modo al modo Manual
     */
    public void modeManualSwitch(){
        
        if(!miModelo.getManual()){
            
            miModelo.setManual(true);
            miVista.getLabelHoras().setVisible(true);
            miVista.getSpinnerSelectHora().setVisible(true);
            miVista.getButtonIniciar().setVisible(true);
        }else{
            miModelo.setManual(false);
            miVista.getLabelHoras().setVisible(false);
            miVista.getSpinnerSelectHora().setVisible(false);
            miVista.getButtonIniciar().setVisible(false);
        }
    }
}


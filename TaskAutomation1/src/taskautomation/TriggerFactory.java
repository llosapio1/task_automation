/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation;

import java.time.LocalTime;

/**
 *
 * @author alessandro
 */
// Questa classe non può implementare l'interfacci factory perché il metodo 
// create deve essere statico e un'interfaccia non può contenere metodi statici
public class TriggerFactory{

    public static Trigger create(String triggerType) {
        
        Trigger trigger = new BasicTrigger();
        
        if ("TimeOfDay".equals(triggerType)){
            
            // Bisogna capire come far inserire l'orario all'utente, per ora utilizza l'orario corrente
            LocalTime selectedTime = LocalTime.now();

            // Usa l'orario ottenuto per creare il TimeOfDayDecorator
            trigger = new TimeOfDayDecorator(trigger, selectedTime);

        }
        
        return trigger;
    }
    
    public int selected() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation;

/**
 *
 * @author alessandro
 */
public class TriggerFactory implements Factory{

    @Override
    public Trigger create(String triggerType) {
        
        Trigger triggerBase = new BasicTrigger();
        
        if (triggerType == "TimeOfDay"){
            
        }
        
        return triggerBase;
    }

    @Override
    public int selected() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

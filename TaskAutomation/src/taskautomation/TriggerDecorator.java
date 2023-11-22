/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation;

/**
 *
 * @author alessandro
 */
public abstract class TriggerDecorator implements Trigger {
    
    private Trigger trigger;
    
    
    @Override
    public boolean verifyTrigger() {
        return trigger.verifyTrigger();
    }
    
}

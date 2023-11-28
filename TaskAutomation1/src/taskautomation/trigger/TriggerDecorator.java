/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.trigger;

/**
 *
 * @author alessandro
 */
public abstract class TriggerDecorator implements Trigger {
    
    private Trigger decoratedTrigger;

    public TriggerDecorator(Trigger decoratedTrigger) {
        this.decoratedTrigger = decoratedTrigger;
    }

    @Override
    public boolean verifyTrigger() {
        return decoratedTrigger.verifyTrigger();
    }
    
    @Override
    public String toString() {
        return "";
    }
    
}

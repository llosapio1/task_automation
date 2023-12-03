/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.trigger;

import java.io.Serializable;

/**
 *
 * @author alessandro
 */
public abstract class TriggerDecorator implements Trigger, Serializable {
    
    private Trigger decoratedTrigger;
    
    public TriggerDecorator() {
    }

    public TriggerDecorator(Trigger decoratedTrigger) {
        this.decoratedTrigger = decoratedTrigger;
    }

    @Override
    public boolean verifyTrigger() {
        return decoratedTrigger.verifyTrigger();
    }
    
    @Override
    public String toString() {
        return "" + decoratedTrigger.toString();
    }
    
}

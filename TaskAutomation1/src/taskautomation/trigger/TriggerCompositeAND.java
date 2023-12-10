/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.trigger;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author alessandro
 */
public class TriggerCompositeAND implements TriggerComposite, Serializable {
    private ArrayList<Trigger> triggers;

    public TriggerCompositeAND() {
        this.triggers = new ArrayList<>(2);
    }
    
    @Override
    public void add(Trigger trigger) {
        triggers.add(trigger); 
    }

    @Override
    public void Remove(Trigger trigger) {
        triggers.remove(trigger);
       
    }
    @Override
    public Trigger getChildren(int index) {
        return triggers.get(index);
    }

    
    @Override
    public boolean verifyTrigger() {
        boolean condizione = true;
        for (Trigger trigger : triggers){
            condizione = condizione && trigger.verifyTrigger();
        }
        return condizione;
    }
    
    @Override
    public String toString() {
        return triggers.get(0).toString() +" AND " + triggers.get(1).toString() + "\n";
    }
}

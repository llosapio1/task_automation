/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.trigger;

import java.io.Serializable;

/**
 *
 * @author Alejandro
 */
public class TriggerCompositeNOT implements TriggerComposite, Serializable {
    private Trigger notTrigger;

    
    public TriggerCompositeNOT() {
    }

    @Override
    public boolean verifyTrigger() {
        return !notTrigger.verifyTrigger();
    }

    @Override
    public void add(Trigger trigger) {
        notTrigger = trigger;
    }

    @Override
    public void Remove(Trigger trigger) {
        notTrigger = null;
    }

    @Override
    public Trigger getChildren(int index) {
        return notTrigger;
    }
    
    @Override
    public String toString() {
        return "NOT(" + notTrigger.toString() + ")";
    }
}
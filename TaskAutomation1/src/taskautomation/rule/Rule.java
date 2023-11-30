/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.rule;

import java.io.Serializable;
import taskautomation.azioni.ActionFactory;
import taskautomation.trigger.TriggerFactory;
import taskautomation.trigger.Trigger;
import taskautomation.azioni.Action;

/**
 *
 * @author alessandro
 */
public class Rule implements Serializable{
    
    private String name;
    private Trigger trigger;
    private Action action;
    private boolean active;
    private boolean firedOnlyOnce;
    private boolean alreadyFired;
    
    public Rule(String name, String triggerType, String actionType, boolean active, boolean firedOnlyOnce) {
        this.name = name;
        this.trigger = TriggerFactory.create(triggerType);
        //this.action = ActionFactory.create(actionType);
        this.active = active;
        this.firedOnlyOnce = firedOnlyOnce;
        this.alreadyFired = false;
        if (!RuleList.getRuleList().addRule(this)){
            // L'aggiunta della regola non è riuscita
            throw new IllegalStateException("Impossibile aggiungere la regola alla lista.");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Trigger getTrigger() {
        return trigger;
    }

    public void setTrigger(Trigger trigger) {
        this.trigger = trigger;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public boolean isFiredOnlyOnce() {
        return firedOnlyOnce;
    }

    public void setFiredOnlyOnce(boolean firedOnlyOnce) {
        this.firedOnlyOnce = firedOnlyOnce;
    }
    
    public void checkRule(){
        if (this.active && ((this.firedOnlyOnce && !this.alreadyFired) || (!this.firedOnlyOnce))){
            if (this.trigger.verifyTrigger()){
                this.action.executeAction();
                if (this.firedOnlyOnce)
                    this.alreadyFired = true;
            }
        }
    }
    
    public void toggleActive(){
        this.active = !this.active;
    }
    
    public String getActive() {
        if(this.isActive())
            return "Enable";
        else
            return "Disable";
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
     
}

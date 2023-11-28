/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.rule;

import taskautomation.azioni.ActionFactory;
import taskautomation.trigger.TriggerFactory;
import taskautomation.trigger.Trigger;
import taskautomation.azioni.Action;

/**
 *
 * @author alessandro
 */
public class Rule {
    
    private String name;
    private Trigger trigger;
    private Action action;
    private boolean active;
    
    // Costruttore che imposta active a true per impostazione predefinita
    public Rule(String name, String triggerType, String actionType) {
        this(name, triggerType, actionType, true);
    }
    
    public Rule(String name, String triggerType, String actionType, boolean active) {
        this.name = name;
        this.trigger = TriggerFactory.create(triggerType);
        this.action = ActionFactory.create(actionType);
        this.active = active;
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
    
    public void checkRule(){
        if (this.active){
            if (this.trigger.verifyTrigger()){
            this.action.executeAction();
            }
        }
    }
    
    public void toggleActive(){
        this.active = !this.active;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
     
}

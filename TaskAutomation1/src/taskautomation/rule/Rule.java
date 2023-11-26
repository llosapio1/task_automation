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

    public Rule(String name, String triggerType, String actionType) {
        this.name = name;
        this.trigger = TriggerFactory.create(triggerType);
        this.action = ActionFactory.create(actionType);
        if (!RuleList.addRule(this)){
            // L'aggiunta della regola non è riuscita
            throw new IllegalStateException("Impossibile aggiungere la regola alla lista.");
        }

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
        if (this.trigger.verifyTrigger()){
            this.action.executeAction();
        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.rule;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.temporal.TemporalAmount;
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
    private boolean fireOnlyOnce;
    private boolean alreadyFired; 
    private TemporalAmount sleepingPeriod;
    private LocalTime lastFired; 
    
    // Costruttore con fireOnlyOnce
    public Rule(String name, Trigger trigger, Action action, boolean active, boolean fireOnlyOnce) {
        this(name, trigger, action, active, fireOnlyOnce, null);
    }
    
    // Costruttore con sleepingPeriod
    public Rule(String name, Trigger trigger, Action action, boolean active, TemporalAmount sleepingPeriod) {
        this(name, trigger, action, active, false, sleepingPeriod);
    }
    
    //Costruttore con tutti i parametri
    public Rule(String name, Trigger trigger, Action action, boolean active, boolean fireOnlyOnce, TemporalAmount sleepingPeriod) {
        this.name = name;
        this.trigger = trigger;
        this.action = action;
        this.active = active;
        this.fireOnlyOnce = fireOnlyOnce;
        this.alreadyFired = false;
        this.lastFired = null;
        this.sleepingPeriod = sleepingPeriod;
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
        return fireOnlyOnce;
    }

    public void setFiredOnlyOnce(boolean firedOnlyOnce) {
        this.fireOnlyOnce = firedOnlyOnce;
    }
    
    public void checkRule() {
        if (this.active && !alreadyFired && this.fireOnlyOnce) {
            if (this.trigger.verifyTrigger()) {
                this.action.executeAction();
                this.lastFired = LocalTime.now();
                this.alreadyFired = true;
            }
        } else if (this.active && !this.fireOnlyOnce) {
            if (alreadyFired) {
                if ((LocalTime.now().isAfter(this.lastFired.plus(sleepingPeriod)) && this.trigger.verifyTrigger())) {
                    this.action.executeAction();
                    this.lastFired = LocalTime.now();
                }
            } else {
                if (this.trigger.verifyTrigger()) {
                    this.action.executeAction();
                    this.lastFired = LocalTime.now();
                    this.alreadyFired = true;
                }
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

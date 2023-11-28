/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.azioni;

/**
 *
 * @author Alejandro
 */
public abstract class ActionDecorator implements Action{
    private Action decoratedAction;
    
    protected ActionDecorator(Action BasicAction) {
        this.decoratedAction=BasicAction;
    }
    
    @Override
    public void executeAction(){
        decoratedAction.executeAction();
    }
    
    @Override
    public String toString() {
        return "";
    }
    
}

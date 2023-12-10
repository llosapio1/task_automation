/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.trigger;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.scene.control.TextInputDialog;
import taskautomation.counter.Counter;
import taskautomation.counter.CounterList;

/**
 *
 * @author Leonardo
 */
public class CounterIsGreaterThanValueDecorator extends TriggerDecorator implements Serializable{
    String counterName;
    int value;
    
    public CounterIsGreaterThanValueDecorator(String counterName, int value, Trigger decoratedTrigger){
        super(decoratedTrigger);
        this.counterName = counterName;
        this.value = value;
    }
    public CounterIsGreaterThanValueDecorator(Trigger decoratedTrigger){
        super(decoratedTrigger);
        TextInputDialog dialog = new TextInputDialog("type the name of the counter");
        dialog.setHeaderText(null);
        dialog.setTitle("check if counter is greater than given value");
        dialog.setContentText("name of the counter");
        this.counterName = dialog.showAndWait().orElse("");
        
        TextInputDialog dialog2 = new TextInputDialog("type the value to check against");
        dialog2.setHeaderText(null);
        dialog2.setTitle("check if counter is greater than given value");
        dialog2.setContentText("value to check");
        this.value = Integer.parseInt(dialog2.showAndWait().orElse(""));
    }
    
    @Override
    public boolean verifyTrigger(){
        Counter counter = null;
         ArrayList<Counter> list = CounterList.getCounterList().get();
         for (Counter c : list){
             if (c.getName() == this.counterName){
                 counter = c;
                 break;
             }
         }
         return (counter.getValue() > this.value);
      
    }
    
    @Override
    public String toString(){
        return "Counter: " + this.counterName + "value is greater than: " + this.value + "\n"+super.toString();
    }
}

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
public class CounterIsLessThanCounterDecorator extends TriggerDecorator implements Serializable{
    
   String counterName1;
    String counterName2;
    
    public CounterIsLessThanCounterDecorator(String counterName1, String counterName2, Trigger decoratedTrigger){
        super(decoratedTrigger);
        this.counterName1 = counterName1;
        this.counterName2 = counterName2;
    }
    
    public CounterIsLessThanCounterDecorator(Trigger decoratedTrigger){
        super(decoratedTrigger);
        TextInputDialog dialog = new TextInputDialog("type the name of the first counter");
        dialog.setHeaderText(null);
        dialog.setTitle("check if counter is less than counter");
        dialog.setContentText("name of the first counter");
        this.counterName1 = dialog.showAndWait().orElse("");
        
        TextInputDialog dialog2 = new TextInputDialog("type the name of the second counter");
        dialog2.setHeaderText(null);
        dialog2.setTitle("check if counter is less than counter");
        dialog2.setContentText("name of the second counter");
        this.counterName2 = dialog2.showAndWait().orElse("");
    }
    
    @Override
    public boolean verifyTrigger(){
        Counter counter1 = null;
        Counter counter2 = null;
         ArrayList<Counter> list = CounterList.getCounterList().get();
         boolean found1 = false;
         boolean found2 = false;
         for (Counter c : list){
             if (c.getName() == this.counterName1){
                 counter1 = c;
                 found1 = true;
             }
             if(c.getName() == this.counterName2){
                 counter2 = c;
                 found2 = true;
             }
             if(found1 && found2){
                 break;
             }
         }
         return (counter1.getValue() < counter2.getValue());
      
    }
    
    @Override
    public String toString(){
        return "Counter: " + this.counterName1 + "value is less than: " + this.counterName2 + "\n"+super.toString();
    } 
}

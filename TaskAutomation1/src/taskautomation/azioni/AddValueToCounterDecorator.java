/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.azioni;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.scene.control.TextInputDialog;
import taskautomation.counter.Counter;
import taskautomation.counter.CounterList;

/**
 *
 * @author Leonardo
 */
public class AddValueToCounterDecorator extends ActionDecorator implements Serializable{
   String counterName;
   int value;
   
    public AddValueToCounterDecorator(Action basicAction){
        super(basicAction);
         TextInputDialog dialog = new TextInputDialog("Type the name of the counter.");
        dialog.setHeaderText(null);
        dialog.setTitle("add value to counter");
        dialog.setContentText("Type the counter to use:");
        this.counterName = dialog.showAndWait().orElse("");
        
        TextInputDialog dialog2 = new TextInputDialog("Type the value to add (int)");
        dialog.setHeaderText(null);
        dialog.setTitle("add value to counter");
        dialog.setContentText("Type the value to add (int)");
        this.value = Integer.parseInt(dialog.showAndWait().orElse(""));
        
    }
    public AddValueToCounterDecorator(String counterName, int value, Action basicAction){
        super(basicAction);
        this.counterName = counterName;
        this.value = value;
    }
     @Override
     public void executeAction(){
         Counter counter = null;
         ArrayList<Counter> list = CounterList.getCounterList().get();
         for (Counter c : list){
             if (c.getName() == this.counterName){
                 counter = c;
                 break;
             }
         }
         
         CounterList.getCounterList().updateCounter(counter, counter.getValue()+value);
         
     }
     
     @Override
     public String toString(){
         return "Add value: " + value + " to counter: " + counterName + "\n" + super.toString();
     }
    
    
}

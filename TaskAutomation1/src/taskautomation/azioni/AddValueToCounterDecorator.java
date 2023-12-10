/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.azioni;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.scene.control.TextInputDialog;
import taskautomation.CountersTableObserver;
import taskautomation.TaskAutomation;
import taskautomation.counter.Counter;
import taskautomation.counter.CounterList;

/**
 *
 * @author Leonardo
 */
public class AddValueToCounterDecorator extends ActionDecorator implements Serializable{
   String counterName;
   int value;
   
   //constructor used in application
    public AddValueToCounterDecorator(Action basicAction){
        super(basicAction);
        //get name of the counter to use through user input
         TextInputDialog dialog = new TextInputDialog("Type the name of the counter.");
        dialog.setHeaderText(null);
        dialog.setTitle("add value to counter");
        dialog.setContentText("Type the counter to use:");
        this.counterName = dialog.showAndWait().orElse("");
        
        //get value to add to counter through user input
        TextInputDialog dialog2 = new TextInputDialog("Type the value to add (int)");
        dialog2.setHeaderText(null);
        dialog2.setTitle("add value to counter");
        dialog2.setContentText("Type the value to add (int)");
        this.value = Integer.parseInt(dialog2.showAndWait().orElse("0"));
         
    }
    
    //constructor used in test class
    public AddValueToCounterDecorator(String counterName, int value, Action basicAction){
        super(basicAction);
        this.counterName = counterName;
        this.value = value;
    }
    
    
     @Override
     public void executeAction(){
         Counter counter = null;
         ArrayList<Counter> list = CounterList.getCounterList().get();
         
         //find counter in counter list
         for (Counter c : list){
             if (c.getName().equals(this.counterName)){
                 counter = c;
                 break;
             }
         }
         
         if (counter!=null){
         //update counter's value with sum of counter's old value + number chosen by user
         CounterList.getCounterList().updateCounter(counter, counter.getValue()+value);
         // Aggiorna la tabella nel controller utilizzando l'evento
         TaskAutomation.updateCountersTable();
         }
     }
     
     @Override
     public String toString(){
         return "Add value: " + value + " to counter: " + counterName + "\n" + super.toString();
     }
    
    
}

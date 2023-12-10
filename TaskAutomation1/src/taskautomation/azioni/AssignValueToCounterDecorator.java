/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.azioni;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.scene.control.TextInputDialog;
import taskautomation.TaskAutomation;
import taskautomation.counter.Counter;
import taskautomation.counter.CounterList;

/**
 *
 * @author Leonardo
 */
public class AssignValueToCounterDecorator extends ActionDecorator implements Serializable{
    
    private String counterName;
    private int value;
    
    //constructor used in test class
     public AssignValueToCounterDecorator(String counterName, int value,Action basicAction) {
        super(basicAction);
        this.counterName = counterName;
        this.value = value;
    }
     
     //constructor used in application
     public AssignValueToCounterDecorator(Action basicAction){
         super(basicAction);
         
         //get name of the counter to use through user input
         TextInputDialog dialog = new TextInputDialog("Type the name of the counter.");
        dialog.setHeaderText(null);
        dialog.setTitle("Assign value to counter");
        dialog.setContentText("Type the counter to use:");
        this.counterName = dialog.showAndWait().orElse("");
        
        //get value to assign to counter through user input
        TextInputDialog dialog2 = new TextInputDialog("Type the value to assign (int)");
        dialog2.setHeaderText(null);
        dialog2.setTitle("assign value to counter");
        dialog2.setContentText("Type the value to assign (int)");
        this.value = Integer.parseInt(dialog2.showAndWait().orElse("0"));
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
         //update counter's value with number chosen by user
         CounterList.getCounterList().updateCounter(counter, value);
         // Aggiorna la tabella nel controller utilizzando l'evento
         TaskAutomation.updateCountersTable();
         }
     }
     
     @Override
     public String toString(){
         return "Assign value: " + value + " to counter: " + counterName + "\n" + super.toString();
     }
    
}

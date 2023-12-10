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
public class AddCounterToCounterDecorator extends ActionDecorator implements Serializable{
    private String counterName1;
    private String counterName2;
    
    //constructor used in test class
    public AddCounterToCounterDecorator(String counterName1, String counterName2, Action basicAction){
        super(basicAction);
        this.counterName1 = counterName1;
        this.counterName2 = counterName2;
        
    }
    
    //constructor used in application
    public AddCounterToCounterDecorator(Action basicAction){
        super(basicAction);
        
        //get name of first counter from user input
         TextInputDialog dialog = new TextInputDialog("Type the name of the first counter.");
        dialog.setHeaderText(null);
        dialog.setTitle("add counter to counter");
        dialog.setContentText("Type the counter to add");
        this.counterName1 = dialog.showAndWait().orElse("");
        
        
        //get name of second counter from user input
        TextInputDialog dialog2 = new TextInputDialog("Type the name of the second counter");
        dialog2.setHeaderText(null);
        dialog2.setTitle("add counter to counter");
        dialog2.setContentText("Type the counter to add to");
        this.counterName2 = dialog2.showAndWait().orElse("");
        
    }
    
     @Override
     public void executeAction(){
         Counter counter1 = null;
         Counter counter2 = null;
         
         //use these to check if counters have been found in counter list
        boolean found1 = false;
        boolean found2 = false;
        
         ArrayList<Counter> list = CounterList.getCounterList().get();
         for (Counter c : list){
            
             //found counter1
             if (c.getName().equals(this.counterName1)){
                 counter1 = c;
                 found1= true;
             }  
             
             //found counter2
             if(c.getName().equals(this.counterName2)){
                 counter2 = c;
                 found2= true;
             }
             
             //exit when counter1 and counter2 have both been found
             if(found1 && found2){
                 break;
             }
         }
         if (counter1!=null && counter2!=null){
         //update counter2's value with sum of counter2's old value + counter1's value
         CounterList.getCounterList().updateCounter(counter2, counter2.getValue()+counter1.getValue());
         // Aggiorna la tabella nel controller utilizzando l'evento
        TaskAutomation.updateCountersTable();
         }
     }
     
     @Override
     public String toString(){
         return "Add value of counter: " + counterName1 + " to counter: " + counterName2 + "\n" + super.toString();
     }
    
}

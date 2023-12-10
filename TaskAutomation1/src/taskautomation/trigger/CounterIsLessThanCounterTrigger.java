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
public class CounterIsLessThanCounterTrigger implements Trigger, Serializable{
    
    private String counterName1;
    private String counterName2;
    
    //constructor used in test class
    public CounterIsLessThanCounterTrigger(String counterName1, String counterName2){
        this.counterName1 = counterName1;
        this.counterName2 = counterName2;
    }
    
    //constructor used in application
    public CounterIsLessThanCounterTrigger(){

        
        //get name of the first counter from user input
        TextInputDialog dialog = new TextInputDialog("type the name of the first counter");
        dialog.setHeaderText(null);
        dialog.setTitle("check if counter is less than counter");
        dialog.setContentText("name of the first counter");
        this.counterName1 = dialog.showAndWait().orElse("");
        
        //get name of the second counter from user input
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
         
         //used these to check when both counters have been found
         boolean found1 = false;
         boolean found2 = false;
         
         for (Counter c : list){
             
             //counter1 has been found
             if (c.getName().equals(this.counterName1)){
                 counter1 = c;
                 found1 = true;
             }
             
             //counter2 has been found
             if(c.getName().equals(this.counterName2)){
                 counter2 = c;
                 found2 = true;
             }
             
             //if both counters have been found, exit for
             if(found1 && found2){
                 break;
             }
         }
         
         if (counter1!=null && counter2!=null){
         //check if counter1's value is less than counter2's value
         return (counter1.getValue() < counter2.getValue());
         }else return false;
    }
    
    @Override
    public String toString(){
        return "Counter: " + this.counterName1 + " 's value is less than: " + this.counterName2;
    } 
}

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
public class CounterIsGreaterThanValueTrigger implements Trigger, Serializable{
    private String counterName;
    private int value;
    
    //constructor used in test class
    public CounterIsGreaterThanValueTrigger(String counterName, int value){
        this.counterName = counterName;
        this.value = value;
    }
    
    //constructor used in application
    public CounterIsGreaterThanValueTrigger(){
        
        //get name of the counter from user input
        TextInputDialog dialog = new TextInputDialog("type the name of the counter");
        dialog.setHeaderText(null);
        dialog.setTitle("check if counter is greater than given value");
        dialog.setContentText("name of the counter");
        this.counterName = dialog.showAndWait().orElse("");
        
        
        //get value to check against from user input
        TextInputDialog dialog2 = new TextInputDialog("type the value to check against");
        dialog2.setHeaderText(null);
        dialog2.setTitle("check if counter is greater than given value");
        dialog2.setContentText("value to check");
        this.value = Integer.parseInt(dialog2.showAndWait().orElse("0"));
    }
    
    @Override
    public boolean verifyTrigger(){
        Counter counter = null;
         ArrayList<Counter> list = CounterList.getCounterList().get();
         
         //look for counter in counter list
         for (Counter c : list){
             if (c.getName().equals(this.counterName)){
                 counter = c;
                 break;
             }
         }
         
         if(counter!=null){
         //check if counter's value is greater than number chosen by user
         return (counter.getValue() > this.value);
         }else return false;
      
    }
    
    @Override
    public String toString(){
        return "Counter: " + this.counterName + " 's value is greater than: " + this.value;
    }
}

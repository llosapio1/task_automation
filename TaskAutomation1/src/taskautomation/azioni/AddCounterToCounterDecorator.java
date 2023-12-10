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
public class AddCounterToCounterDecorator extends ActionDecorator implements Serializable{
    String counterName1;
    String counterName2;
    public AddCounterToCounterDecorator(String counterName1, String counterName2, Action basicAction){
        super(basicAction);
        this.counterName1 = counterName1;
        this.counterName2 = counterName2;
        
    }
    public AddCounterToCounterDecorator(Action basicAction){
        super(basicAction);
         TextInputDialog dialog = new TextInputDialog("Type the name of the first counter.");
        dialog.setHeaderText(null);
        dialog.setTitle("add counter to counter");
        dialog.setContentText("Type the counter to add");
        this.counterName1 = dialog.showAndWait().orElse("");
        
        TextInputDialog dialog2 = new TextInputDialog("Type the name of the second counter");
        dialog.setHeaderText(null);
        dialog.setTitle("add counter to counter");
        dialog.setContentText("Type the counter to add to");
        this.counterName2 = dialog.showAndWait().orElse("");
        
    }
    
     @Override
     public void executeAction(){
         Counter counter1 = null;
         Counter counter2 = null;
        boolean found1 = false;
        boolean found2 = false;
        
         ArrayList<Counter> list = CounterList.getCounterList().get();
         for (Counter c : list){
            
             if (c.getName() == this.counterName1){
                 counter1 = c;
                 found1= true;
             }  
             if(c.getName() == this.counterName2){
                 counter2 = c;
                 found2= true;
             }
             if(found1 && found2){
                 break;
             }
         }

         CounterList.getCounterList().updateCounter(counter2, counter2.getValue()+counter1.getValue());
         
     }
     
     @Override
     public String toString(){
         return "Add value of counter: " + counterName1 + " to counter: " + counterName2 + "\n" + super.toString();
     }
    
}

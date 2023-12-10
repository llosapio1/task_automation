/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.trigger;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TextInputDialog;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Leonardo
 */
public class ReturnCodeIsEqualDecorator extends TriggerDecorator implements Serializable{
    
    File program;
    String arguments;
    int value;
    
    //constructor used in application
    public ReturnCodeIsEqualDecorator(Trigger decoratedTrigger){
        super(decoratedTrigger);
        //get user to select external program to execute
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Select program to execute");
        this.program = chooser.showOpenDialog(new Stage());
        
        //get arguments to run program with from user input
        TextInputDialog dialog = new TextInputDialog("arguments to execute the program with");
        dialog.setHeaderText(null);
        dialog.setTitle("program is executed with given arguments");
        dialog.setContentText("arguments");
        this.arguments =dialog.showAndWait().orElse("");
        
        //get value to compare external program's return code with
        TextInputDialog dialog2 = new TextInputDialog("value to compare return code to");
        dialog.setHeaderText(null);
        dialog.setTitle("return code is equal to given value");
        dialog.setContentText("type the value to check against");
        this.value = Integer.parseInt(dialog.showAndWait().orElse("0"));
        
    }
    
    //constructor used in test class
    public ReturnCodeIsEqualDecorator(File program, String arguments, int value, Trigger decoratedTrigger){
        super(decoratedTrigger);
        this.program = program;
        this.arguments = arguments;
        this.value = value;
        
    }
    
    @Override
    public boolean verifyTrigger(){
        
        //create process to execute external program with arguments
        ProcessBuilder pb = new ProcessBuilder(program.getAbsolutePath(), arguments);
        Process p;  
        try {
            p = pb.start(); //start external program's execution
            int exitCode = p.waitFor();  // wait for process to finish execution
           
            return this.value == exitCode;  //get exit code and compare it to value given by user
            
        } catch (IOException ex) {
            Logger.getLogger(ReturnCodeIsEqualDecorator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ReturnCodeIsEqualDecorator.class.getName()).log(Level.SEVERE, null, ex);
        }
     
       return false; 
    }
    
    @Override
    public String toString(){
        return "Program " + "\"" +program.toString() + "\"" + " executed with arguments " + "\"" +arguments+ "\""+ " return code is equal to: " + value +"\n"+ super.toString();
    }
    
}

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
    
    public ReturnCodeIsEqualDecorator(Trigger decoratedTrigger){
        super(decoratedTrigger);
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Select program to execute");
        this.program = chooser.showOpenDialog(new Stage());
        TextInputDialog dialog = new TextInputDialog("arguments to execute the program with");
        dialog.setHeaderText(null);
        dialog.setTitle("program is executed with given arguments");
        dialog.setContentText("arguments");
        this.arguments =dialog.showAndWait().orElse("");
        TextInputDialog dialog2 = new TextInputDialog("value to compare return code to");
        dialog.setHeaderText(null);
        dialog.setTitle("return code is equal to given value");
        dialog.setContentText("type the value to check against");
        this.value = Integer.parseInt(dialog.showAndWait().orElse(""));
        
    }
    public ReturnCodeIsEqualDecorator(File program, String arguments, int value, Trigger decoratedTrigger){
        super(decoratedTrigger);
        this.program = program;
        this.arguments = arguments;
        this.value = value;
        
    }
    
    @Override
    public boolean verifyTrigger(){
        ProcessBuilder pb = new ProcessBuilder(program.getAbsolutePath(), arguments);
        Process p;  
        try {
            p = pb.start();
            int exitCode = p.waitFor();  // wait for process to finish then continue.
           
            return this.value == exitCode;
            
        } catch (IOException ex) {
            Logger.getLogger(ReturnCodeIsEqualDecorator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ReturnCodeIsEqualDecorator.class.getName()).log(Level.SEVERE, null, ex);
        }
     
       return false; 
    }
    
    @Override
    public String toString(){
        return "Program " + "\"" +program.toString() + "\"" + " executed with arguments " + "\"" +arguments+ "\""+ " return code checked against: " + value +"\n"+ super.toString();
    }
    
}

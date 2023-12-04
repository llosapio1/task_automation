/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.azioni;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Leonardo
 */
public class ExecuteProgramDecorator extends ActionDecorator implements Serializable{
    
    File program;
    String arguments;
    
    //constructor used in test class
    public ExecuteProgramDecorator (File program, String arguments, Action basicAction){
        super(basicAction);
        this.program = program;
        this.arguments = arguments;
    }
    
    //constructor used in application
    public ExecuteProgramDecorator(Action basicAction){
        super(basicAction);
        //get exe file to execute   
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select program to execute");
            
        //allow the selection of exe files only
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Executable files (*.exe)", "*.exe");
        fileChooser.getExtensionFilters().add(filter);

        this.program = fileChooser.showOpenDialog(new Stage());
           
        //get arguments to use to execute external program
        this.arguments = javax.swing.JOptionPane.showInputDialog("Type the arguments to use.");
        
    }
    
    @Override
    public void executeAction(){
       
        //execute selected program with selected arguments
        Runtime r = Runtime.getRuntime();
        try {
            r.exec(program.getAbsolutePath() +" "+arguments);
        } catch (IOException ex) {
            Logger.getLogger(ExecuteProgramDecorator.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        
    }
     @Override
    public String toString(){
         return "Execute program: " + program.toString() + " with arguments: " + arguments + " ";
    }
    
}

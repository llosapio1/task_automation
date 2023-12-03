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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

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
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("select program to execute");
            
            //allow the selection of exe files only
           FileNameExtensionFilter filter = new FileNameExtensionFilter("(*.exe)", "exe");
           fileChooser.setFileFilter(filter);
           
            int res = fileChooser.showOpenDialog(null);
           if(res == JFileChooser.APPROVE_OPTION){
               this.program = fileChooser.getSelectedFile();  
           }
           
           //get arguments to use to execute external program
            this.arguments = JOptionPane.showInputDialog("Type the arguments to use.");
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

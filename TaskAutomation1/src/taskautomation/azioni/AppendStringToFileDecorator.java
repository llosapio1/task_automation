/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.azioni;

import java.io.File;
import java.io.FileWriter;
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
public class AppendStringToFileDecorator extends ActionDecorator implements Serializable{
    private File file;
    private String string;
   
    //constructor used in test class
    public AppendStringToFileDecorator(File file, String string, Action basicAction) {
        super(basicAction);
        this.file = file;
        this.string = string;
        
    }
    
    //constructor used in application
    public AppendStringToFileDecorator(Action basicAction){
       super(basicAction);
       //get string to append
       this.string = JOptionPane.showInputDialog("Type the string to append.");
       
       //get txt file to append string to
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("select file to append string to");
            
            //allow the selection of txt files only
           FileNameExtensionFilter filter = new FileNameExtensionFilter("text files(*.txt)", "txt");
           fileChooser.setFileFilter(filter);
           
            int res = fileChooser.showOpenDialog(null);
           if(res == JFileChooser.APPROVE_OPTION){
               this.file = fileChooser.getSelectedFile();
              
           }
    }
    
    @Override
    public void executeAction(){
       //append string to file
        try (FileWriter fr = new FileWriter(file.getAbsolutePath(), true)) {
            fr.write(string);
            fr.close();
        } catch (IOException ex) {
            Logger.getLogger(AppendStringToFileDecorator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @Override
    public String toString(){
        return "Append string: " + string + " to file: " + file.toString() + "\n" + super.toString();
    }
}

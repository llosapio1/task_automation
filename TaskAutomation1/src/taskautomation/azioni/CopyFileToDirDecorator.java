/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.azioni;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author Leonardo
 */
public class CopyFileToDirDecorator extends ActionDecorator implements Serializable{
   File selectedFile;
   
   File destinationDir;
   
   //constructor used in test class
    public CopyFileToDirDecorator(File selectedFile, File destinationDir, Action basicAction) {
        super(basicAction);
        this.selectedFile = selectedFile;
        this.destinationDir = destinationDir;
    }
    
    //constructor used in application
    public CopyFileToDirDecorator(Action basicAction){
        super(basicAction);
        
        //get file to copy
            JFileChooser fileChooser1 = new JFileChooser();
            fileChooser1.setDialogTitle("choose file to copy");
            int res1 = fileChooser1.showOpenDialog(null);
            
            //get destination folder to copy the file into
            JFileChooser fileChooser2 = new JFileChooser();
            fileChooser2.setDialogTitle("choose destination folder");
            
            //allow only the selection of directories
            fileChooser2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            
            int res2= fileChooser2.showOpenDialog(null);
            
           if(res1 == JFileChooser.APPROVE_OPTION && res2 == JFileChooser.APPROVE_OPTION){
               this.selectedFile = fileChooser1.getSelectedFile();  
               this.destinationDir = fileChooser2.getSelectedFile();
               
           } 
    }
    
    @Override
    public void executeAction(){
        //copy selected file to selected destination directory
       try {
           Files.copy(selectedFile.toPath(),
                   (new File(destinationDir.toPath() + File.separator+ selectedFile.getName())).toPath(),
                   StandardCopyOption.REPLACE_EXISTING);
       } catch (IOException ex) {
           Logger.getLogger(CopyFileToDirDecorator.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    @Override
    public String toString(){
        return "Copy file: " + selectedFile.toString() + " to directory: " + destinationDir.toString() + " ";
    }
    
}

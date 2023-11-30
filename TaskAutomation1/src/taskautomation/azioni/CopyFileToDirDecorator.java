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

/**
 *
 * @author Leonardo
 */
public class CopyFileToDirDecorator extends ActionDecorator implements Serializable{
   File selectedFile;
   
   File destinationDir;
   
    public CopyFileToDirDecorator(File selectedFile, File destinationDir, Action BasicAction) {
        super(BasicAction);
        this.selectedFile = selectedFile;
        
        this.destinationDir = destinationDir;
    }
    
    @Override
    public void executeAction(){
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

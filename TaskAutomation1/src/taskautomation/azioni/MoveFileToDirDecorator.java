/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.azioni;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leonardo
 */
public class MoveFileToDirDecorator extends ActionDecorator implements Serializable{
    
    File selectedFile;
    String destDirPath;
    File destDir;
    
    public MoveFileToDirDecorator(File selectedFile, File destinationDir, Action BasicAction) {
        super(BasicAction);
       
        this.selectedFile = selectedFile;
        this.destDir = destinationDir;
        destDirPath = destinationDir.getAbsolutePath();
    }
    
    @Override
    public void executeAction(){
        if(selectedFile.exists()){
       try {
           Files.move(selectedFile.toPath(),
                   Paths.get(destDirPath + File.separator+selectedFile.getName()));
       } catch (IOException ex) {
           Logger.getLogger(MoveFileToDirDecorator.class.getName()).log(Level.SEVERE, null, ex);
       }
        }
    }
    @Override
    public String toString(){
        return "Move file: " + selectedFile.toString() + " to directory: " + destDir.toString() + " ";
    }
}

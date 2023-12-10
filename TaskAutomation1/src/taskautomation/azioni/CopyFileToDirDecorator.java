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
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Leonardo
 */
public class CopyFileToDirDecorator extends ActionDecorator implements Serializable{
   
    private File selectedFile;
    private File destinationDir;
   
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
        FileChooser fileChooser1 = new FileChooser();
        fileChooser1.setTitle("Choose file to copy");
        this.selectedFile = fileChooser1.showOpenDialog(new Stage());
            
        //get destination folder to copy the file into
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Choose destination folder");
        this.destinationDir = directoryChooser.showDialog(new Stage());
    }
    
    @Override
    public void executeAction(){
        //copy selected file to selected destination directory
       try {
           Path destinationPath = new File(destinationDir, selectedFile.getName()).toPath();
           Files.copy(selectedFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
       } catch (IOException ex) {
           Logger.getLogger(CopyFileToDirDecorator.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    @Override
    public String toString(){
        return "Copy file: " + selectedFile.toString() + " to directory: " + destinationDir.toString() + "\n" + super.toString();
    }
    
}

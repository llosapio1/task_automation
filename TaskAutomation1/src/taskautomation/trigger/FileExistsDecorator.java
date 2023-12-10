/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.trigger;

import java.io.File;
import java.io.Serializable;
import java.nio.file.Path;
import javafx.scene.control.TextInputDialog;
import javafx.stage.DirectoryChooser;

import javafx.stage.Stage;

/**
 *
 * @author Leonardo
 */
public class FileExistsDecorator extends TriggerDecorator implements Serializable{
    
    String fileName;
    File dir;
    
    //constructor used in test class
    FileExistsDecorator(String fileName, File dir, Trigger decoratedTrigger){
        super(decoratedTrigger);
        this.fileName = fileName;
        this.dir = dir;
    }
    
    //constructor used in application
    FileExistsDecorator(Trigger decoratedTrigger){
       super(decoratedTrigger); 
       
       //get name of the file from user input
        TextInputDialog dialog = new TextInputDialog("Type the name of the file");
        dialog.setHeaderText(null);
        dialog.setTitle("File exists in directory");
        dialog.setContentText("Type the file to find:");
        this.fileName = dialog.showAndWait().orElse("");
        
        //get user to select directory in which to check for file's existence
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Choose directory in which to check for file's exisistence");
        this.dir = directoryChooser.showDialog(new Stage());
    }
    
    
    
    @Override
    public boolean verifyTrigger(){
        
        //get complete file path from directory's path + file name
        Path filePath = dir.toPath().resolve(fileName);
        
        File file = new File(filePath.toString());
        return file.exists();
        
    }
    
    
    @Override
    public String toString(){
        return "File " + "\"" +fileName + "\"" + "exists in directory: " +"\""+ dir.toString() + "\"\n" + super.toString();
    }
    
}

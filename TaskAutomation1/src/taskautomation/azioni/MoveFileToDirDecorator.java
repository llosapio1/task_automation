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
public class MoveFileToDirDecorator extends ActionDecorator implements Serializable{
    
    private File selectedFile;
    private String destDirPath;
    private File destDir;
    
    
    //constructor used in test class
    public MoveFileToDirDecorator(File selectedFile, File destinationDir, Action basicAction) {
        super(basicAction);
       
        this.selectedFile = selectedFile;
        this.destDir = destinationDir;
        destDirPath = destinationDir.getAbsolutePath();
    }
    
    //constructor used in application
    public MoveFileToDirDecorator(Action basicAction){
        super(basicAction);
        
        //get file to move
        FileChooser fileChooser1 = new FileChooser();
        fileChooser1.setTitle("Choose file to move");
        this.selectedFile = fileChooser1.showOpenDialog(new Stage());
            
        // Get destination folder to move the selected file into
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Choose destination folder");
        this.destDir = directoryChooser.showDialog(new Stage());
               
    }
    
    @Override
    public void executeAction() {
        // If the selected file and destination directory are not null, move the file
        if (selectedFile != null && destDir != null) {
            try {
                Path destinationPath = destDir.toPath().resolve(selectedFile.getName());
                Files.move(selectedFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                Logger.getLogger(MoveFileToDirDecorator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        super.executeAction();
    }

    @Override
    public String toString(){
        return "Move file: " + "\"" + selectedFile.toString()+ "\"" + " to directory: " + "\"" +destDir.toString()+ "\"" + "\n" + super.toString();
    }
}

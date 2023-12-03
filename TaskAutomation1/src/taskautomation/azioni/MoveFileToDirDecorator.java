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
import javax.swing.JFileChooser;

/**
 *
 * @author Leonardo
 */
public class MoveFileToDirDecorator extends ActionDecorator implements Serializable{
    
    File selectedFile;
    String destDirPath;
    File destDir;
    
    public MoveFileToDirDecorator(File selectedFile, File destinationDir, Action basicAction) {
        super(basicAction);
       
        this.selectedFile = selectedFile;
        this.destDir = destinationDir;
        destDirPath = destinationDir.getAbsolutePath();
    }
    public MoveFileToDirDecorator(Action basicAction){
        super(basicAction);
        JFileChooser fileChooser1 = new JFileChooser();
            fileChooser1.setDialogTitle("choose file to move");
            int res1 = fileChooser1.showOpenDialog(null);
            
            
            JFileChooser fileChooser2 = new JFileChooser();
            fileChooser2.setDialogTitle("choose destination folder");
            fileChooser2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int res2= fileChooser2.showOpenDialog(null);
            
           if(res1 == JFileChooser.APPROVE_OPTION && res2 == JFileChooser.APPROVE_OPTION){
               this.selectedFile = fileChooser1.getSelectedFile();  
               this.destDir = fileChooser2.getSelectedFile();
               this.destDirPath = this.destDir.getAbsolutePath();
               
           } 
    }
    @Override
    public void executeAction(){
        System.out.println("inside execute move with file " + selectedFile.toString() + " and dir " + destDir.toString());
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
        return "Move file: " + "\"" + selectedFile.toString()+ "\"" + " to directory: " + "\"" +destDir.toString()+ "\"" + "\n" + super.toString();
    }
}

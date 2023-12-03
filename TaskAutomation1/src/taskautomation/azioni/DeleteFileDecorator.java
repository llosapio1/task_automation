/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.azioni;

import java.io.File;
import java.io.Serializable;
import javax.swing.JFileChooser;

/**
 *
 * @author Leonardo
 */
public class DeleteFileDecorator extends ActionDecorator implements Serializable{
    File selectedFile;
    
    //constructor used in test class
    public DeleteFileDecorator(File selectedFile, Action basicAction) {
        super(basicAction);
        this.selectedFile = selectedFile;
    }
    
    //constructor used in application
    public DeleteFileDecorator(Action BasicAction){
        super(BasicAction);
        
        //get file to delete
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("select file to delete");
           
        int res = fileChooser.showOpenDialog(null);
           if(res == JFileChooser.APPROVE_OPTION){
               this.selectedFile = fileChooser.getSelectedFile();
               
           }
    
    }
    
    @Override
    public void executeAction(){
       //delete selected file
        selectedFile.delete();
    }
     @Override
    public String toString(){
        return "Delete file: " + selectedFile.toString();
    }
}

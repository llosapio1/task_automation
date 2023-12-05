/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.trigger;

import java.io.File;
import java.io.Serializable;
import javafx.scene.control.TextInputDialog;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Leonardo
 */
public class FileSizeIsGreaterDecorator extends TriggerDecorator implements Serializable{
    
    File file;
    long size;
    
    public FileSizeIsGreaterDecorator(File file, long size, Trigger decoratedTrigger){
        super(decoratedTrigger);
        this.file = file;
        this.size = size;
    }
    public FileSizeIsGreaterDecorator(Trigger decoratedTrigger){
        super(decoratedTrigger);
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Select file to check size of");
        this.file = chooser.showOpenDialog(new Stage());
        TextInputDialog dialog = new TextInputDialog("value the size has to be greater then (kb)");
        dialog.setHeaderText(null);
        dialog.setTitle("File size is greater then given value");
        dialog.setContentText("type the value to check against (kb)");
        this.size = Long.parseLong(dialog.showAndWait().orElse(""));
        
    }
    
    @Override
    public boolean verifyTrigger(){
       long fileSize = file.length()/1024;
       
       return fileSize > size; 
        
    }
    
    
    @Override
    public String toString(){
        return "File " + "\"" +file.toString() + "\"" + "size is greater then " +size +"\n"+ super.toString();
    }
}

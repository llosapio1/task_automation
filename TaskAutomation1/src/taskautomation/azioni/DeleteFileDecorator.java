/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.azioni;

import java.io.File;
import java.io.Serializable;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Leonardo
 */
public class DeleteFileDecorator extends ActionDecorator implements Serializable{
    private File selectedFile;
    
    //constructor used in test class
    public DeleteFileDecorator(File selectedFile, Action basicAction) {
        super(basicAction);
        this.selectedFile = selectedFile;
    }
    
    //constructor used in application
    public DeleteFileDecorator(Action BasicAction){
        super(BasicAction);
        
        //get file to delete
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select file to delete");
        this.selectedFile = fileChooser.showOpenDialog(new Stage());
    
    }
    
    @Override
    public void executeAction(){
       //delete selected file
       if (selectedFile != null) {
            selectedFile.delete();
        }
    }
     @Override
    public String toString(){
        return "Delete file: " + selectedFile.toString() + "\n" + super.toString();
    }
}

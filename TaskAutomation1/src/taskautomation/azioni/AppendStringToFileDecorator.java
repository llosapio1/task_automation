/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.azioni;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TextInputDialog;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 *
 * @author Leonardo
 */
public class AppendStringToFileDecorator extends ActionDecorator implements Serializable{
    private File file;
    private String string;
   
    //constructor used in test class
    public AppendStringToFileDecorator(File file, String string, Action basicAction) {
        super(basicAction);
        this.file = file;
        this.string = string;
        
    }
    
    //constructor used in application
    public AppendStringToFileDecorator(Action basicAction){
        super(basicAction);
        //get string to append
        TextInputDialog dialog = new TextInputDialog("Type the string to append.");
        dialog.setHeaderText(null);
        dialog.setTitle("Append String to File");
        dialog.setContentText("Type the string to append:");
        this.string = dialog.showAndWait().orElse("");

        //get txt file to append string to
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select file to append string to");
        
        //allow the selection of txt files only
        fileChooser.getExtensionFilters().add(new ExtensionFilter("Text files (*.txt)", "*.txt"));
           
        this.file = fileChooser.showOpenDialog(new Stage());
    }
    
    @Override
    public void executeAction(){
       //append string to file
        try (FileWriter fr = new FileWriter(file.getAbsolutePath(), true)) {
            fr.write(string);
            fr.close();
        } catch (IOException ex) {
            Logger.getLogger(AppendStringToFileDecorator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @Override
    public String toString(){
        return "Append string: " + string + " to file: " + file.toString() + "\n" + super.toString();
    }
}

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

/**
 *
 * @author Leonardo
 */
public class AppendStringToFileDecorator extends ActionDecorator implements Serializable{
    private File file;
    private String string;
   

    public AppendStringToFileDecorator(File file, String string, Action BasicAction) {
        super(BasicAction);
        this.file = file;
        this.string = string;
        
    }

    /**
     *
     * @throws IOException
     */
    @Override
    public void executeAction(){
       
        try (FileWriter fr = new FileWriter(file.getAbsolutePath(), true)) {
            fr.write(string);
            fr.close();
        } catch (IOException ex) {
            Logger.getLogger(AppendStringToFileDecorator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @Override
    public String toString(){
        return "Append string: " + string + " to file: " + file.toString() +" ";
    }
}

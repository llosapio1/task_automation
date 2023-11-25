/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.azioni;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Alejandro
 */
public class ActionFactory{

    public static Action create(String selectedType) {
        Action action = new BasicAction();
        if(selectedType.equalsIgnoreCase("DisplayMessageAction")){
            String messagge = JOptionPane.showInputDialog("Type your messagge please");
            return new DisplayMessageAction(messagge, action);
        }
        
        else if(selectedType.equalsIgnoreCase("PlayAudioAction")){
             JFileChooser fileChooser = new JFileChooser();
             FileNameExtensionFilter filter = new FileNameExtensionFilter("WAV files(*.wav)", "wav");
             fileChooser.setFileFilter(filter);

            int result = fileChooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectFile = fileChooser.getSelectedFile();
                return new PlayAudioAction(selectFile, action);
             } 
            else {
                return null;
            }
        }
        else{
            return null;
        }
            
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import taskautomation.azioni.*;

/**
 *
 * @author Alejandro
 */
public class ActionFactory implements Factory{
    Action action = new BasicAction();

    @Override
    public Action create(String selectedType) {
        if(selectedType.equalsIgnoreCase("1")){
            String messagge = JOptionPane.showInputDialog("Type your messagge please");
            return new DisplayMessageAction(messagge, action);
        }
        
        else{
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
    }


    @Override
    public int selected() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

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
        if(selectedType.equalsIgnoreCase("DisplayMessage")){
            String messagge = JOptionPane.showInputDialog("Type your messagge please");
            return new DisplayMessageDecorator(messagge, action);
        }
        
        else if(selectedType.equalsIgnoreCase("PlayAudio")){
             JFileChooser fileChooser = new JFileChooser();
             FileNameExtensionFilter filter = new FileNameExtensionFilter("WAV files(*.wav)", "wav");
             fileChooser.setFileFilter(filter);

            int result = fileChooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectFile = fileChooser.getSelectedFile();
                return new PlayAudioDecorator(selectFile, action);
             } 
            else {
                return null;
            }
        } else if(selectedType.equalsIgnoreCase("AppendStringToFile")){
            
            return new AppendStringToFileDecorator(action);
        }
        else if (selectedType.equalsIgnoreCase("MoveFileToDir")){
            
            return new MoveFileToDirDecorator(action);
        } else if (selectedType.equalsIgnoreCase("CopyFileToDir")){
           
            return new CopyFileToDirDecorator(action); 
        }
        else if (selectedType.equalsIgnoreCase("DeleteFile")){
           
               return new DeleteFileDecorator(action);

        }
        else{
            return action;
        }
            
    }

}

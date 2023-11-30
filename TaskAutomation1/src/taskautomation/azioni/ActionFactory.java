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
            String string = JOptionPane.showInputDialog("Type the string to append.");
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("select file to append string to");
           FileNameExtensionFilter filter = new FileNameExtensionFilter("text files(*.txt)", "txt");
           fileChooser.setFileFilter(filter);
            int res = fileChooser.showOpenDialog(null);
           if(res == JFileChooser.APPROVE_OPTION){
               File selectedFile = fileChooser.getSelectedFile();
               return new AppendStringToFileDecorator(selectedFile, string, action);
           }
           
            return null;
        }
        else if (selectedType.equalsIgnoreCase("MoveFileBetweenDirs")){
            JFileChooser fileChooser1 = new JFileChooser();
            fileChooser1.setDialogTitle("choose file to move");
            int res1 = fileChooser1.showOpenDialog(null);
            
            
            JFileChooser fileChooser2 = new JFileChooser();
            fileChooser2.setDialogTitle("choose destination folder");
            fileChooser2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int res2= fileChooser2.showOpenDialog(null);
            
           if(res1 == JFileChooser.APPROVE_OPTION && res2 == JFileChooser.APPROVE_OPTION){
               File selectedFile = fileChooser1.getSelectedFile();  
               File selectedDir = fileChooser2.getSelectedFile();
               return new MoveFileBetweenDirsDecorator(selectedFile, selectedDir, action);
           } 
            return null;
        } else if (selectedType.equalsIgnoreCase("CopyFileToDir")){
            JFileChooser fileChooser1 = new JFileChooser();
            fileChooser1.setDialogTitle("choose file to copy");
            int res1 = fileChooser1.showOpenDialog(null);
            
            
            JFileChooser fileChooser2 = new JFileChooser();
            fileChooser2.setDialogTitle("choose destination folder");
            fileChooser2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int res2= fileChooser2.showOpenDialog(null);
            
           if(res1 == JFileChooser.APPROVE_OPTION && res2 == JFileChooser.APPROVE_OPTION){
               File selectedFile = fileChooser1.getSelectedFile();  
               File selectedDir = fileChooser2.getSelectedFile();
               return new CopyFileToDirDecorator(selectedFile, selectedDir, action);
           } 
            return null; 
        }
        else if (selectedType.equalsIgnoreCase("DeleteFile")){
           JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("select file to delete");
           
            int res = fileChooser.showOpenDialog(null);
           if(res == JFileChooser.APPROVE_OPTION){
               File selectedFile = fileChooser.getSelectedFile();
               return new DeleteFileDecorator(selectedFile, action);
           }
           
            return null; 
        }
        else{
            return null;
        }
            
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.azioni;

import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.scene.control.TextInputDialog;
import taskautomation.Factory;

/**
 * ActionFactory class for creating Action objects.
 * 
 * @author Alejandro
 */
public class ActionFactory implements Factory<Action> {

    @Override
    public Action create(String selectedType, Action action) {
        if (selectedType.equalsIgnoreCase("DisplayMessage")) {
            TextInputDialog dialog = new TextInputDialog("Type your message please");
            dialog.setHeaderText(null);
            dialog.setTitle("Display Message");
            dialog.setContentText("Type your message please:");
            String message = dialog.showAndWait().orElse("");
            return new DisplayMessageDecorator(message, action);
        } else if (selectedType.equalsIgnoreCase("PlayAudio")) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Audio File");
            fileChooser.getExtensionFilters().add(new ExtensionFilter("WAV files (*.wav)", "*.wav"));
            File selectedFile = fileChooser.showOpenDialog(new Stage());
            return (selectedFile != null) ? new PlayAudioDecorator(selectedFile, action) : null;
        } else if (selectedType.equalsIgnoreCase("AppendStringToFile")) {
            return new AppendStringToFileDecorator(action);
        } else if (selectedType.equalsIgnoreCase("MoveFileToDir")) {
            return new MoveFileToDirDecorator(action);
        } else if (selectedType.equalsIgnoreCase("CopyFileToDir")) {
            return new CopyFileToDirDecorator(action);
        } else if (selectedType.equalsIgnoreCase("DeleteFile")) {
            return new DeleteFileDecorator(action);
        } else if (selectedType.equalsIgnoreCase("ExecuteProgram")) {
            return new ExecuteProgramDecorator(action);
        } else if (selectedType.equalsIgnoreCase("AssignValueToCounter")){
            return new AssignValueToCounterDecorator(action);
        }else if (selectedType.equalsIgnoreCase("AddValueToCounter")){
            return new AddValueToCounterDecorator(action);
        }else if (selectedType.equalsIgnoreCase("AddCounterToCounter")){
            return new AddCounterToCounterDecorator(action);
        }
        else {
            return action;
        }
    }
}
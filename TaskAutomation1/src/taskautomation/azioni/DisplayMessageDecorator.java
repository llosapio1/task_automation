/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.azioni;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.io.Serializable;

/**
 * DisplayMessageDecorator class for displaying a message.
 * 
 * @author Alejandro
 */
public class DisplayMessageDecorator extends ActionDecorator implements Serializable {
    private String message;

    public DisplayMessageDecorator() {
    }

    public DisplayMessageDecorator(String message, Action actionDecorated) {
        super(actionDecorated);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String newMessage) {
        this.message = newMessage;
    }

    @Override
    public void executeAction() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("DisplayMessage");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
        super.executeAction();
    }

    @Override
    public String toString() {
        return "Display message: " + "\"" + message + "\"\n" + super.toString();
    }
}

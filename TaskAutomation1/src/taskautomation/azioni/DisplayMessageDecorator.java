/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.azioni;

import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro
 */
public class DisplayMessageDecorator extends ActionDecorator{
    private String messagge;

    public DisplayMessageDecorator(String messagge, Action actionDecorated) {
        super(actionDecorated);
        this.messagge = messagge;
    }

    public String getMessage() {
        return messagge;
    }
    
    public void setMessage(String newMessage) {
        this.messagge = newMessage;
    }
    
    @Override
    public void executeAction() {
        JOptionPane.showMessageDialog(null, messagge, "Notificazione", JOptionPane.INFORMATION_MESSAGE);
        super.executeAction(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}

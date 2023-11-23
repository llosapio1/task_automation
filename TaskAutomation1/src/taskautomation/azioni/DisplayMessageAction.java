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
public class DisplayMessageAction extends ActionDecorator{
    private final String messagge;

    public DisplayMessageAction(String messagge, Action actionDecorated) {
        super(actionDecorated);
        this.messagge = messagge;
    }

    @Override
    public void executedAction() {
        JOptionPane.showMessageDialog(null, messagge, "Notificazione", JOptionPane.INFORMATION_MESSAGE);
        super.executedAction(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}

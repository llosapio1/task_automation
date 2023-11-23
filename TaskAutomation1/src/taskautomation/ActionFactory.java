/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation;

import taskautomation.azioni.*;

/**
 *
 * @author Alejandro
 */
public class ActionFactory implements Factory{

    @Override
    public Object create(String selectedType) {
        if(selectedType.equalsIgnoreCase("1")){
            return new DisplayMessageAction(messagge, new BasicAction());
        }
        
        else{
            return new PlayAudioAction(file, new BasicAction());
        }
    }

    @Override
    public int selected() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

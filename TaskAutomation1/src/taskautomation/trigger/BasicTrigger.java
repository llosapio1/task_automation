/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.trigger;

import java.io.Serializable;

/**
 *
 * @author alessandro
 */
public class BasicTrigger implements Trigger, Serializable{

    @Override
    public boolean verifyTrigger() {
        return false;
    }
    
    @Override
    public String toString() {
        return "";
    }
    
}

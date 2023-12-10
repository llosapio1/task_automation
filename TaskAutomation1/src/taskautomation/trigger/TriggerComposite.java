/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.trigger;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public interface TriggerComposite extends Trigger{

    public void add(Trigger trigger);
    
    public void Remove(Trigger trigger);
       
    public Trigger getChildren(int index);
}

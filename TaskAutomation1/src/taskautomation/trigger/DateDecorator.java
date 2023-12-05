/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.trigger;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author alessandro
 */
public class DateDecorator  extends TriggerDecorator implements Serializable{
    
    LocalDate date;

    public DateDecorator(LocalDate date, Trigger decoratedTrigger) {
        super(decoratedTrigger);
        this.date = date;
    }
    
}

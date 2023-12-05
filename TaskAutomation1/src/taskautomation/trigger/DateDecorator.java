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

    public DateDecorator(Trigger decoratedTrigger, LocalDate date) {
        super(decoratedTrigger);
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean verifyTrigger() {
        // Controlla se la data odierna è uguale alla data del trigger
        return LocalDate.now().isEqual(date) | super.verifyTrigger();
    }
    
    @Override
    public String toString() {
        return "date: " + "\"" + date + "\"\n" + super.toString();
    }
}

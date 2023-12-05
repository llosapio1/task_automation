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
public class DayOfMonthDecorator extends TriggerDecorator implements Serializable{
    
    private int dayOfMonth;

    public DayOfMonthDecorator(Trigger decoratedTrigger, int dayOfMonth) {
        super(decoratedTrigger);
        this.dayOfMonth = dayOfMonth;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }
    
    @Override
    public boolean verifyTrigger() {
        // Controlla se il gionro della data odierna è uguale al giorno del trigger
        return LocalDate.now().getDayOfMonth() == dayOfMonth | super.verifyTrigger();
    }
    
    @Override
    public String toString() {
        return "day of month: " + "\"" + dayOfMonth + "\"\n" + super.toString();
    }
    
}

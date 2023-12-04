/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.trigger;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 *
 * @author alessandro
 */
public class DayOfWeekDecorator extends TriggerDecorator implements Serializable{
    
    private DayOfWeek dayOfWeek;

    public DayOfWeekDecorator(Trigger decoratedTrigger, DayOfWeek dayOfWeek) {
        super(decoratedTrigger);
        this.dayOfWeek = dayOfWeek;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
    
    @Override
    public boolean verifyTrigger() {
        
        DayOfWeek today = LocalDate.now().getDayOfWeek();;
        return (today.equals(dayOfWeek)) | super.verifyTrigger();
    }
    
    @Override
    public String toString() {
        return "day of week: " + "\"" + dayOfWeek + "\"\n" + super.toString();
    }
    
}

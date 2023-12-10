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
public class DayOfWeekTrigger implements Trigger, Serializable{
    
    private DayOfWeek dayOfWeek;

    public DayOfWeekTrigger(DayOfWeek dayOfWeek) {
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
        DayOfWeek dayOfWeekToday = LocalDate.now().getDayOfWeek();;
        return (dayOfWeekToday.equals(dayOfWeek));
    }
    
    @Override
    public String toString() {
        return "day of week: " + "\"" + dayOfWeek + "\"";
    }
    
}

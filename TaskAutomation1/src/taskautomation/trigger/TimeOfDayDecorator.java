package taskautomation.trigger;

import java.io.Serializable;
import java.time.LocalTime;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alessandro
 */
public class TimeOfDayDecorator extends TriggerDecorator implements Serializable{
    
    private LocalTime timeOfDay;

    
    public TimeOfDayDecorator() {
    }
    
    public TimeOfDayDecorator(Trigger decoratedTrigger, LocalTime timeOfDay) {
        super(decoratedTrigger);
        this.timeOfDay = timeOfDay;
    }

    public LocalTime getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(LocalTime timeOfDay) {
        if (timeOfDay == null) {
            throw new IllegalArgumentException("timeOfDay cannot be null");
        }
        this.timeOfDay = timeOfDay;
    }

    @Override
    public boolean verifyTrigger() {
        
        LocalTime currentTime = LocalTime.now();
        // Confronta solo ora e minuti
        return (currentTime.getHour() == timeOfDay.getHour() && currentTime.getMinute() == timeOfDay.getMinute()) | super.verifyTrigger();
    }
    
    @Override
    public String toString() {
        return "time Of Day: " + "\"" +timeOfDay + "\"\n" + super.toString();
    }
    
}

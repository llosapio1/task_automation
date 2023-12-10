/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package taskautomation.trigger;

import java.time.LocalTime;
import static junit.framework.Assert.*;
import static org.junit.Assert.assertThrows;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author alessandro
 */
public class TimeOfDayTriggerIT {
    
    private TimeOfDayTrigger instance;
    
    public TimeOfDayTriggerIT() {
    }
    
    @Before
    public void setUp() {
        // Crea un'istanza di TimeOfDayTrigger con valori di esempio
        instance = new TimeOfDayTrigger(LocalTime.of(12, 30));
    }

    /**
     * Test of getTimeOfDay method, of class TimeOfDayTrigger.
     */
    @Test
    public void testGetTimeOfDay() {
        LocalTime expResult = LocalTime.of(12, 30);
        LocalTime result = instance.getTimeOfDay();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTimeOfDay method, of class TimeOfDayTrigger.
     */
    @Test
    public void testSetTimeOfDay() {
        LocalTime timeOfDay = LocalTime.of(15, 45);
        instance.setTimeOfDay(timeOfDay);
        assertEquals(timeOfDay, instance.getTimeOfDay());
    }

    /**
     * Test of verifyTrigger method, of class TimeOfDayTrigger.
     */
    @Test
    public void testVerifyTriggerNow() {
        // Caso in cui l'orario corrente è uguale a timeOfDay
        instance.setTimeOfDay(LocalTime.now());
        assertTrue(instance.verifyTrigger());
    }
    
    @Test
    public void testVerifyTriggerNotNow() {
        // Caso in cui l'orario corrente è diverso da timeOfDay
        instance.setTimeOfDay(LocalTime.now().plusMinutes(30));
        assertFalse(instance.verifyTrigger());
    }
    
    @Test
    public void testSetTimeOfDayWithNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            instance.setTimeOfDay(null);
        });
    }
    
    @Test
    public void testVerifyTrigger() {

        LocalTime triggerTime = LocalTime.of(20, 59);
        
        // Decoro il BasicTrigger
        TimeOfDayTrigger instance2 = new TimeOfDayTrigger(triggerTime);
        
        if (LocalTime.now().equals(triggerTime))
            assertTrue(instance2.verifyTrigger());
        else
            assertFalse(instance2.verifyTrigger());
        
    }
    
}

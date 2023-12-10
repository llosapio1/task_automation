/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package taskautomation.trigger;

import java.time.DayOfWeek;
import java.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alessandro
 */
public class DayOfWeekTriggerIT {
    
    private DayOfWeekTrigger instance;
    
    public DayOfWeekTriggerIT() {
    }
    
    @Before
    public void setUp() {
        instance = new DayOfWeekTrigger(DayOfWeek.FRIDAY);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDayOfWeek method, of class DayOfWeekDecorator.
     */
    @Test
    public void testGetDayOfWeek() {
        assertEquals(instance.getDayOfWeek(), DayOfWeek.FRIDAY);
    }

    /**
     * Test of setDayOfWeek method, of class DayOfWeekDecorator.
     */
    @Test
    public void testSetDayOfWeek() {
        instance.setDayOfWeek(DayOfWeek.MONDAY);
        assertEquals(instance.getDayOfWeek(), DayOfWeek.MONDAY);
    }

    /**
     * Test of verifyTrigger method, of class DayOfWeekDecorator.
     */
    @Test
    public void testVerifyTriggerToday() {
        //Imposto il giorno al giorno ocrrente
        instance.setDayOfWeek(LocalDate.now().getDayOfWeek());
        assertTrue(instance.verifyTrigger());
    }
    
    @Test
    public void testVerifyTriggerNotToday() {
        //Imposto il giorno a dopodomani
        LocalDate dayAfterTomorrow = LocalDate.now().plusDays(2);
        instance.setDayOfWeek(dayAfterTomorrow.getDayOfWeek());
        assertFalse(instance.verifyTrigger());
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package taskautomation.trigger;

import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alessandro
 */
public class DayOfMonthTriggerIT {
    
    private DayOfMonthTrigger instance;
    private int day = 15;
    
    @Before
    public void setUp() {
        instance = new DayOfMonthTrigger(day);
    }

    /**
     * Test of getDayOfMonth method, of class DayOfMonthDecorator.
     */
    @Test
    public void testGetDayOfMonth() {
        assertEquals(instance.getDayOfMonth(), day);
    }

    /**
     * Test of setDayOfMonth method, of class DayOfMonthDecorator.
     */
    @Test
    public void testSetDayOfMonth() {
        int day2 = 17;
        instance.setDayOfMonth(day2);
        assertEquals(instance.getDayOfMonth(), day2);
    }

    /**
     * Test of verifyTrigger method, of class DayOfMonthDecorator.
     */
    @Test
    public void testVerifyTrigger() {
        int today = LocalDate.now().getDayOfMonth();
        if(today == instance.getDayOfMonth())
            assertTrue(instance.verifyTrigger());
        else
            assertFalse(instance.verifyTrigger());
    }

    @Test
    public void testVerifyTriggerNotToday() {
        int today = LocalDate.now().getDayOfMonth();
        instance.setDayOfMonth(today+2);
        assertFalse(instance.verifyTrigger());
    }
    
    @Test
    public void testVerifyTriggerToday() {
        int today = LocalDate.now().getDayOfMonth();
        instance.setDayOfMonth(today);
        assertTrue(instance.verifyTrigger());
    }
}

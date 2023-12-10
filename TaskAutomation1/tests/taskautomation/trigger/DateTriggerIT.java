/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package taskautomation.trigger;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alessandro
 */
public class DateTriggerIT {
    
    private DateTrigger instance;
    LocalDate date = LocalDate.of(2023, 12, 2);
    
    @Before
    public void setUp() {
        instance = new DateTrigger(date);
    }
    
    /**
     * Test of getDate method, of class DateDecorator.
     */
    @Test
    public void testGetDate() {
        assertEquals(instance.getDate(), date);
    }

    /**
     * Test of setDate method, of class DateDecorator.
     */
    @Test
    public void testSetDate() {
        LocalDate datePlusTwo = date.plusDays(2);
        instance.setDate(datePlusTwo);
        assertNotEquals(instance.getDate(), date);
        assertEquals(instance.getDate(), datePlusTwo);
    }

    /**
     * Test of verifyTrigger method, of class DateDecorator.
     */
    @Test
    public void testVerifyTrigger() {
        if (LocalDate.now().isEqual(date))
            assertTrue(instance.verifyTrigger());
        else
            assertFalse(instance.verifyTrigger());
    }
    
    @Test
    public void testVerifyTriggerToday() {
        LocalDate today = LocalDate.now();
        instance.setDate(today);
        assertTrue(instance.verifyTrigger());
    }
    
    @Test
    public void testVerifyTriggerNotToday() {
        LocalDate dayAfterTomorrow = date.plusDays(2);
        instance.setDate(dayAfterTomorrow);
        assertFalse(instance.verifyTrigger());
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package taskautomation.trigger;

import static junit.framework.Assert.*;
import org.junit.Test;

/**
 *
 * @author alessandro
 */
public class TriggerFactoryIT {

    /**
     * Test of create method, of class TriggerFactory.
     */
    @Test
    public void testCreateWithValidType() {
        
        String triggerType = "TimeOfDay";
        Trigger result = TriggerFactory.create(triggerType);
        assertTrue(result instanceof TimeOfDayDecorator);
        
    }
    
    @Test
    public void testCreateWithInvalidType() {
        
        String triggerType = "InvalidType";
        Trigger result = TriggerFactory.create(triggerType);
        assertTrue(result instanceof BasicTrigger);
        
    }
    
    @Test
    public void testCreateWithNullType() {
        
        String triggerType = null;
        Trigger result = TriggerFactory.create(triggerType);
        assertTrue(result instanceof BasicTrigger);
        
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package taskautomation;

import static junit.framework.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alessandro
 */
public class RuleIT {
    
    Trigger trigger;
    String triggerType;
    String actionType;
    Rule instance;
    
    @Before
    public void setUp() {
        trigger = new BasicTrigger();
        triggerType = "TimeOfDay";
        actionType = "DisplayMessage";
        instance = new Rule("Regola", triggerType, actionType);
    }

    /**
     * Test of getTrigger method, of class Rule.
     */
    
    @Test
    public void testGetTrigger() {
        
        Trigger result = instance.getTrigger();
        assertNotNull(result);
        assertTrue(result instanceof TimeOfDayDecorator);
    }

    /**
     * Test of setTrigger method, of class Rule.
     */
    
    @Test
    public void testSetTrigger() {
        
        instance.setTrigger(trigger);
        assertEquals(trigger, instance.getTrigger());
    }
    
}

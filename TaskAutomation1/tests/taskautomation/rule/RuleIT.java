/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package taskautomation.rule;

import static junit.framework.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import taskautomation.trigger.BasicTrigger;
import taskautomation.trigger.TimeOfDayDecorator;
import taskautomation.trigger.Trigger;
import static org.junit.Assert.*;
import taskautomation.azioni.Action;
import taskautomation.azioni.BasicAction;
import taskautomation.azioni.DisplayMessageDecorator;

/**
 *
 * @author alessandro
 */
public class RuleIT {
    
    Action action;
    Trigger trigger;
    String triggerType;
    String actionType;
    Rule instance;
    
    @Before
    public void setUp() {
        action = new BasicAction();
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
    
    
    @Test
    public void testGetAction() {
        
        Action result = instance.getAction();
        assertNotNull(result);
        assertTrue(result instanceof DisplayMessageDecorator);
    }

    /**
     * Test of setTrigger method, of class Rule.
     */
    
    @Test
    public void testSetAction() {
        
        instance.setAction(action);
        assertEquals(action, instance.getAction());
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package taskautomation.rule;

import static junit.framework.Assert.assertTrue;
import org.junit.Test;
import taskautomation.trigger.BasicTrigger;
import taskautomation.trigger.TimeOfDayDecorator;
import taskautomation.trigger.Trigger;
import static org.junit.Assert.*;
import org.junit.Before;
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
    Rule instanceActive;
    Rule instanceInactive;
    
    @Before
    public void setUp() {
        action = new BasicAction();
        trigger = new BasicTrigger();
        triggerType = "TimeOfDay";
        actionType = "DisplayMessage";
        instanceActive = new Rule("Regola1", triggerType, actionType, true);
        instanceInactive = new Rule("Regola2", triggerType, actionType, false);
    }

    /**
     * Test of getTrigger method, of class Rule.
     */
    
    @Test
    public void testGetTrigger() {
        Trigger result = instanceActive.getTrigger();
        assertNotNull(result);
        assertTrue(result instanceof TimeOfDayDecorator);
    }

    /**
     * Test of setTrigger method, of class Rule.
     */
    
    @Test
    public void testSetTrigger() {
        
        instanceActive.setTrigger(trigger);
        assertEquals(trigger, instanceActive.getTrigger());
    }
    
    
    @Test
    public void testGetAction() {
        
        Action result = instanceActive.getAction();
        assertNotNull(result);
        assertTrue(result instanceof DisplayMessageDecorator);
    }

    /**
     * Test of setTrigger method, of class Rule.
     */
    
    @Test
    public void testSetAction() {
        instanceActive.setAction(action);
        assertEquals(action, instanceActive.getAction());
    }

    /**
     * Test of isActive method, of class Rule.
     */
    @Test
    public void testIsActive() {
        assertTrue(instanceActive.isActive());
        assertFalse(instanceInactive.isActive());
    }

    /**
     * Test of setActive method, of class Rule.
     */
    @Test
    public void testSetActive() {
        instanceInactive.setActive(true);
        assertTrue(instanceInactive.isActive());
        instanceInactive.setActive(false);
        assertFalse(instanceInactive.isActive());
    }
    
        /**
     * Test of toggleActive method, of class Rule.
     */
    @Test
    public void testToggleActive() {
        assertTrue(instanceActive.isActive());
        instanceActive.toggleActive();
        assertFalse(instanceActive.isActive());
        instanceActive.toggleActive();
        assertTrue(instanceActive.isActive());
    }
}

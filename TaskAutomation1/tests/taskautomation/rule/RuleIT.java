/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package taskautomation.rule;

import java.time.LocalTime;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;
import taskautomation.trigger.Trigger;
import static org.junit.Assert.*;
import org.junit.Before;
import taskautomation.azioni.Action;
import taskautomation.azioni.BasicAction;
import taskautomation.azioni.DisplayMessageDecorator;

import taskautomation.trigger.TimeOfDayTrigger;

/**
 *
 * @author alessandro
 */
public class RuleIT {
    
    Action action;
    Trigger trigger;
    Rule instanceActive;
    Rule instanceInactive;
    Trigger timeOfDay;
    Action displayMessage = new DisplayMessageDecorator();

    @Before
    public void setUp() {
        action = new BasicAction();
        trigger = new TimeOfDayTrigger(LocalTime.now());
        instanceActive = new Rule("Regola1", trigger, action, true, true);
        instanceInactive = new Rule("Regola2", trigger, action, false, false);
    }

    /**
     * Test of getTrigger method, of class Rule.
     */
    
    @Test
    public void testGetTrigger() {
        Trigger result = instanceActive.getTrigger();
        assertNotNull(result);
        assertTrue(result instanceof TimeOfDayTrigger);
    }

    /**
     * Test of setTrigger method, of class Rule.
     */
    
    @Test
    public void testSetTrigger() {
        instanceActive.setTrigger(timeOfDay);
        assertEquals(timeOfDay, instanceActive.getTrigger());
    }
    
    
    @Test
    public void testGetAction() {
        
        Action result = instanceActive.getAction();
        assertNotNull(result);
        assertTrue(result instanceof BasicAction);
    }

    /**
     * Test of setTrigger method, of class Rule.
     */
    
    @Test
    public void testSetAction() {
        instanceActive.setAction(displayMessage);
        assertEquals(displayMessage, instanceActive.getAction());
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

    /**
     * Test of getName method, of class Rule.
     */
    @Test
    public void testGetName() {
        assertEquals("Regola1", instanceActive.getName());
        assertEquals("Regola2", instanceInactive.getName());
    }

    /**
     * Test of setName method, of class Rule.
     */
    @Test
    public void testSetName() {
        String newName = "NewRule";
        instanceActive.setName(newName);
        assertEquals(newName, instanceActive.getName());
    }

    /**
     * Test of getActive method, of class Rule.
     */
    @Test
    public void testGetActive() {
        assertEquals("Enable", instanceActive.getActive());
        assertEquals("Disable", instanceInactive.getActive());
    }

    /**
     * Test of isFiredOnlyOnce method, of class Rule.
     */
    @Test
    public void testIsFiredOnlyOnce() {
        assertTrue(instanceActive.isFiredOnlyOnce());
        assertFalse(instanceInactive.isFiredOnlyOnce());
    }

    /**
     * Test of setFiredOnlyOnce method, of class Rule.
     */
    @Test
    public void testSetFiredOnlyOnce() {
        assertTrue(instanceActive.isFiredOnlyOnce());
        instanceActive.setFiredOnlyOnce(false);
        assertFalse(instanceActive.isFiredOnlyOnce());
        instanceActive.setFiredOnlyOnce(true);
        assertTrue(instanceActive.isFiredOnlyOnce());
    }

}

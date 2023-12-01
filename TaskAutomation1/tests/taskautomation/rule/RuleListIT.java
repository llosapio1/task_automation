/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package taskautomation.rule;

import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import taskautomation.azioni.Action;
import taskautomation.azioni.BasicAction;
import taskautomation.trigger.BasicTrigger;
import taskautomation.trigger.Trigger;

/**
 *
 * @author alessandro
 */
public class RuleListIT {
    
    static Rule validRule;
    static RuleList ruleList;
    static Action action;
    static Trigger trigger;
    
    @BeforeClass
    public static void setUp() {
        action = new BasicAction();
        trigger = new BasicTrigger();
        validRule = new Rule("Regola", trigger, action, true, false);
        ruleList = RuleList.getRuleList();
    }

    /**
     * Test of addRule method, of class RuleList.
     */
    
    @Test
    public void testAddRule() {
        assertTrue(ruleList.addRule(validRule));
    }

    /**
     * Test of getRuleList method, of class RuleList.
     */
    @Test
    public void testGetRuleList() {
        RuleList instance = RuleList.getRuleList();
        assertNotNull(instance);
        assertTrue(instance instanceof RuleList);
    }

    /**
     * Test of get method, of class RuleList.
     */
    @Test
    public void testGet() {
        assertTrue(ruleList.get() instanceof LinkedList);
    }

    /**
     * Test of removeRule method, of class RuleList.
     */
    @Test
    public void testRemoveRule() {
        assertTrue(ruleList.removeRule(validRule));
    }
    
}

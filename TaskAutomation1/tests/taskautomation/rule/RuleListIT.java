/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package taskautomation.rule;

import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author alessandro
 */
public class RuleListIT {
    
    static Rule validRule;
    static RuleList ruleList;
    
    @BeforeClass
    public static void setUp() {
        validRule = new Rule("Regola", "TimeOfDay", "DisplayMessage", true, false);
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

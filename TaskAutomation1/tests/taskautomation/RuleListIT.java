/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package taskautomation;

import taskautomation.rule.RuleList;
import taskautomation.rule.Rule;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alessandro
 */
public class RuleListIT {
    
    Rule validRule;
    RuleList ruleList;
    
    @Before
    public void setUp() {
        validRule = new Rule("Regola", "TimeOfDay", "DisplayMessage");
        ruleList = new RuleList();
    }

    /**
     * Test of addRule method, of class RuleList.
     */
    
    @Test
    public void testAddRule() {
        
        boolean result = ruleList.addRule(validRule);
        
        assertTrue(result);
    }
    
}

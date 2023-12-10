/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package taskautomation.trigger;

import static junit.framework.Assert.assertTrue;
import org.junit.Test;
/**
 *
 * @author alessandro
 */

public class TriggerFactoryIT {
    
    private final TriggerFactory tf = new TriggerFactory();
    private BasicTrigger br = new BasicTrigger();

    /**
     * Test of create method, of class TriggerFactory.
     */
    
    @Test
    public void testCreateWithInvalidType() {
        String triggerType = "InvalidType";
        Trigger result = tf.create(triggerType, br);
        assertTrue(result instanceof BasicTrigger);
    }
    
    @Test
    public void testCreateWithNullType() {
        String triggerType = null;
        Trigger result = tf.create(triggerType, br);
        assertTrue(result instanceof BasicTrigger);
    }
    
}

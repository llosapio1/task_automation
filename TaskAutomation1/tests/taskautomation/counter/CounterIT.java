/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package taskautomation.counter;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alessandro
 */
public class CounterIT {
    
    private String name = "Counter1";
    private int value = 5;
    private Counter instance;
    
    @Before
    public void setUp() {
        instance = new Counter(name, value);
    }

    /**
     * Test of getName method, of class Counter.
     */
    @Test
    public void testGetName() {
        assertEquals(instance.getName(), name);
    }

    /**
     * Test of getValue method, of class Counter.
     */
    @Test
    public void testGetValue() {
        assertEquals(instance.getValue(), value);
    }

    /**
     * Test of setValue method, of class Counter.
     */
    @Test
    public void testSetValue() {
        assertEquals(instance.getValue(), value);
        int newValue = value * 2;
        instance.setValue(newValue);
        assertNotEquals(instance.getValue(), value);
        assertEquals(instance.getValue(), newValue);
    }
    
}

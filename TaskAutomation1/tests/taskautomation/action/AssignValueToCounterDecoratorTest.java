/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package taskautomation.action;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import taskautomation.azioni.AssignValueToCounterDecorator;
import taskautomation.azioni.BasicAction;
import taskautomation.counter.Counter;
import taskautomation.counter.CounterList;

/**
 *
 * @author Leonardo
 */
public class AssignValueToCounterDecoratorTest {
    
    public AssignValueToCounterDecoratorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testExecuteAction() {
        System.out.println("executeAction");
        String counterName = "testing";
        int initValue = 0;
        Counter counter = new Counter(counterName, initValue);
        CounterList.getCounterList().addCounter(counter);
        
        int value = 10;
        BasicAction action = new BasicAction();
        AssignValueToCounterDecorator instance = new AssignValueToCounterDecorator(counterName, value, action);
        instance.executeAction();
        int index = CounterList.getCounterList().get().indexOf(counter); 
        Counter c = CounterList.getCounterList().get().get(index);
        assertEquals(value, c.getValue());
        CounterList.getCounterList().removeCounter(c);
        
        counterName = "test2";
        initValue = 5;
        counter = new Counter(counterName, initValue);
        CounterList.getCounterList().addCounter(counter);
        
        value = 20;
        
        AssignValueToCounterDecorator instance2 = new AssignValueToCounterDecorator(counterName, value, action);
        instance2.executeAction();
        index = CounterList.getCounterList().get().indexOf(counter); 
        c = CounterList.getCounterList().get().get(index);
        assertEquals(value, c.getValue());
        CounterList.getCounterList().removeCounter(c);
        
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        String counterName = "testCounter";
        int value = 5;
        BasicAction action = new BasicAction();
        AssignValueToCounterDecorator instance = new AssignValueToCounterDecorator(counterName, value, action);
        
        String expResult = "Assign value: " + value + " to counter: " + counterName + "\n";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        counterName = "test123Counter";
        value = 70;
        
        AssignValueToCounterDecorator instance2 = new AssignValueToCounterDecorator(counterName, value, action);
        
        expResult = "Assign value: " + value + " to counter: " + counterName + "\n";
        result = instance2.toString();
        assertEquals(expResult, result);
        
        
    }
    
}

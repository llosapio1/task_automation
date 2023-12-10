/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package taskautomation.trigger;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import taskautomation.counter.Counter;
import taskautomation.counter.CounterList;

/**
 *
 * @author Leonardo
 */
public class CounterIsLessThanValueDecoratorTest {
    
    public CounterIsLessThanValueDecoratorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

     @Test
    public void testVerifyTrigger() {
        System.out.println("verifyTrigger");
       
        String counterName = "testing";
        int counterValue = 0;
        int value = 10;
        Counter counter = new Counter(counterName, counterValue);
        CounterList.getCounterList().addCounter(counter);
        
        BasicTrigger trigger = new BasicTrigger();
        CounterIsLessThanValueDecorator instance = new CounterIsLessThanValueDecorator(counterName, value, trigger);
        boolean result = instance.verifyTrigger();
        boolean exp= true;
        
        assertEquals(exp, result);
        
        int index = CounterList.getCounterList().get().indexOf(counter); 
        Counter c = CounterList.getCounterList().get().get(index);
        CounterList.getCounterList().removeCounter(c);
        
        
        
        counterName = "abc";
        counterValue = 30;
        value = 20;
        counter = new Counter(counterName, counterValue);
        CounterList.getCounterList().addCounter(counter);
        
        CounterIsLessThanValueDecorator instance2 = new CounterIsLessThanValueDecorator(counterName, value, trigger);
        result = instance2.verifyTrigger();
        exp= false;
        
        assertEquals(exp, result);
        
        index = CounterList.getCounterList().get().indexOf(counter); 
        c = CounterList.getCounterList().get().get(index);
        CounterList.getCounterList().removeCounter(c);
        
        
    }

    @Test
    public void testToString() {
        System.out.println("toString");
 
        String counterName = "testCounter";
        int value = 5;
        BasicTrigger trigger = new BasicTrigger();
        CounterIsLessThanValueDecorator instance = new CounterIsLessThanValueDecorator(counterName, value, trigger);
        
        String expResult = "Counter: " + counterName + "value is less than: " + value + "\n";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        counterName = "test123Counter";
        value = 70;
        
        CounterIsLessThanValueDecorator instance2 = new CounterIsLessThanValueDecorator(counterName, value, trigger);
        
        expResult = "Counter: " + counterName + "value is less than: " + value + "\n";
        result = instance2.toString();
        assertEquals(expResult, result);
    }
    
}

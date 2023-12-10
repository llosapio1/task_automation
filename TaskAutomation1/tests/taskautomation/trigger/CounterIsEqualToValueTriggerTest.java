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
public class CounterIsEqualToValueTriggerTest {
    
    public CounterIsEqualToValueTriggerTest() {
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
       
        //create counter with name and value, then add it to counter list
        String counterName = "testing";
        int counterValue = 0;
        int value = 10;  //value to check counter's value against
        Counter counter = new Counter(counterName, counterValue);
        CounterList.getCounterList().addCounter(counter);
        
        CounterIsEqualToValueTrigger instance = new CounterIsEqualToValueTrigger(counterName, value);
        boolean result = instance.verifyTrigger(); //check if counter's value is equal to given value
        boolean exp= false;
        
        assertEquals(exp, result);
        
        //get counter from counter list and delete it
        int index = CounterList.getCounterList().get().indexOf(counter); 
        Counter c = CounterList.getCounterList().get().get(index);
        CounterList.getCounterList().removeCounter(c);
        
        
        //Same as above
        counterName = "abc";
        counterValue = 20;
        value = 20;
        counter = new Counter(counterName, counterValue);
        CounterList.getCounterList().addCounter(counter);
        
        CounterIsEqualToValueTrigger instance2 = new CounterIsEqualToValueTrigger(counterName, value);
        result = instance2.verifyTrigger();
        exp= true;
        
        assertEquals(exp, result);
        
        index = CounterList.getCounterList().get().indexOf(counter); 
        c = CounterList.getCounterList().get().get(index);
        CounterList.getCounterList().removeCounter(c);
        
        
    }

    @Test
    public void testToString() {
        System.out.println("toString");
 
        //use conter name and given value for decorator's constructor
        String counterName = "testCounter";
        int value = 5;
        CounterIsEqualToValueTrigger instance = new CounterIsEqualToValueTrigger(counterName, value);
        
        String expResult = "Counter: " + counterName + " 's value is equal to: " + value;
        String result = instance.toString();
        assertEquals(expResult, result);
        
        //Same as above
        counterName = "test123Counter";
        value = 70;
        
        CounterIsEqualToValueTrigger instance2 = new CounterIsEqualToValueTrigger(counterName, value);
        
        expResult = "Counter: " + counterName + " 's value is equal to: " + value ;
        result = instance2.toString();
        assertEquals(expResult, result);
    }
    
}

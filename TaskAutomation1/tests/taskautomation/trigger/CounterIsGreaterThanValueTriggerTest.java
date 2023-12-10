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
public class CounterIsGreaterThanValueTriggerTest {
    
    public CounterIsGreaterThanValueTriggerTest() {
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
        int value = 10; //given value to check counter's value against
        Counter counter = new Counter(counterName, counterValue);
        CounterList.getCounterList().addCounter(counter);
        
        CounterIsGreaterThanValueTrigger instance = new CounterIsGreaterThanValueTrigger(counterName, value);
        boolean result = instance.verifyTrigger(); //check if counter is greater than given value
        boolean exp= false;
        
        assertEquals(exp, result);
        
        //get counter from counter list and delete it
        int index = CounterList.getCounterList().get().indexOf(counter); 
        Counter c = CounterList.getCounterList().get().get(index);
        CounterList.getCounterList().removeCounter(c);
        
        
        //same as above
        counterName = "abc";
        counterValue = 30;
        value = 20;
        counter = new Counter(counterName, counterValue);
        CounterList.getCounterList().addCounter(counter);
        
        CounterIsGreaterThanValueTrigger instance2 = new CounterIsGreaterThanValueTrigger(counterName, value);
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
 
        //use counter name and given value for decorator's constructor
        String counterName = "testCounter";
        int value = 5;
        CounterIsGreaterThanValueTrigger instance = new CounterIsGreaterThanValueTrigger(counterName, value);
        
        String expResult = "Counter: " + counterName + " 's value is greater than: " + value ;
        String result = instance.toString();
        assertEquals(expResult, result);
        
        //Same as above
        counterName = "test123Counter";
        value = 70;
        
        CounterIsGreaterThanValueTrigger instance2 = new CounterIsGreaterThanValueTrigger(counterName, value);
        
        expResult = "Counter: " + counterName + " 's value is greater than: " + value;
        result = instance2.toString();
        assertEquals(expResult, result);
    }
    
}

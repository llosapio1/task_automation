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
public class CounterIsGreaterThanCounterTriggerTest {
    
    public CounterIsGreaterThanCounterTriggerTest() {
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
       
        //create two counters with names and values and add them to counter list
        String counterName1 = "testing";
        int counterValue1 = 5;
        String counterName2 = "testing2";
        int counterValue2= 0;
        
        Counter counter1 = new Counter(counterName1, counterValue1);
        CounterList.getCounterList().addCounter(counter1);
        
        Counter counter2 = new Counter(counterName2, counterValue2);
        CounterList.getCounterList().addCounter(counter2);
        
        CounterIsGreaterThanCounterTrigger instance = new CounterIsGreaterThanCounterTrigger(counterName1, counterName2);
        boolean result = instance.verifyTrigger(); //check if one counter is greater than the other
        boolean exp= true;
        
        assertEquals(exp, result);
        
        //get test counters from counter list and delete them
        int index1 = CounterList.getCounterList().get().indexOf(counter1); 
        Counter c1 = CounterList.getCounterList().get().get(index1);
        CounterList.getCounterList().removeCounter(c1);
        int index2 = CounterList.getCounterList().get().indexOf(counter2); 
        Counter c2 = CounterList.getCounterList().get().get(index2);
        CounterList.getCounterList().removeCounter(c2);
        
        
        //same as above
        counterName1 = "abc";
        counterValue1 = 5;
        counterName2 = "cdf";
        counterValue2= 20;
        
        counter1 = new Counter(counterName1, counterValue1);
        CounterList.getCounterList().addCounter(counter1);
        
        counter2 = new Counter(counterName2, counterValue2);
        CounterList.getCounterList().addCounter(counter2);
        
        CounterIsGreaterThanCounterTrigger instance2 = new CounterIsGreaterThanCounterTrigger(counterName1, counterName2);
        result = instance2.verifyTrigger();
        exp= false;
        
        assertEquals(exp, result);
        
        index1 = CounterList.getCounterList().get().indexOf(counter1); 
        c1 = CounterList.getCounterList().get().get(index1);
        CounterList.getCounterList().removeCounter(c1);
        index2 = CounterList.getCounterList().get().indexOf(counter2); 
        c2 = CounterList.getCounterList().get().get(index2);
        CounterList.getCounterList().removeCounter(c2);
        
        
    }

    @Test
    public void testToString() {
        System.out.println("toString");
 
        //use two counter names for decorator's constructor
        String counterName1 = "test1counter";
        String counterName2 = "test2counter";
        CounterIsGreaterThanCounterTrigger instance = new CounterIsGreaterThanCounterTrigger(counterName1, counterName2);
        
        String expResult = "Counter: " + counterName1 + " 's value is greater than: " + counterName2 ;
        String result = instance.toString();
        assertEquals(expResult, result);
        
        //same as above
        counterName1 = "hello";
        counterName2 = "world";
        
        CounterIsGreaterThanCounterTrigger instance2 = new CounterIsGreaterThanCounterTrigger(counterName1, counterName2);
        
        expResult = "Counter: " + counterName1 + " 's value is greater than: " + counterName2 ;
        result = instance2.toString();
        assertEquals(expResult, result);
    }
    
}

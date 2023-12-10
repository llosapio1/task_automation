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
public class CounterIsEqualToCounterTriggerTest {
    
    public CounterIsEqualToCounterTriggerTest() {
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
       
        //create two counters with names and values then add them to counter list
        String counterName1 = "testing";
        int counterValue1 = 0;
        String counterName2 = "testing2";
        int counterValue2= 0;
        
        Counter counter1 = new Counter(counterName1, counterValue1);
        CounterList.getCounterList().addCounter(counter1);
        
        Counter counter2 = new Counter(counterName2, counterValue2);
        CounterList.getCounterList().addCounter(counter2);
        
        CounterIsEqualToCounterTrigger instance = new CounterIsEqualToCounterTrigger(counterName1, counterName2);
        boolean result = instance.verifyTrigger(); //check if counters' values are equal
        boolean exp= true;
        
        assertEquals(exp, result);
        
        //get counters from counter list and remove them
        int index1 = CounterList.getCounterList().get().indexOf(counter1); 
        Counter c1 = CounterList.getCounterList().get().get(index1);
        CounterList.getCounterList().removeCounter(c1);
        int index2 = CounterList.getCounterList().get().indexOf(counter2); 
        Counter c2 = CounterList.getCounterList().get().get(index2);
        CounterList.getCounterList().removeCounter(c2);
        
        
        //Same as above
        counterName1 = "abc";
        counterValue1 = 5;
        counterName2 = "cdf";
        counterValue2= 20;
        
        counter1 = new Counter(counterName1, counterValue1);
        CounterList.getCounterList().addCounter(counter1);
        
        counter2 = new Counter(counterName2, counterValue2);
        CounterList.getCounterList().addCounter(counter2);
        
        CounterIsEqualToCounterTrigger instance2 = new CounterIsEqualToCounterTrigger(counterName1, counterName2);
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
 
        //use two counters' names for decorator's constructor
        String counterName1 = "test1counter";
        String counterName2 = "test2counter";
        CounterIsEqualToCounterTrigger instance = new CounterIsEqualToCounterTrigger(counterName1, counterName2);
        
        String expResult = "Counter: " + counterName1 + " 's value is equal to: " + counterName2 ;
        String result = instance.toString();
        assertEquals(expResult, result);
        
        //same as above
        counterName1 = "hello";
        counterName2 = "world";
        
        CounterIsEqualToCounterTrigger instance2 = new CounterIsEqualToCounterTrigger(counterName1, counterName2);
        
        expResult = "Counter: " + counterName1 + " 's value is equal to: " + counterName2 ;
        result = instance2.toString();
        assertEquals(expResult, result);
    }
    
}

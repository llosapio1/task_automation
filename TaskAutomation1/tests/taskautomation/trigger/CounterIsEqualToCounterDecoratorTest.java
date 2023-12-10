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
public class CounterIsEqualToCounterDecoratorTest {
    
    public CounterIsEqualToCounterDecoratorTest() {
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
       
        String counterName1 = "testing";
        int counterValue1 = 0;
        String counterName2 = "testing2";
        int counterValue2= 0;
        
        Counter counter1 = new Counter(counterName1, counterValue1);
        CounterList.getCounterList().addCounter(counter1);
        
        Counter counter2 = new Counter(counterName2, counterValue2);
        CounterList.getCounterList().addCounter(counter2);
        
        BasicTrigger trigger = new BasicTrigger();
        CounterIsEqualToCounterDecorator instance = new CounterIsEqualToCounterDecorator(counterName1, counterName2, trigger);
        boolean result = instance.verifyTrigger();
        boolean exp= true;
        
        assertEquals(exp, result);
        
        int index1 = CounterList.getCounterList().get().indexOf(counter1); 
        Counter c1 = CounterList.getCounterList().get().get(index1);
        CounterList.getCounterList().removeCounter(c1);
        int index2 = CounterList.getCounterList().get().indexOf(counter2); 
        Counter c2 = CounterList.getCounterList().get().get(index2);
        CounterList.getCounterList().removeCounter(c2);
        
        
        
        counterName1 = "abc";
        counterValue1 = 5;
        counterName2 = "cdf";
        counterValue2= 20;
        
        counter1 = new Counter(counterName1, counterValue1);
        CounterList.getCounterList().addCounter(counter1);
        
        counter2 = new Counter(counterName2, counterValue2);
        CounterList.getCounterList().addCounter(counter2);
        
        CounterIsEqualToCounterDecorator instance2 = new CounterIsEqualToCounterDecorator(counterName1, counterName2, trigger);
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
 
        String counterName1 = "test1counter";
        String counterName2 = "test2counter";
        BasicTrigger trigger = new BasicTrigger();
        CounterIsEqualToCounterDecorator instance = new CounterIsEqualToCounterDecorator(counterName1, counterName2, trigger);
        
        String expResult = "Counter: " + counterName1 + "value is equal to: " + counterName2 + "\n";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        
        counterName1 = "hello";
        counterName2 = "world";
        
        CounterIsEqualToCounterDecorator instance2 = new CounterIsEqualToCounterDecorator(counterName1, counterName2, trigger);
        
        expResult = "Counter: " + counterName1 + "value is equal to: " + counterName2 + "\n";
        result = instance2.toString();
        assertEquals(expResult, result);
    }
    
}

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
       
        //create a counter with name and value, then add it to counter list
        String counterName = "testing";
        int counterValue = 0;
        int value = 10; //given value to check against counter's value
        Counter counter = new Counter(counterName, counterValue);
        CounterList.getCounterList().addCounter(counter);
        
        BasicTrigger trigger = new BasicTrigger();
        CounterIsLessThanValueDecorator instance = new CounterIsLessThanValueDecorator(counterName, value, trigger);
        boolean result = instance.verifyTrigger();  //check if counter's value is less than given value
        boolean exp= true;
        
        assertEquals(exp, result);
        
        //get counter from counter list, then delete it
        int index = CounterList.getCounterList().get().indexOf(counter); 
        Counter c = CounterList.getCounterList().get().get(index);
        CounterList.getCounterList().removeCounter(c);
        
        
        //same as above
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
 
        //use counter name and given value for decorator's constructor
        String counterName = "testCounter";
        int value = 5;
        BasicTrigger trigger = new BasicTrigger();
        CounterIsLessThanValueDecorator instance = new CounterIsLessThanValueDecorator(counterName, value, trigger);
        
        String expResult = "Counter: " + counterName + " 's value is less than: " + value + "\n";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        //same as above
        counterName = "test123Counter";
        value = 70;
        
        CounterIsLessThanValueDecorator instance2 = new CounterIsLessThanValueDecorator(counterName, value, trigger);
        
        expResult = "Counter: " + counterName + " 's value is less than: " + value + "\n";
        result = instance2.toString();
        assertEquals(expResult, result);
    }
    
}

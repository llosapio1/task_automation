/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package taskautomation.action;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import taskautomation.azioni.AddValueToCounterDecorator;
import taskautomation.azioni.BasicAction;
import taskautomation.counter.Counter;
import taskautomation.counter.CounterList;

/**
 *
 * @author Leonardo
 */
public class AddValueToCounterDecoratorTest {

    @Test
    public void testExecuteAction() {
        System.out.println("executeAction");
        
        //create new counter with name and value, then add it to counter list
        String counterName = "testing";
        int initValue = 0;  //initial counter's value (before add)
        Counter counter = new Counter(counterName, initValue);
        CounterList.getCounterList().addCounter(counter);
        
        //value to add to counter
        int value = 10;
        
        BasicAction action = new BasicAction();
        AddValueToCounterDecorator instance = new AddValueToCounterDecorator(counterName, value, action);
        instance.executeAction(); //value is added to counter
        
        //get counter from counter list
        int index = CounterList.getCounterList().get().indexOf(counter); 
        Counter c = CounterList.getCounterList().get().get(index);
        
        //assert
        assertEquals(initValue+value, c.getValue());
        
        //remove newly added counter
        CounterList.getCounterList().removeCounter(c);
        
        
        //Same as above
        counterName = "test2";
        initValue = 5;
        counter = new Counter(counterName, initValue);
        CounterList.getCounterList().addCounter(counter);
        
        value = 20;
        
        AddValueToCounterDecorator instance2 = new AddValueToCounterDecorator(counterName, value, action);
        instance2.executeAction();
        index = CounterList.getCounterList().get().indexOf(counter); 
        c = CounterList.getCounterList().get().get(index);
        assertEquals(initValue+value, c.getValue());
        CounterList.getCounterList().removeCounter(c);
        
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        
        //use counter name and value for decorator's constructor
        String counterName = "testCounter";
        int value = 5;
        BasicAction action = new BasicAction();
        AddValueToCounterDecorator instance = new AddValueToCounterDecorator(counterName, value, action);
        
        String expResult = "Add value: " + value + " to counter: " + counterName + "\n";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        //Same as above
        counterName = "test123Counter";
        value = 70;
        
        AddValueToCounterDecorator instance2 = new AddValueToCounterDecorator(counterName, value, action);
        
        expResult = "Add value: " + value + " to counter: " + counterName + "\n";
        result = instance2.toString();
        assertEquals(expResult, result);
        
        
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package taskautomation.action;

import org.junit.Test;
import static org.junit.Assert.*;
import taskautomation.azioni.AddCounterToCounterDecorator;
import taskautomation.azioni.BasicAction;
import taskautomation.counter.Counter;
import taskautomation.counter.CounterList;

/**
 *
 * @author Leonardo
 */
public class AddCounterToCounterDecoratorTest {

    @Test
    public void testExecuteAction() {
        System.out.println("executeAction");
        
        //creater two counters with name and value, then add to counter list
        String counterName1 = "testing1";
        String counterName2 = "testing2";
        int value1 = 5;
        int initValue2 = 10;
        Counter counter1 = new Counter(counterName1, value1);
        CounterList.getCounterList().addCounter(counter1);
        Counter counter2 = new Counter(counterName2, initValue2);
        CounterList.getCounterList().addCounter(counter2);
        
        BasicAction action = new BasicAction();
        AddCounterToCounterDecorator instance = new AddCounterToCounterDecorator(counterName1, counterName2, action);
        instance.executeAction();
        
        //get both counters from counter list
        int index2 = CounterList.getCounterList().get().indexOf(counter2); 
        Counter c2 = CounterList.getCounterList().get().get(index2);
        int index1 = CounterList.getCounterList().get().indexOf(counter1); 
        Counter c1 = CounterList.getCounterList().get().get(index1);
        
        //assert
        assertEquals(initValue2+value1, c2.getValue());
        
        //delete newly added counters
        CounterList.getCounterList().removeCounter(c2);
        CounterList.getCounterList().removeCounter(c1);
        
      
        //Same thing as above
        counterName1 = "ab";
        counterName2 = "cd";
        value1 = -5;
        initValue2 = 20;
        counter1 = new Counter(counterName1, value1);
        CounterList.getCounterList().addCounter(counter1);
        counter2 = new Counter(counterName2, initValue2);
        CounterList.getCounterList().addCounter(counter2);
        
       
        AddCounterToCounterDecorator instance2 = new AddCounterToCounterDecorator(counterName1, counterName2, action);
        instance2.executeAction();
        index2 = CounterList.getCounterList().get().indexOf(counter2); 
        c2 = CounterList.getCounterList().get().get(index2);
        index1 = CounterList.getCounterList().get().indexOf(counter1); 
        c1 = CounterList.getCounterList().get().get(index1);
        assertEquals(initValue2+value1, c2.getValue());
        CounterList.getCounterList().removeCounter(c2);
        CounterList.getCounterList().removeCounter(c1);
        
        
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        
        //use two counter names for decorator's constructor
        String counterName1 = "test1counter";
        String counterName2 = "test2counter";
        
        BasicAction action = new BasicAction();
        AddCounterToCounterDecorator instance = new AddCounterToCounterDecorator(counterName1, counterName2, action);
        
        String expResult = "Add value of counter: " + counterName1 + " to counter: " + counterName2 + "\n";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        //same as above
        counterName1 = "ac";
        counterName2 = "da";
        
        AddCounterToCounterDecorator instance2 = new AddCounterToCounterDecorator(counterName1, counterName2, action);
        
        expResult = "Add value of counter: " + counterName1 + " to counter: " + counterName2 + "\n";
        result = instance2.toString();
        assertEquals(expResult, result);
        
    }
    
}

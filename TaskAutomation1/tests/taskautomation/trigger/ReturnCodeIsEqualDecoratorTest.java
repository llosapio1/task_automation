/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package taskautomation.trigger;

import java.io.File;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leonardo
 */
public class ReturnCodeIsEqualDecoratorTest {
    
    public ReturnCodeIsEqualDecoratorTest() {
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
        File program = new File("greetings.exe");
        String arguments = "";
        int expValue = 0;
        
        Trigger decoratedTrigger = new BasicTrigger();
        ReturnCodeIsEqualDecorator instance1= new ReturnCodeIsEqualDecorator(program, arguments, expValue, decoratedTrigger);
        
        boolean expResult = true;
        boolean result = instance1.verifyTrigger();
        assertEquals(expResult, result);
        
        arguments = "testing";
        expValue = 2;
        
        ReturnCodeIsEqualDecorator instance2= new ReturnCodeIsEqualDecorator(program, arguments, expValue, decoratedTrigger);
        
        expResult = true;
        result = instance2.verifyTrigger();
        assertEquals(expResult, result);
        
        
        expValue = 3;
        
        ReturnCodeIsEqualDecorator instance3= new ReturnCodeIsEqualDecorator(program, arguments, expValue, decoratedTrigger);
        
        expResult = false;
        result = instance3.verifyTrigger();
        assertEquals(expResult, result);
        
        File output = new File("filename.txt");
        output.delete();
    }

    @Test
    public void testToString() {
       System.out.println("toString");
       
        File program = new File("greetings.exe");
        String arguments = "";
        int expValue = 0;
        
        Trigger decoratedTrigger = new BasicTrigger();
        ReturnCodeIsEqualDecorator instance1= new ReturnCodeIsEqualDecorator(program, arguments, expValue, decoratedTrigger);
       
        String expResult = "Program " + "\"" +program.toString() + "\"" + " executed with arguments " + "\"" +arguments+ "\""+ " return code checked against: " + expValue +"\n";
        String result = instance1.toString();
        assertEquals(expResult, result);
        
        
       program = new File("testing.exe");
       arguments = "test";
       expValue = 1;
       ReturnCodeIsEqualDecorator instance2= new ReturnCodeIsEqualDecorator(program, arguments, expValue, decoratedTrigger);
       
       expResult = "Program " + "\"" +program.toString() + "\"" + " executed with arguments " + "\"" +arguments+ "\""+ " return code checked against: " + expValue +"\n";
       result = instance2.toString();
       assertEquals(expResult, result);
       
       
    }
    
}

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
public class ReturnCodeIsEqualTriggerTest {
    
    public ReturnCodeIsEqualTriggerTest() {
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
        
        //get test application from this project's folder
        File program = new File("greetings.exe");
        String arguments = ""; //arguments to execute application with
        int expValue = 0; //value to check return code against
        
        ReturnCodeIsEqualTrigger instance1= new ReturnCodeIsEqualTrigger(program, arguments, expValue);
        
        boolean expResult = true;
        boolean result = instance1.verifyTrigger();  //check if test application's return code is equal to given value
        assertEquals(expResult, result);
        
        //same as above, test with different arguments
        arguments = "testing";
        expValue = 2;
        
        ReturnCodeIsEqualTrigger instance2= new ReturnCodeIsEqualTrigger(program, arguments, expValue);
        
        expResult = true;
        result = instance2.verifyTrigger();
        assertEquals(expResult, result);
        
        //same as above, test with different value to check against
        expValue = 3;
        
        ReturnCodeIsEqualTrigger instance3= new ReturnCodeIsEqualTrigger(program, arguments, expValue);
        
        expResult = false;
        result = instance3.verifyTrigger();
        assertEquals(expResult, result);
        
        File output = new File("filename.txt");
        output.delete();
    }

    @Test
    public void testToString() {
       System.out.println("toString");
       
       //use external program name, arguments and value for decorator's constructor
        File program = new File("greetings.exe");
        String arguments = "";
        int expValue = 0;
        
        ReturnCodeIsEqualTrigger instance1= new ReturnCodeIsEqualTrigger(program, arguments, expValue);
       
        String expResult = "Program " + "\"" +program.toString() + "\"" + " executed with arguments " + "\"" +arguments+ "\""+ " return code is equal to: " + expValue ;
        String result = instance1.toString();
        assertEquals(expResult, result);
        
        //same as above
       program = new File("testing.exe");
       arguments = "test";
       expValue = 1;
       ReturnCodeIsEqualTrigger instance2= new ReturnCodeIsEqualTrigger(program, arguments, expValue);
       
       expResult = "Program " + "\"" +program.toString() + "\"" + " executed with arguments " + "\"" +arguments+ "\""+ " return code is equal to: " + expValue ;
       result = instance2.toString();
       assertEquals(expResult, result);
       
       
    }
    
}

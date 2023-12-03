/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package taskautomation.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Thread.sleep;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import taskautomation.azioni.BasicAction;
import taskautomation.azioni.ExecuteProgramDecorator;

/**
 *
 * @author Leonardo
 */
public class ExecuteProgramDecoratorTest {
    
    public ExecuteProgramDecoratorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testExecuteAction() throws FileNotFoundException, IOException, InterruptedException {
       System.out.println("executeAction");
       File program = new File ("greeting.exe");
        
        String arguments =  "testing";
        BasicAction action = new BasicAction();
        ExecuteProgramDecorator instance = new ExecuteProgramDecorator(program, arguments, action);
        instance.executeAction();
        File output = new File("filename.txt");
        
        //without sleep the file reader can't find output file in time
        sleep(100);
        
        String expected = "Hello " + arguments +"!";
        String result= "";
        
        try(BufferedReader br = new BufferedReader(new FileReader(output))) {
        for(String line; (line = br.readLine()) != null; ) {
        result += line;
    }
        }
        assertEquals(expected, result);
       output.delete();
    }

    @Test
    public void testToString() throws IOException {
        System.out.println("toString");
        File program = new File ("greeting.exe");
        
        String arguments =  "testing";
        BasicAction action = new BasicAction();
        ExecuteProgramDecorator instance = new ExecuteProgramDecorator(program, arguments, action);
        
        String expResult = "Execute program: " + program.toString() + " with arguments: " + arguments + " ";
        
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }
    
}
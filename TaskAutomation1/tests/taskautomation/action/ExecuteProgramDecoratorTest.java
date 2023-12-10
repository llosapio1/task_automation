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
import org.junit.Test;
import static org.junit.Assert.*;
import taskautomation.azioni.BasicAction;
import taskautomation.azioni.ExecuteProgramDecorator;

/**
 *
 * @author Leonardo
 */
public class ExecuteProgramDecoratorTest {

    @Test
    public void testExecuteAction() throws FileNotFoundException, IOException, InterruptedException {
       System.out.println("executeAction");
       
       //get test application from this project's folder
       File program = new File ("greetings.exe");
        
        String arguments =  "testing";
        
        BasicAction action = new BasicAction();
        ExecuteProgramDecorator instance = new ExecuteProgramDecorator(program, arguments, action);
        instance.executeAction();  //execute test application with arguments
        
        //this file is created by test application and used to store its output
        File output = new File("filename.txt");
        
        //sleep to wait for test application to complete its execution
        sleep(500);
        
        String expected = "Hello " + arguments +"!";
        
        //read output file created by test application to make sure output is as expected
        String result= "";
        try(BufferedReader br = new BufferedReader(new FileReader(output))) {
        for(String line; (line = br.readLine()) != null; ) {
        result += line;
    }
        }
        
        //if output is as expected, the test application has been executed correctly
        assertEquals(expected, result);
        
        //delete test application's output file
       output.delete();
    }

    @Test
    public void testToString() throws IOException {
        System.out.println("toString");
        
        //get test application file and arguments
        File program = new File ("greetings.exe");
        String arguments =  "testing";
        
        BasicAction action = new BasicAction();
        ExecuteProgramDecorator instance = new ExecuteProgramDecorator(program, arguments, action);
        
        String expResult = "Execute program: " + program.toString() + " with arguments: " + arguments + " ";
        
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }
    
}

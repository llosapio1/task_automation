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
import org.junit.Test;
import static org.junit.Assert.*;
import taskautomation.azioni.AppendStringToFileDecorator;
import taskautomation.azioni.BasicAction;

/**
 *
 * @author Leonardo
 */
public class AppendStringToFileDecoratorTest {
   
    @Test
    public void testExecuteAction() throws FileNotFoundException, IOException {
        System.out.println("executeAction");
        //create file and string to append
        File selectedFile = new File("stringappendtest.txt");
        selectedFile.createNewFile();
        String expectedString = "testing";
        
        BasicAction action = new BasicAction();
        AppendStringToFileDecorator instance = new AppendStringToFileDecorator(selectedFile, expectedString, action);
        instance.executeAction(); //append string to file
        
        //read file to check if string has been successfully appended
        String result= "";
        try(BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
        for(String line; (line = br.readLine()) != null; ) {
        result += line;
    }
        }
        
        assertEquals(result, expectedString, result);
        
        //delete file used for testing
        selectedFile.delete();
   
}
        
    @Test
    public void testToString() throws IOException {
        System.out.println("toString");
        
        //create file and string for decorator's constructor
        String string = "testing";
        File file = new File ("appendStringToStringTest.txt");
        file.createNewFile();
        
        String expected = "Append string: " + string + " to file: " + file.toString() + "\n";
        BasicAction action = new BasicAction();
        AppendStringToFileDecorator instance = new AppendStringToFileDecorator(file, string, action);
        
        String result = instance.toString();
        assertEquals(expected, result);
        
        //delete file used for testing
        file.delete();
        
        //Same as above
        string = "testing 123";
        file = new File ("appendStringToStringTest2.txt");
        file.createNewFile();
        expected = "Append string: " + string + " to file: " + file.toString() + "\n";
        
        AppendStringToFileDecorator instance2 = new AppendStringToFileDecorator(file, string, action);
        result = instance2.toString();
        assertEquals(expected, result);
        file.delete();
        
    }
    
}

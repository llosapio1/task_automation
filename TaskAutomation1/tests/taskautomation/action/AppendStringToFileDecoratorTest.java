/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package taskautomation.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import taskautomation.azioni.Action;
import taskautomation.azioni.AppendStringToFileDecorator;
import taskautomation.azioni.BasicAction;

/**
 *
 * @author Leonardo
 */
public class AppendStringToFileDecoratorTest {
    
    public AppendStringToFileDecoratorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @Before
    public void setUp() {
    }
    
   
    @Test
    public void testExecuteAction() throws FileNotFoundException, IOException {
        System.out.println("executeAction");
        File selectedFile = new File("stringappendtest.txt");
        String expectedString = "testing";
        BasicAction action = new BasicAction();
        AppendStringToFileDecorator instance = new AppendStringToFileDecorator(selectedFile, expectedString, action);
        instance.executeAction();
        String result= "";
        try(BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
        for(String line; (line = br.readLine()) != null; ) {
        result += line;
    }
        }
        assertEquals(result, expectedString, result);
        
        selectedFile.delete();
        
   
}
        
    @Test
    public void testToString() throws IOException {
        System.out.println("toString");
        
        String string = "testing";
        File file = new File ("appendStringToStringTest.txt");
        file.createNewFile();
        String expected = "Append string: " + string + " to file: " + file.toString() +" ";
        BasicAction action = new BasicAction();
        AppendStringToFileDecorator instance = new AppendStringToFileDecorator(file, string, action);
        String result = instance.toString();
        assertEquals(expected, result);
        file.delete();
        
        
        string = "testing 123";
        file = new File ("appendStringToStringTest2.txt");
        file.createNewFile();
        expected = "Append string: " + string + " to file: " + file.toString() +" ";
        
        AppendStringToFileDecorator instance2 = new AppendStringToFileDecorator(file, string, action);
        result = instance2.toString();
        assertEquals(expected, result);
        file.delete();
        
        
    }
    
}

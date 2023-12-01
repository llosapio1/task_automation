/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package taskautomation.action;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import taskautomation.azioni.BasicAction;
import taskautomation.azioni.DeleteFileDecorator;

/**
 *
 * @author Leonardo
 */
public class DeleteFileDecoratorTest {
    
    public DeleteFileDecoratorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testExecuteAction() throws IOException {
        System.out.println("executeAction");
        File file = new File ("deleteFileTest.txt");
        file.createNewFile();
       
       
        BasicAction action = new BasicAction();
        DeleteFileDecorator instance = new DeleteFileDecorator(file, action);
        instance.executeAction();
        
        assertFalse(file.exists());
        
        
    }

    @Test
    public void testToString() throws IOException {
        System.out.println("toString");
      
        File file = new File ("deleteFileTest.txt");
        file.createNewFile();
       
        String expected =  "Delete file: " + file.toString();
        BasicAction action = new BasicAction();
        DeleteFileDecorator instance = new DeleteFileDecorator(file, action);
        String result = instance.toString();
        assertEquals(expected, result);
        file.delete();
        
        File file2 = new File ("deleteFileTest2.txt");
        file2.createNewFile();
       
        expected =  "Delete file: " + file2.toString();
        
        DeleteFileDecorator instance2 = new DeleteFileDecorator(file2, action);
        result = instance2.toString();
        assertEquals(expected, result);
        file2.delete();
    }
    
}

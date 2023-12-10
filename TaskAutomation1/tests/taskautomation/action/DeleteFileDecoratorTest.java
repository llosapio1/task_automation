/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package taskautomation.action;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import static org.junit.Assert.*;
import taskautomation.azioni.BasicAction;
import taskautomation.azioni.DeleteFileDecorator;

/**
 *
 * @author Leonardo
 */
public class DeleteFileDecoratorTest {

    @Test
    public void testExecuteAction() throws IOException {
        System.out.println("executeAction");
        
        //create new file
        File file = new File ("deleteFileTest.txt");
        file.createNewFile();
       
        BasicAction action = new BasicAction();
        DeleteFileDecorator instance = new DeleteFileDecorator(file, action);
        instance.executeAction(); //delete file
        
        //check that file doesn't exist anymore
        assertFalse(file.exists());
        
    }

    @Test
    public void testToString() throws IOException {
        System.out.println("toString");
      
        //create new file to use in decorator's constructor
        File file = new File ("deleteFileTest.txt");
        file.createNewFile();
       
        String expected =  "Delete file: " + file.toString() +"\n";
        BasicAction action = new BasicAction();
        DeleteFileDecorator instance = new DeleteFileDecorator(file, action);
        String result = instance.toString();
        assertEquals(expected, result);
        
        //delete newly created file
        file.delete();
        
        //same as above
        File file2 = new File ("deleteFileTest2.txt");
        file2.createNewFile();
       
        expected =  "Delete file: " + file2.toString() +"\n";
        
        DeleteFileDecorator instance2 = new DeleteFileDecorator(file2, action);
        result = instance2.toString();
        assertEquals(expected, result);
        file2.delete();
    }
    
}

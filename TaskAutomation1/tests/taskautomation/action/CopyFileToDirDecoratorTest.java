/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package taskautomation.action;

import java.io.File;
import java.io.IOException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import taskautomation.azioni.BasicAction;
import taskautomation.azioni.CopyFileToDirDecorator;

/**
 *
 * @author Leonardo
 */
public class CopyFileToDirDecoratorTest {
    
    public CopyFileToDirDecoratorTest() {
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
        File selectedFile = new File("copyFileTest.txt");
        selectedFile.createNewFile();
        File dir = new File("copyFileTestDir");
        dir.mkdir();
        BasicAction action = new BasicAction();
        CopyFileToDirDecorator instance = new CopyFileToDirDecorator(selectedFile, dir, action);
        instance.executeAction();
        File[] filesInDir = dir.listFiles();
       
        assertEquals(filesInDir[0].getName(), selectedFile.getName(), filesInDir[0].getName());
        selectedFile.delete();
        
        dir.delete();
    }

    @Test
    public void testToString() throws IOException {
        System.out.println("toString");
        
        File file = new File ("copyFileTest.txt");
        file.createNewFile();
        File dir = new File("copyFileTestDir");
        dir.mkdir();
        
        String expected = "Copy file: " + file.toString() + " to directory: " + dir.toString() + " ";
        BasicAction action = new BasicAction();
        CopyFileToDirDecorator instance = new CopyFileToDirDecorator(file, dir, action);
        String result = instance.toString();
        assertEquals(expected, result);
        file.delete();
        File[] files = dir.listFiles();
        for(File f : files){
            f.delete();
        }
        dir.delete();
        
        
        File file2 = new File ("copyFileTest2.txt");
        file2.createNewFile();
        dir = new File("copyFileTest2Dir");
        dir.mkdir();
        expected = "Copy file: " + file2.toString() + " to directory: " + dir.toString() + " ";
        
        CopyFileToDirDecorator instance2 = new CopyFileToDirDecorator(file2, dir, action);
        
        result = instance2.toString();
        assertEquals(expected, result);
        file2.delete();
        File[] files2 = dir.listFiles();
        for(File f : files){
            f.delete();
        }
        dir.delete();
        
    }
   
}

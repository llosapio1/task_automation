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
import taskautomation.azioni.MoveFileToDirDecorator;

/**
 *
 * @author Leonardo
 */
public class MoveFileToDirDecoratorTest {
    
    public MoveFileToDirDecoratorTest() {
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
        File selectedFile = new File("moveFileTest.txt");
        selectedFile.createNewFile();
        File dir = new File("moveFileTestDir");
        dir.mkdir();
        BasicAction action = new BasicAction();
        MoveFileToDirDecorator instance = new MoveFileToDirDecorator(selectedFile, dir, action);
        instance.executeAction();
        File[] filesInDir = dir.listFiles();
       
        assertEquals(filesInDir[0].getName(), selectedFile.getName(), filesInDir[0].getName());
        selectedFile.delete();
        
        for(File f : filesInDir){
        f.delete();
    }
        dir.delete();
    }

    @Test
    public void testToString() throws IOException {
        System.out.println("toString");
        
        String string = "testing";
        File file = new File ("moveFileTest.txt");
        file.createNewFile();
        File dir = new File("moveFileTestDir");
        dir.mkdir();
        
        String expected = "Move file: " + file.toString() + " to directory: " + dir.toString() + " ";
        BasicAction action = new BasicAction();
        MoveFileToDirDecorator instance = new MoveFileToDirDecorator(file, dir, action);
        String result = instance.toString();
        assertEquals(expected, result);
        file.delete();
        
        File[] files = dir.listFiles();
        for(File f : files){
            f.delete();
        }
        dir.delete();
        
        
        string = "testing 123";
        File file2 = new File ("moveFileTest2.txt");
        file2.createNewFile();
        dir = new File("moveFileTest2Dir");
        dir.mkdir();
        expected = "Move file: " + file.toString() + " to directory: " + dir.toString() + " ";
        
        MoveFileToDirDecorator instance2 = new MoveFileToDirDecorator(file, dir, action);
        
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

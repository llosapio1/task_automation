/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package taskautomation.trigger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leonardo
 */
public class FileExistsDecoratorTest {
    
    public FileExistsDecoratorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testVerifyTrigger() throws IOException {
        
        String dir = "fileExistsDir";
        File directory = new File(dir);
        directory.mkdir();
        
        String fileName = "fileExistsTest.txt";
        
        Path path = directory.toPath().resolve(new File(fileName).getName());
        File fileInDir = new File(path.toString());
        fileInDir.createNewFile();
        
        Trigger decoratedTrigger = new BasicTrigger();
        FileExistsDecorator instance = new FileExistsDecorator(fileName, directory, decoratedTrigger);
  
        boolean expResult1 = true;
        boolean result1 = instance.verifyTrigger();
        assertEquals(expResult1, result1);
        fileInDir.delete();
       
        
        String fileName2 = "test.txt";
        FileExistsDecorator instance2 = new FileExistsDecorator (fileName2, directory, decoratedTrigger);
        boolean expResult2 = false;
        boolean result2 = instance2.verifyTrigger();
        assertEquals(expResult2, result2);
        
         directory.delete();
    }

    @Test
    public void testToString() {
       System.out.println("toString");
       String fileName = "test.txt";
       File dir = new File("testDir");
        Trigger decoratedTrigger = new BasicTrigger();
        FileExistsDecorator instance = new FileExistsDecorator(fileName, dir, decoratedTrigger);
        String expResult = "File " + "\"" +fileName + "\"" + "exists in directory: " +"\""+ dir.toString() + "\"\n";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        fileName = "test2.txt";
        dir = new File("testDir2");
        FileExistsDecorator instance2 = new FileExistsDecorator(fileName, dir, decoratedTrigger);
        expResult = "File " + "\"" +fileName + "\"" + "exists in directory: " +"\""+ dir.toString() + "\"\n";
        result = instance2.toString();
        assertEquals(expResult, result);
    }
    
}
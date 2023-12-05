/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package taskautomation.trigger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leonardo
 */
public class FileSizeIsGreaterDecoratorTest {
    
    public FileSizeIsGreaterDecoratorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testVerifyTrigger() throws FileNotFoundException, IOException {
        System.out.println("verifyTrigger");
        long expFileSize = 1024*1024; 
        String fileName = "sizeGreaterTest.txt";
        RandomAccessFile f = new RandomAccessFile(fileName, "rw");
        f.setLength(expFileSize);
        File file = new File(fileName);
        
        Trigger decoratedTrigger = new BasicTrigger();
        FileSizeIsGreaterDecorator instance = new FileSizeIsGreaterDecorator(file, expFileSize/1024-10, decoratedTrigger);
        boolean expResult = true;
        boolean result = instance.verifyTrigger();
        assertEquals(expResult, result);
        
        FileSizeIsGreaterDecorator instance2 = new FileSizeIsGreaterDecorator(file, expFileSize/1024+10, decoratedTrigger);
        expResult = false;
        result = instance2.verifyTrigger();
        assertEquals(expResult, result);
        f.close();
        file.delete();
        
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        File file = new File("fileSizeGreater1.txt");
        long size = 10000;
        Trigger decoratedTrigger = new BasicTrigger();
        FileSizeIsGreaterDecorator instance = new FileSizeIsGreaterDecorator(file, size, decoratedTrigger);
        String expResult = "File " + "\"" +file.toString() + "\"" + "size is greater then " +size +"\n";
        String result = instance.toString();
        assertEquals(expResult, result);
        file.delete();
        
        File file2 = new File("fileSizeGreater2.txt");
        size = 100;
        FileSizeIsGreaterDecorator instance2 = new FileSizeIsGreaterDecorator(file2, size, decoratedTrigger);
        expResult = "File " + "\"" +file2.toString() + "\"" + "size is greater then " +size +"\n";
        
        result = instance2.toString();
        assertEquals(expResult, result);
        file2.delete();
    }
    
}

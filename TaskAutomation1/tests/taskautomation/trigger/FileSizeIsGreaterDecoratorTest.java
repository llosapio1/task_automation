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
        
        long expFileSize = 1024*1024;  //size of the file to create
        String fileName = "sizeGreaterTest.txt"; //name of the file to create
        
        //create file with name and size
        RandomAccessFile f = new RandomAccessFile(fileName, "rw"); 
        f.setLength(expFileSize);
        File file = new File(fileName);
        
        FileSizeIsGreaterTrigger instance = new FileSizeIsGreaterTrigger(file, expFileSize/1024-10);
        boolean expResult = true;
        boolean result = instance.verifyTrigger(); //check if file size is greater than expFileSize converted to kbytes -10
        assertEquals(expResult, result);
        
        FileSizeIsGreaterTrigger instance2 = new FileSizeIsGreaterTrigger(file, expFileSize/1024+10);
        expResult = false;
        result = instance2.verifyTrigger(); //check if file size is greater than expFileSize converted to kbytes +10
        assertEquals(expResult, result);
        
        //delete test file
        f.close();
        file.delete();
        
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        
        //use file and size for decorator's constructor
        File file = new File("fileSizeGreater1.txt");
        long size = 10000;
        FileSizeIsGreaterTrigger instance = new FileSizeIsGreaterTrigger(file, size);
        String expResult = "File " + "\"" +file.toString() + "\"" + "size is greater then " +size ;
        String result = instance.toString();
        assertEquals(expResult, result);
        //delete file
        file.delete();
        
        //same as above
        File file2 = new File("fileSizeGreater2.txt");
        size = 100;
        FileSizeIsGreaterTrigger instance2 = new FileSizeIsGreaterTrigger(file2, size);
        expResult = "File " + "\"" +file2.toString() + "\"" + "size is greater then " +size ;
        
        result = instance2.toString();
        assertEquals(expResult, result);
        file2.delete();
    }
    
}

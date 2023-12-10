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
public class FileExistsTriggerTest {
    
    public FileExistsTriggerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testVerifyTrigger() throws IOException {
        
        //create directory
        String dir = "fileExistsDir";
        File directory = new File(dir);
        directory.mkdir();
        
        //create file in directory
        String fileName = "fileExistsTest.txt";
        Path path = directory.toPath().resolve(new File(fileName).getName());
        File fileInDir = new File(path.toString());
        fileInDir.createNewFile();

        FileExistsTrigger instance = new FileExistsTrigger(fileName, directory);
  
        boolean expResult1 = true;
        boolean result1 = instance.verifyTrigger(); //check if file exists in directory
        assertEquals(expResult1, result1);
        
        //delete file from directory
        fileInDir.delete();
       
        //get name of another file
        String fileName2 = "test.txt";
        FileExistsTrigger instance2 = new FileExistsTrigger (fileName2, directory);
        boolean expResult2 = false;
        boolean result2 = instance2.verifyTrigger(); //check that this second file doesn't exist in directory
        assertEquals(expResult2, result2);
        
        //Delete test directory
         directory.delete();
    }

    @Test
    public void testToString() {
       System.out.println("toString");
       
       //use file name and directory for decorator's constructor
       String fileName = "test.txt";
       File dir = new File("testDir");
        FileExistsTrigger instance = new FileExistsTrigger(fileName, dir);
        String expResult = "File " + "\"" +fileName + "\"" + "exists in directory: " +"\""+ dir.toString() + "\"";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        //Same as above
        fileName = "test2.txt";
        dir = new File("testDir2");
        FileExistsTrigger instance2 = new FileExistsTrigger(fileName, dir);
        expResult = "File " + "\"" +fileName + "\"" + "exists in directory: " +"\""+ dir.toString() + "\"";
        result = instance2.toString();
        assertEquals(expResult, result);
    }
    
}

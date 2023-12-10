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
import taskautomation.azioni.CopyFileToDirDecorator;

/**
 *
 * @author Leonardo
 */
public class CopyFileToDirDecoratorTest {

    @Test
    public void testExecuteAction() throws IOException {
        System.out.println("executeAction");
        
        //create file and directory
        File selectedFile = new File("copyFileTest.txt");
        selectedFile.createNewFile();
        File dir = new File("copyFileTestDir");
        dir.mkdir();
        
        BasicAction action = new BasicAction();
        CopyFileToDirDecorator instance = new CopyFileToDirDecorator(selectedFile, dir, action);
        instance.executeAction();  //file is copied to directory
        
        //get list of all files in directory, the directory should contain only the one file we just copied
        File[] filesInDir = dir.listFiles();
       
        //check if directory contains the file to verify that the copy operation succeded
        assertEquals(filesInDir[0].getName(), selectedFile.getName(), filesInDir[0].getName());
        
        //Delete file and directory used for testing
        selectedFile.delete();
        dir.delete();
    }

    @Test
    public void testToString() throws IOException {
        System.out.println("toString");
        
        //create file and directory to use in decorator's constructor
        File file = new File ("copyFileTest.txt");
        file.createNewFile();
        File dir = new File("copyFileTestDir");
        dir.mkdir();
        
        String expected = "Copy file: " + file.toString() + " to directory: " + dir.toString() + "\n";
        BasicAction action = new BasicAction();
        CopyFileToDirDecorator instance = new CopyFileToDirDecorator(file, dir, action);
        String result = instance.toString();
        assertEquals(expected, result);
        
        //delete all files in directory (otherwise you can't delete the directory)
        File[] files = dir.listFiles();
        for(File f : files){
            f.delete();
        }
        dir.delete();  //delete directory
        file.delete();
        
        
        //same as above
        File file2 = new File ("copyFileTest2.txt");
        file2.createNewFile();
        dir = new File("copyFileTest2Dir");
        dir.mkdir();
        expected = "Copy file: " + file2.toString() + " to directory: " + dir.toString() + "\n";
        
        CopyFileToDirDecorator instance2 = new CopyFileToDirDecorator(file2, dir, action);
        
        result = instance2.toString();
        assertEquals(expected, result);
        
        File[] files2 = dir.listFiles();
        for(File f : files2){
            f.delete();
        }
        dir.delete();
        file2.delete();
    }
   
}

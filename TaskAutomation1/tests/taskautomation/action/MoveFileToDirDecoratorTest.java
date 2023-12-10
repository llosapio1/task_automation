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
import taskautomation.azioni.MoveFileToDirDecorator;

/**
 *
 * @author Leonardo
 */
public class MoveFileToDirDecoratorTest {

    @Test
    public void testExecuteAction() throws IOException {
        System.out.println("executeAction");
        
        //create file and directory
        File selectedFile = new File("moveFileTest.txt");
        selectedFile.createNewFile();
        File dir = new File("moveFileTestDir");
        dir.mkdir();
        
        BasicAction action = new BasicAction();
        MoveFileToDirDecorator instance = new MoveFileToDirDecorator(selectedFile, dir, action);
        instance.executeAction();  //move file to directory
        
        //get list of all files in directory, it should contain only the file we just moved
        File[] filesInDir = dir.listFiles();
       
        //check if directory contains the file
        assertEquals(filesInDir[0].getName(), selectedFile.getName(), filesInDir[0].getName());
        
      //delete all files in directory, otherwise we can't delete the directory
        for(File f : filesInDir){
        f.delete();
    }
        dir.delete();
    }

    @Test
    public void testToString() throws IOException {  
        System.out.println("toString");
        //create file and directory to use for decorator's constructor
        String string = "testing";
        File file = new File ("moveFileTest.txt");
        file.createNewFile();
        File dir = new File("moveFileTestDir");
        dir.mkdir();
        
        String expected = "Move file: " + "\"" + file.toString()+ "\"" + " to directory: " + "\"" +dir.toString()+ "\"" + "\n";
        BasicAction action = new BasicAction();
        MoveFileToDirDecorator instance = new MoveFileToDirDecorator(file, dir, action);
        String result = instance.toString();
        assertEquals(expected, result);
        
        //delete all files in directory before deleting directory
        File[] files = dir.listFiles();
        for(File f : files){
            f.delete();
        }
        dir.delete();
        
        
        //Same as above
        string = "testing 123";
        File file2 = new File ("moveFileTest2.txt");
        file2.createNewFile();
        dir = new File("moveFileTest2Dir");
        dir.mkdir();
        String expected2 = "Move file: " + "\"" + file2.toString()+ "\"" + " to directory: " + "\"" +dir.toString()+ "\"" + "\n";
        
        MoveFileToDirDecorator instance2 = new MoveFileToDirDecorator(file2, dir, action);
        
        String result2 = instance2.toString();
        assertEquals(expected2, result2);
        
        File[] files2 = dir.listFiles();
        for(File f : files2){
            f.delete();
        }
        dir.delete();
    }
    
}

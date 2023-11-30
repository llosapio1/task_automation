/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.azioni;

import java.io.File;

/**
 *
 * @author Leonardo
 */
public class DeleteFileDecorator extends ActionDecorator{
    File selectedFile;
    public DeleteFileDecorator(File selectedFile, Action BasicAction) {
        super(BasicAction);
        this.selectedFile = selectedFile;
    }
    
    @Override
    public void executeAction(){
        selectedFile.delete();
    }
    
}

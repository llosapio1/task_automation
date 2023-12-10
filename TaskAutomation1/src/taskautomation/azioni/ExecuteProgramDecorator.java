/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.azioni;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TextInputDialog;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Leonardo
 */
public class ExecuteProgramDecorator extends ActionDecorator implements Serializable{
    
    private File program;
    private String arguments;
    
    //constructor used in test class
    public ExecuteProgramDecorator (File program, String arguments, Action basicAction){
        super(basicAction);
        this.program = program;
        this.arguments = arguments;
    }
    
    //constructor used in application
    public ExecuteProgramDecorator(Action basicAction){
        super(basicAction);
        //get exe file to execute   
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select program to execute");
            
        //allow the selection of exe files only
        //FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Executable files (*.exe)", "*.exe");
        //fileChooser.getExtensionFilters().add(filter);

        this.program = fileChooser.showOpenDialog(new Stage());
           
        //get arguments to use to execute external program
        // Mostra la finestra di dialogo per l'input
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Input Dialog");
        dialog.setHeaderText(null);
        dialog.setContentText("Type the arguments to use:");

        // Ottieni la risposta dall'utente
        dialog.showAndWait().ifPresent(result -> arguments = result);
    }
    
     @Override
    public void executeAction() {
        // Definisci il file di output
        File outputFile = new File("output.txt");

        //execute selected program with selected arguments
        try (FileWriter fileWriter = new FileWriter(outputFile)) {
            // Create the process with ProcessBuilder
            ProcessBuilder processBuilder = new ProcessBuilder(program.getAbsolutePath(), arguments);

            // Reindirizza l'output del processo al file
            processBuilder.redirectOutput(outputFile);
            processBuilder.redirectError(outputFile);

            // Esegui il processo
            Process process = processBuilder.start();

            // Attendere che il processo termini
            int exitCode = process.waitFor();

            // Puoi gestire exitCode come desideri, ad esempio, mostrando un messaggio all'utente
            System.out.println("Program exited with code: " + exitCode);

        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ExecuteProgramDecorator.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     @Override
    public String toString(){
         return "Execute program: " + program.toString() + " with arguments: " + arguments + " ";
    }
    
}


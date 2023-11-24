/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.azioni;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Alejandro
 */
public class PlayAudioAction extends ActionDecorator{
    private Clip clip;
    
    public PlayAudioAction(File file, Action actionDecorated) {
        super(actionDecorated); 
        try {      
            clip=AudioSystem.getClip();
            InputStream is=new FileInputStream(file);
            AudioFileFormat aff=AudioSystem.getAudioFileFormat(file);
            AudioInputStream ais=new AudioInputStream(is,
                        aff.getFormat(),
                        aff.getByteLength());
            clip.open(ais);

        } catch (LineUnavailableException exc) {
            throw new RuntimeException("Sorry. Cannot play audio files.");
        } catch (UnsupportedAudioFileException exc) {
            throw new RuntimeException("Unsupported file format for: "+ file);
        } catch (FileNotFoundException exc) {
            throw new RuntimeException("File not found: "+ file);
        } catch (IOException exc) {
            throw new RuntimeException("IOException: "+exc);
        }
    }

    @Override
    public void executedAction() {
        clip.start();
        super.executedAction(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
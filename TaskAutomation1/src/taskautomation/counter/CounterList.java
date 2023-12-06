/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.counter;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import taskautomation.rule.RuleList;

/**
 *
 * @author alessandro
 */
public class CounterList implements Serializable{
    
    private static CounterList instance = null;
    private static ArrayList<Counter> countersList = new ArrayList<>();

    // è stato applicato il pattern Singleton
    public CounterList() {
        try {
            countersList = loadCountersFromFile();
            if (countersList == null)
                countersList = new ArrayList<>();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(RuleList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static CounterList getCounterList() {
        if (instance == null)
            instance = new CounterList();
        
        return instance;
    }
    
    public boolean addCounter(Counter counter) {
        boolean result = countersList.add(counter);
        saveCountersToFile();
        return result;
    }

    public ArrayList<Counter> get() {
        return countersList;
    }
    
    private ArrayList<Counter> loadCountersFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("counters.ser"))) {
            ArrayList<Counter> loadedCounters = (ArrayList<Counter>) ois.readObject();
            return loadedCounters;
        } catch (FileNotFoundException | InvalidClassException | EOFException e) {
            // Se il file non esiste o è vuoto, restituisci una lista vuota
            return new ArrayList<Counter>();
        }
        
    }
    
    private void saveCountersToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("counters.ser"))) {
            oos.writeObject(countersList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}

package taskautomation.rule;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import taskautomation.counter.CounterList;

/**
 *
 * @author alessandro
 */
public class RuleList implements Serializable{
    
    private static RuleList instance = null;
    private static LinkedList<Rule> ruleList;
    
    // è stato applicato il pattern Singleton
    private RuleList() {
        try {
            ruleList = loadRulesFromFile();
            if (ruleList == null)
                ruleList = new LinkedList<>();
        } catch (IOException | ClassNotFoundException ex) {
            // Registra l'errore utilizzando un logger
            Logger.getLogger(RuleList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean addRule(Rule rule){
        boolean result = ruleList.add(rule);
        // Salva le regole nel file dopo l'aggiunta di una nuova regola
        saveRulesToFile();
        return result;
    }
    
    public void checkRules(){
        for (Rule rule : ruleList){
            rule.checkRule();
        }
    }
    
    public static RuleList getRuleList() {
        if (instance == null)
            instance = new RuleList();
        
        return instance;
    }
    
    public LinkedList<Rule> get(){
        return ruleList;
    }
    
    public boolean removeRule(Rule rule){
        boolean result = ruleList.remove(rule);
        // Salva le regole nel file dopo la rimozione di una regola
        saveRulesToFile();
        return result;
    }
    
    private LinkedList<Rule> loadRulesFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("rules.ser"))) {
            LinkedList<Rule> loadedRules = (LinkedList<Rule>) ois.readObject();
            return loadedRules;
        } catch (FileNotFoundException | InvalidClassException | EOFException e) {
            // Se il file non esiste o è vuoto, restituisci una lista vuota
            return new LinkedList<>();
        }
        
    }
    
    private void saveRulesToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("rules.ser"))) {
            oos.writeObject(ruleList);
        } catch (IOException e) {
            // Registra l'errore utilizzando un logger
            Logger.getLogger(CounterList.class.getName()).log(Level.SEVERE, "Errore durante il salvataggio delle regole su file", e);
        }
    }
    
}

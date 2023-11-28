/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.rule;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author alessandro
 */
public class RuleList implements Serializable{
    
    private static RuleList instance = null;
    private static LinkedList<Rule> ruleList;

    private RuleList() {
        ruleList = new LinkedList<>();
        // Carica le regole dal file all'avvio dell'applicazione
        loadRulesFromFile();
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
    
    private void loadRulesFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("rules.ser"))) {
            Object obj = ois.readObject();
            if (obj instanceof LinkedList) {
                ruleList = (LinkedList<Rule>) obj;
            }
        } catch (IOException | ClassNotFoundException e) {
            // Se il file non esiste o si verifica un problema nel caricamento, ignora
        }
    }
    
    private void saveRulesToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("rules.ser"))) {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}

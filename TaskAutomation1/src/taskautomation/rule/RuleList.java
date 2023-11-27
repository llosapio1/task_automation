/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.rule;

import java.util.LinkedList;

/**
 *
 * @author alessandro
 */
public class RuleList {
    
    private static RuleList instance = null;
    private static LinkedList<Rule> ruleList;

    private RuleList() {
        ruleList = new LinkedList<>();
    }
    
    public boolean addRule(Rule rule){
        return ruleList.add(rule);
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
        return ruleList.remove(rule);
    }
    
}

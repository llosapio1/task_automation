/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation;

import java.util.LinkedList;

/**
 *
 * @author alessandro
 */
public class RuleList {
    
    private LinkedList<Rule> ruleList;

    public RuleList() {
        this.ruleList = new LinkedList<>();
    }
    
    public boolean addRule(Rule rule){
        return ruleList.add(rule);
    }
    
    public void checkRules(){
        for (Rule rule : ruleList){
            rule.checkRule();
        }
    }
    
}

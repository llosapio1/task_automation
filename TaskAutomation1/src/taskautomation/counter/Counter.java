/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.counter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alessandro
 */
public class Counter implements Serializable{
    
    private String name;
    private int value;

    public Counter(String name, int value) {
        this.name = name;
        this.value = value;
        CounterList.getCounterList().addCounter(this);
    }

    public String getName() {
        return name;
    }
    
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package taskautomation;

/**
 *
 * @author alessandro
 * @param <T>
 */
public interface Factory<T> {
    
    Object create(String selectedType, T object);
}

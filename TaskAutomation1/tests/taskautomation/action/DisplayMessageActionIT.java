/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.action;

/**
 *
 * @author Alejandro
 */


import static junit.framework.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import taskautomation.azioni.BasicAction;
import taskautomation.azioni.DisplayMessageAction;


/**
 *
 * @author alessandro
 */
public class DisplayMessageActionIT{
    
    private DisplayMessageAction instance;
    
    public DisplayMessageActionIT() {
    }
    
    @Before
    public void setUp() {
        // Crea un'istanza di TimeOfDayDecorator con valori di esempio
        instance = new DisplayMessageAction("Ciao mondo!" ,new BasicAction());
    }

    /**
     * Test of getTimeOfDay method, of class TimeOfDayDecorator.
     */
    @Test
    public void testGetMessage() {
        String expResult = "Ciao mondo!";
        String result = instance.getMessage();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTimeOfDay method, of class TimeOfDayDecorator.
     */
    @Test
    public void testSetMessage() {
        String expResult = "Nuovo messaggio inserito";
        instance.setMessage("Nuovo messaggio inserito");
        assertEquals(expResult, instance.getMessage());
    }

    /**
     * Test of verifyTrigger method, of class TimeOfDayDecorator.
     */


    
    @Test
    public void testExecuteAction() {
        
        // Creo una BasicAction
        BasicAction action = new BasicAction();
        
        String message = "Test DisplayMessageAction superato";
        
        // Decoro la BasicAction
        DisplayMessageAction decoratedAction = new DisplayMessageAction(message, action);
        
        //Chiamo in esecuzione il metodo executeAction
        decoratedAction.executeAction();
        
    }
    
}
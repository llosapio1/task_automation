package taskautomation.action;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import static junit.framework.Assert.assertTrue;
import org.junit.Test;
import taskautomation.ActionFactory;
import taskautomation.azioni.Action;
import taskautomation.azioni.DisplayMessageAction;


/**
 *
 * @author alessandro
 */
public class ActionFactoryIT{
    
    private ActionFactory instance;
    
    public ActionFactoryIT() {

    }
    
    /**
     * Test of create method, of class TriggerFactory.
     */
    @Test
    public void testCreateWithValidType() {  
        String ActionType = "DisplayMessageAction";
        new ActionFactory().create(ActionType);
        Action result = new ActionFactory().create(ActionType);
        assertTrue(result instanceof DisplayMessageAction);
        
    }
    
    @Test
    public void testCreateWithInvalidType() {
        String ActionType = "InvalidType";
        Action result = new ActionFactory().create(ActionType);
        assertTrue(result == null);
        
    }
    
    @Test
    public void testCreateWithNullType() {
        Action result = new ActionFactory().create(null);
        assertTrue(result == null);
        
    }
    
    
    
}
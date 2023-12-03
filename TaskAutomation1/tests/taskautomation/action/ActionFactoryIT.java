package taskautomation.action;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import static junit.framework.Assert.assertTrue;
import org.junit.Test;
import taskautomation.azioni.ActionFactory;
import taskautomation.azioni.Action;
import taskautomation.azioni.BasicAction;
import taskautomation.azioni.DisplayMessageDecorator;


/**
 *
 * @author alessandro
 */
public class ActionFactoryIT{
    
    private final ActionFactory af = new ActionFactory();
    
    public ActionFactoryIT() {

    }
    
    /**
     * Test of create method, of class TriggerFactory.
     */
    @Test
    public void testCreateWithValidType() {  
        String actionType = "DisplayMessage";
        Action result = af.create(actionType);
        assertTrue(result instanceof DisplayMessageDecorator);
        
    }
    
    @Test
    public void testCreateWithInvalidType() {
        String ActionType = "InvalidType";
        Action result = af.create(ActionType);
        assertTrue(result instanceof BasicAction);
        
    }
    
    
    
    
}
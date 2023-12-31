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


/**
 *
 * @author alessandro
 */
public class ActionFactoryIT{
    
    private final ActionFactory af = new ActionFactory();
    private BasicAction ba = new BasicAction();
    
    public ActionFactoryIT() {

    }
    
    @Test
    public void testCreateWithInvalidType() {
        String ActionType = "InvalidType";
        Action result = af.create(ActionType, ba);
        assertTrue(result instanceof BasicAction);
        
    }
    
}
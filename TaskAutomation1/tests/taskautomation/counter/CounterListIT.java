/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package taskautomation.counter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author alessandro
 */
public class CounterListIT {
    
    CounterList instance;
    String name = "test";
    int value = 5;
    int newValue = 7;
    private static final String originalFilePath = "counters.ser";
    private static final String backupFilePath = "counters_backup.ser";
    
    @BeforeClass
    public static void beforeAll() {
        // Salva una copia del file di serializzazione prima dell'esecuzione dei test
        try {
            Path originalPath = Paths.get(originalFilePath);
            Path backupPath = Paths.get(backupFilePath);

            Files.copy(originalPath, backupPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Before
    public void setUp() {
        //Crea un'istanza di CounterList
        instance = CounterList.getCounterList();
        // Resettare la lista countersList nel caso contessse già dei counter
        CounterList countersList = CounterList.getCounterList();
        countersList.get().clear();
    }
    
    @After
    public void tearDown() {
        // Resettare la lista countersList
        CounterList countersList = CounterList.getCounterList();
        countersList.get().clear();
    }
    
    @AfterClass
    public static void afterAll() {
        // Ripristina il file di serializzazione alla sua versione originale
        try {
            Path originalPath = Paths.get(originalFilePath);
            Path backupPath = Paths.get(backupFilePath);
            Files.copy(backupPath, originalPath, StandardCopyOption.REPLACE_EXISTING);
            Files.deleteIfExists(backupPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test of getCounterList method, of class CounterList.
     */
    @Test
    public void testGetCounterList() {
        //Verifica che il metodo GetCounterList restituisca un oggetto di tipo CounterList
        CounterList cl = CounterList.getCounterList();
        assertNotEquals(cl, null);
        assertTrue(cl instanceof CounterList);
    }

    /**
     * Test of addCounter method, of class CounterList.
     */
    @Test
    public void testAddCounter() {
        //Verifica che la lista di counter sia inizialmente vuota
        assertTrue(instance.get().isEmpty());

        //Crea un counter e lo aggiunge alla lista
        Counter c = new Counter(name, value);
        assertTrue(instance.addCounter(c));

        //Verifica che il counter sia stato correttamente aggiunto
        assertTrue(instance.get().contains(c));

        //Prova ad aggiungere lo stesso counter di nuovo
        assertFalse(instance.addCounter(c));

        //Verifica che la lista contenga ancora solo un'istanza del counter
        assertEquals(1, instance.get().size());
        assertTrue(instance.get().contains(c));

    }

    /**
     * Test of get method, of class CounterList.
     */
    @Test
    public void testGet() {
        // Crea un counter e lo aggiunge alla lista
        Counter c = new Counter(name, value);
        assertTrue(instance.addCounter(c));

        // Verifica che la lista non sia vuota dopo l'aggiunta del counter
        assertFalse(instance.get().isEmpty());

        // Ottieni la lista e verifica che contenga il counter aggiunto
        ArrayList<Counter> counters = instance.get();
        assertTrue(instance.get().contains(c));

        // Aggiungi un altro counter alla lista
        Counter c2 = new Counter("test2", 10);
        assertTrue(instance.addCounter(c2));

        // Verifica che la lista ora contenga entrambi i counter
        counters = instance.get();
        assertTrue(counters.contains(c));
        assertTrue(counters.contains(c2));
    }

    /**
     * Test of removeCounter method, of class CounterList.
     */
    @Test
    public void testRemoveCounter() {
        //Verifica che la lista di counter sia vuota
        assertTrue(instance.get().isEmpty());
        
        //Crea un counter e lo aggiunge alla lista
        Counter c = new Counter(name, value);
        assertTrue(instance.addCounter(c));
        
        //Verifica che la lista non sia vuota e quindi il counter è stato aggiunto
        assertFalse(instance.get().isEmpty());
        assertTrue(instance.get().contains(c));
        
        //Rimuove il counter dalla lista
        instance.removeCounter(c);
        //Verifica che la lista sia vuota e quindi il counter è stato rimosso
        assertTrue(instance.get().isEmpty());
        assertFalse(instance.get().contains(c));
    }

    /**
     * Test of updateCounter method, of class CounterList.
     */
    @Test
    public void testUpdateCounter() {
        //Verifica che la lista di counter sia vuota
        assertTrue(instance.get().isEmpty());
        
        //Crea un counter e lo aggiunge alla lista
        Counter c = new Counter(name, value);
        assertTrue(instance.addCounter(c));
        
        //Verifica che la lista non sia vuota e quindi il counter è stato aggiunto
        assertFalse(instance.get().isEmpty());
        
        //Verifica che il valore del counter è uguale a quello impostato
        ArrayList<Counter> counters = instance.get();
        assertEquals(counters.get(0).getValue(), value);
        
        //Modifica il valore del counter
        instance.updateCounter(c, newValue);
        
        //Controlla che il valore del counter sia stato aggiornato
        counters = instance.get();
        assertEquals(counters.get(0).getValue(), newValue);
    }
    
}

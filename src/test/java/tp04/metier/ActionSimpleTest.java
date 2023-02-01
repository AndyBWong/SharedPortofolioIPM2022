/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tp04.metier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author andyb
 */
public class ActionSimpleTest {
    private static final String EXPECTED_LIBELLE = "Toto";

    public ActionSimpleTest() {
    }

    @Test
    public void testGetLibelleShouldPass() {
        final ActionSimple as1 = new ActionSimple(EXPECTED_LIBELLE);
        final String result = as1.getLibelle();
        
        Assertions.assertSame(EXPECTED_LIBELLE, result, "The label must be the same as the one used at creation time.");
    }
    
}

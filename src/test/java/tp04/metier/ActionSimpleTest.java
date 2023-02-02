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
    /**
     * Jour qui pour lequel une action possède un cours.
     * Antérieur à la date du jour.
     */
    private static final Jour jourExistant = new Jour(2022, 1) ;

    public ActionSimpleTest() {
    }

    @Test
    public void testGetLibelleShouldPass() {
        final ActionSimple as1 = new ActionSimple(EXPECTED_LIBELLE);
        final String result = as1.getLibelle();
        
        Assertions.assertSame(EXPECTED_LIBELLE, result, "The label must be the same as the one used at creation time.");
    }
    
    /**
     * Test permettant de vérifier qu'on récupère la bonne valeur d'une action
     * simple pour un jour donnée.
     */
    @Test
    public void testGetValJourActionSimpleShouldPass() {
        final ActionSimple as2 = new ActionSimple(EXPECTED_LIBELLE);
        final float valeurCours = 12f;
        as2.enregistrerCours(jourExistant, valeurCours);
        final float result = as2.getValeur(jourExistant);
        Assertions.assertEquals(valeurCours, result);
    }
    @Test
    public void testGetValJourActionSimpleCatchGetError(){
        final ActionSimple as3 = new ActionSimple(EXPECTED_LIBELLE);
        final float valeurCours = -1f;
        final Jour jourNonExistant = new Jour(2019, 2);
        final float result = as3.getValeur(jourNonExistant);
        Assertions.assertEquals(valeurCours, result);
    }
}

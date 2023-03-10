/*
 * Copyright 2023 andyb.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tp04.metier;
import java.util.HashMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 *
 * @author andyb
 */
public class ActionComposeeTest {
    /**
     * Jour qui pour lequel une action possède un cours.
     * Antérieur à la date du jour.
     */
    private static final Jour JOUR_EXISTANT = new Jour(2022, 12,  1) ;
    /**
     * Pourcentage pour les tests failed .
     */
    private static final float POURCENTAGE_FAILED = 200;
    /**
     *  Pourcentage pour les tests passed.
     */
    private static final float POURCENTAGE_PASS1 = 40;
    /**
     *  Pourcentage pour les tests passed.
     */
    private static final float POURCENTAGE_PASS2 = 60;
    /**
     *  Pourcentage pour les tests failed.
     */
    private static final float POURCENTAGE_FAILED1 = 70;
    /**
     * Valeur de l'action simple 1.
     */
    private static final float VALEUR_AS1 = 30;
    /**
     * Valeur de l'action simple 2.
     */
    private static final float VALEUR_AS2 = 40;
    /**
     * Constructeur de la classe de test.
     */
    public ActionComposeeTest() { }

    /**
     * Vérifie si la valeur récupérée d'une action composée est correcte.
     */
    @Test
    public void TestGetValActionCompShouldPass() {
        final ActionSimple as1 = new ActionSimple("Action1");
        final ActionSimple as2 = new ActionSimple("Action2");
        final float valeur = 10f;
        final float expectedValeur = valeur * 2;
        final int pourcentage = 50;
        final ActionComposee ac1;
        final float result;

        as1.enregistrerCours(JOUR_EXISTANT, valeur);
        as2.enregistrerCours(JOUR_EXISTANT, valeur);
        ac1 = new ActionComposee("ActionComp");
        ac1.enregistrerComp(as1, pourcentage);
        ac1.enregistrerComp(as2, pourcentage);
        result = ac1.getValeur(JOUR_EXISTANT);
        Assertions.assertEquals(expectedValeur, result);
    }
    /**
     * Verifie si la valeur récupérée d'une action composée
     * est fausse par rapport à la somme du pourcentage.
     */
    @Test
    public void TestGetValActionCompSommePourcentageShouldFail() {
        final ActionSimple as1 = new ActionSimple("Action1");
        final ActionSimple as2 = new ActionSimple("Action2");
        final float valeur = 10f;
        final float expectedValeur = valeur * 2;
        final int pourcentage = 60;
        final ActionComposee ac1;
        final float result;

        as1.enregistrerCours(JOUR_EXISTANT, valeur);
        as2.enregistrerCours(JOUR_EXISTANT, valeur);
        ac1 = new ActionComposee("ActionComp");
        ac1.enregistrerComp(as1, pourcentage);
        ac1.enregistrerComp(as2, pourcentage);
        result = ac1.getValeur(JOUR_EXISTANT);
        Assertions.assertNotEquals(expectedValeur, result);
    }

    /**
     * Verifie si la valeur récupérée d'une action composée
     * est fausse par rapport au pourcentage.
     */
    @Test
    public void TestGetValActionCompPourcentageShouldFail() {
        final ActionSimple as1 = new ActionSimple("Action1");
        final float valeur = 10f;
        final float expectedValeur = 0f;
        final int pourcentage = 101;
        final ActionComposee ac1;
        final float result;

        as1.enregistrerCours(JOUR_EXISTANT, valeur);
        ac1 = new ActionComposee("ActionComp");
        ac1.enregistrerComp(as1, pourcentage);
        result = ac1.getValeur(JOUR_EXISTANT);
        Assertions.assertEquals(expectedValeur, result);
    }
    /**
     * Test de la composition d'une action composé
     * est fausse par rapport au pourcentage.
     */
    @Test
    public void TestenregistrerCompShouldPass() {
         final ActionComposee ac1 = new ActionComposee("FranceTV");
        final ActionSimple as = new ActionSimple("France 2");
        as.enregistrerCours(JOUR_EXISTANT, VALEUR_AS1);
        final boolean result = ac1.enregistrerComp(as, POURCENTAGE_PASS1).
                equals(ac1.getComposition());
         Assertions.assertTrue(result, "The HashMap should be the same ");
    }
    /**
     * Test de la composition d'une action composé
     * est fausse par rapport au pourcentage.
     */
    @Test
    public void TestenregistrerCompShouldFail() {
        final ActionComposee ac1 = new ActionComposee("FranceTV");
        final ActionSimple as1 = new ActionSimple("France 2");
        final ActionSimple as2 = new ActionSimple("France 3");
        as1.enregistrerCours(JOUR_EXISTANT, VALEUR_AS1);
        as2.enregistrerCours(JOUR_EXISTANT, VALEUR_AS2);

        final boolean result = ac1.enregistrerComp(as2,
                POURCENTAGE_FAILED).isEmpty();
        Assertions.assertTrue(result, "The HashMap should not be empty ");
    }
    /**
     * Test de la composition d'une action composé
     * est fausse par rapport au pourcentage.
     */
    @Test
    public void TestenregistrerCompShouldPass2() {
         final ActionComposee ac1 = new ActionComposee("FranceTV");
        final ActionSimple as1 = new ActionSimple("France 2");
        final ActionSimple as2 = new ActionSimple("France 3");
        as1.enregistrerCours(JOUR_EXISTANT, VALEUR_AS1);
        ac1.enregistrerComp(as1, POURCENTAGE_PASS1);
        ac1.enregistrerComp(as2, POURCENTAGE_PASS2);
        final boolean result = ac1.getComposition().containsKey(as2);
        Assertions.assertTrue(result, "as2 should be in the Hashmap");
    }
    /**
     * Test de la composition d'une action composé
     * est fausse par rapport au pourcentage.
     */
    @Test
    public void TestenregistrerCompShouldFail2() {
        final ActionComposee ac1 = new ActionComposee("FranceTV");
        final ActionSimple as1 = new ActionSimple("France 2");
        final ActionSimple as2 = new ActionSimple("France 3");
        as1.enregistrerCours(JOUR_EXISTANT, VALEUR_AS1);
        as2.enregistrerCours(JOUR_EXISTANT, VALEUR_AS2);

        ac1.enregistrerComp(as1, POURCENTAGE_PASS1);
        ac1.enregistrerComp(as2, POURCENTAGE_FAILED1);
        final boolean result = ac1.getComposition().containsKey(as2);
        Assertions.assertFalse(result, "as2 should not be in the Hashmap");
    }
    
    /**
     * Test de la méthode valeurActuelleShouldPass.
     */
    @Test
    public final void testValeurActuelleShouldPass() {
        final ActionComposee ac1 = new ActionComposee("FranceTV");
        final ActionSimple as1 = new ActionSimple("France 2");
        final ActionSimple as2 = new ActionSimple("France 3");
        float expectedResult = VALEUR_AS1 + VALEUR_AS2;
        float result;
        as1.enregistrerCours(JOUR_EXISTANT, VALEUR_AS1);
        as2.enregistrerCours(JOUR_EXISTANT, VALEUR_AS2);

        ac1.enregistrerComp(as1, POURCENTAGE_PASS1);
        ac1.enregistrerComp(as2, POURCENTAGE_PASS2);
        result = ac1.valeurActuelle();
        Assertions.assertEquals(expectedResult, result);
    }
}

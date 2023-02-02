/*
* Copyright 2023 corin.
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
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author corin
 */
public class PortefeuilleTest {
    /**.
     * Constante de la valeur attendu
     */
    private static final float  EXPECTED_VALEUR = 20;
    /**.
     * Constante de la valeur de l'action simple
     */
    private static final float  VALEUR_AS = 10;
    /**.
     * Constante du libelle de l'as attendu
     */
    private static final String  EXPECTED_AS1 = "France2";
    /**.
     * Constante du libelle de l'as attendu
     */
    private static final String  EXPECTED_AS2 = "France3";
    /**.
     * Constante de la quantité attendu
     */
    private static final int  EXPECTED_Q1 = 2;
    /**.
     * Constante de la quantité attendu
     */
    private static final int  EXPECTED_Q2 = 5;
    /**.
     * Test de portefeuille
     */
    public PortefeuilleTest() {
    }
    @Test
    /**
     * Test de GetValeur de Portefeuille
     */
    public void testGetValeur() {
        final Portefeuille p1 = new Portefeuille();
        final ActionSimple as1 = new ActionSimple("AS1");
        final Jour j1 = new Jour(2000, 02);
        as1.enregistrerCours(j1, VALEUR_AS);
        p1.acheterAction(as1, 2);
        final float result = p1.getValeur(j1);
        Assertions.assertEquals(EXPECTED_VALEUR, +
                result, "The Value should be the same.");
    }
    /**.
     * Test de consulterActions de Portefeuille
     */
    @Test
    public void testConsulterActions() {
        final Portefeuille p1 = new Portefeuille();
        final ActionSimple as1 = new ActionSimple(EXPECTED_AS1);
        final ActionSimple as2 = new ActionSimple(EXPECTED_AS2);
        final Quantite q1 = new Quantite(EXPECTED_Q1);
        final Quantite q2 = new Quantite(EXPECTED_Q2);
        p1.acheterAction(as1, q1.getQuantite());
        p1.acheterAction(as2, q2.getQuantite());
        final boolean result = p1.getPossederAction()
                .equals(p1.consulterActions());
        Assertions.assertTrue(result, "The HashMap should be the same ");
    }
}

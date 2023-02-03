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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author andyb
 */
public class QuantiteTest {
    /**
     * Test de la méthode ajouterQuantite, de la classe Quantite.
     */
    @Test
    public void testAjouterQuantite() {
        final int result;
        final int qteAjouter = 1;
        Quantite qteInit = new Quantite(0);
        qteInit.ajouterQuantite(qteAjouter);
        result = qteInit.getQuantite();
        Assertions.assertEquals(qteAjouter, result);
    }

    /**
     * Test de la méthode enleverQuantite, de la classe Quantite.
     */
    @Test
    public void testEnleverQuantite() {
        final int result;
        final int qteRetirer = 1;
        Quantite qteInit = new Quantite(1);
        qteInit.enleverQuantite(qteRetirer);
        result = qteInit.getQuantite();
        Assertions.assertEquals(0, result);
    }

    /**
     * Test of getQuantite method, of class Quantite.
     */
    @Test
    public void testGetQuantite() {
        final int result;
        final int expectedResult = 1;
        Quantite qteInit = new Quantite(1);
        result = qteInit.getQuantite();
        Assertions.assertEquals(expectedResult, result);
    }

    /**
     * Test de la méthode toString, de la classe Quantite.
     */
    @Test
    public void testToString() {
        final String result;
        final String expectedResult = "Quantite{quantite=1}";
        Quantite qteInit = new Quantite(1);
        result = qteInit.toString();
        Assertions.assertEquals(expectedResult, result);
    }
}

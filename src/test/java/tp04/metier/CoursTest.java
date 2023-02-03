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
public class CoursTest {
    /**
     * Constructeur de la classe de test.
     */
    public CoursTest() {
    }

    /**
     * Test de la methode toString , de la classe Cours.
     */
    @Test
    public void testToString() {
        final String result;
        final float valeur = 1f;
        final String expectedResult = "Cours{valeur=" + valeur + "}";
        final Cours cours = new Cours(valeur);
        result = cours.toString();
        Assertions.assertEquals(expectedResult, result);
    }

}

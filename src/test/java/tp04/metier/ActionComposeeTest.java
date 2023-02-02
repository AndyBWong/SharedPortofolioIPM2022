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


/**
 *
 * @author andyb
 */
public class ActionComposeeTest {
     /**
     * Jour qui pour lequel une action possède un cours.
     * Antérieur à la date du jour.
     */
    private static final Jour jourExistant = new Jour(2022, 1) ;
    
    /**
     * Constructeur de la classe de test.
     */
    public ActionComposeeTest(){
        
    }

    /**
     * Vérifie si la valeur récupéré d'une action composée est correcte.
     */
    @Test
    public static void TestGetValActionCompShouldPass() {
        final ActionSimple as1 = new ActionSimple("Action1");
        final ActionSimple as2 = new ActionSimple("Action2");
        final float valeur = 10f;
        final float expectedValeur = valeur * 2;
        final int pourcentage = 50;
        final ActionComposee ac1;
        final float result;

        as1.enregistrerCours(jourExistant, valeur);
        as2.enregistrerCours(jourExistant, valeur);
        ac1 = new ActionComposee("ActionComp");
        ac1.enregistrerComp(as1, pourcentage);
        ac1.enregistrerComp(as2, pourcentage);
        result = ac1.getValeur(jourExistant);
        Assertions.assertEquals(expectedValeur, result);
    }

}

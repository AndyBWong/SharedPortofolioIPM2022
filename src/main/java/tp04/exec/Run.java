/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp04.exec;

import tp04.metier.Action;
import tp04.metier.ActionComposee;
import tp04.metier.ActionSimple;
import tp04.metier.Jour;
import tp04.metier.Portefeuille;

public class Run {

    public static void main(String[] args) {
            Jour jour1 = new Jour(2022,2, 1);
    Jour jour2 = new Jour(2022,2, 2);
    Jour jour3 = new Jour(2022,2, 3);
    // Actions simples
    ActionSimple actionSimple1 = new ActionSimple("FranceTelevision");
    ActionSimple actionSimple2 = new ActionSimple("TF1");
    actionSimple1.enregistrerCours(jour2,13.5f);
    actionSimple2.enregistrerCours(jour3, 20f);
    actionSimple1.getValeur(jour1);
    actionSimple1.getValeur(jour2);
    // Actions composée
    ActionComposee actionComposee = new ActionComposee("FranceTelevision/TF1");
    actionComposee.enregistrerComp(actionSimple1, 50f);
    actionComposee.enregistrerComp(actionSimple2, 50f);
    actionComposee.getValeur(jour3);

    //region Création d'un portefeuille
    Portefeuille portefeuille1 = new Portefeuille();
    portefeuille1.acheterAction(actionSimple1,30);
    portefeuille1.acheterAction(actionSimple1,30);
    portefeuille1.vendreAction(actionSimple1,10);
    System.out.println(portefeuille1.getValeur(jour1));
    //endregion
 
    }

}

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

    //Creation d'un portefeuille
    Portefeuille portefeuille2 = new Portefeuille();    
    portefeuille2.acheterAction(actionSimple1, 10);
    portefeuille2.acheterAction(actionSimple2, 20);
    portefeuille2.vendreAction(actionSimple1, 10);
    portefeuille2.vendreAction(actionSimple2, 10);
    System.out.println(portefeuille2.getValeur(jour1));
 
    
    // Consultation des actions en dessous d'un prix donné
    float prix = 30.0f;
    System.out.println("Actions en dessous de " + prix + ":");
        if (actionSimple1.getValeur(jour2) < prix) {
            System.out.println("- " + actionSimple1.getLibelle());
        }
        if (actionSimple2.getValeur(jour3) < prix) {
            System.out.println("- " + actionSimple2.getLibelle());
        }
        if (actionComposee.getValeur(jour3) < prix) {
            System.out.println("- " + actionComposee.getLibelle());
        }
    }
    

}

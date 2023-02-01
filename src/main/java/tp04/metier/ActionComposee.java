/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp04.metier;


import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author perussel
 */
public class ActionComposee extends Action {
    //region attribut
    Hashtable<ActionSimple,Pourcentage>composition;
    //endregion
    //regionconstructor
    public ActionComposee(String libelle){
        super(libelle);
        this.composition = new Hashtable<ActionSimple,Pourcentage>();
    }
    //endregion
    //region methods
    @Override
    public float getValeur(Jour jour) {
        float valeurComposition = 0;
        float sommeValeurCompetition = 0;
        for (Map.Entry<ActionSimple,Pourcentage>compositionChoisi:composition.entrySet()) {
            valeurComposition = compositionChoisi.getKey().getValeur(jour);
            sommeValeurCompetition += valeurComposition;
        }
        System.out.println(sommeValeurCompetition);
        return sommeValeurCompetition;
    }

    public void enregistrerComp(ActionSimple action, float pourcentage){
        Pourcentage pourcentageAMettre = new Pourcentage(pourcentage);
        float sommeComposition = 0;
        if (pourcentage<=100 && pourcentage>=0){
        for (Map.Entry<ActionSimple,Pourcentage>compositionChoisi:composition.entrySet()) {
            System.out.println(compositionChoisi.getKey() + " " + compositionChoisi.getValue());
            sommeComposition += compositionChoisi.getValue().getPourcentage();

        }
        if ((sommeComposition + pourcentage)<=100){
            this.composition.put(action,pourcentageAMettre);
        }
        else{
            System.out.println("La somme est au dessus de 100 ");
        }
        }else{
            System.out.println("La somme est incorrect ");
        }
    }
    //endregion
}

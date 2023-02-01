/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp04.metier;



import java.util.Hashtable;
import tp04.metier.Cours;
import tp04.metier.Jour;

/**
 *
 * @author perussel
 */
public class ActionSimple extends Action {
   //region attribut
Hashtable<Jour,Cours>composerActionSimple;
    //endregion
    //region constructor
    public ActionSimple(String libelle){
        super(libelle);
        this.composerActionSimple = new Hashtable<Jour, Cours>();

    }
    //endregion
    //region methods
    @Override
    public float getValeur(Jour jour) {
        try{
            System.out.println("voici les cours pour ce jour "+composerActionSimple.get(jour).getValeur());
            return this.composerActionSimple.get(jour).getValeur();

        }
        catch (Exception e){
            System.out.println("Aucune action a ce jour");
            return -1;
        }

    }

    public void enregistrerCours(Jour jour, float valeur){
        if (!this.composerActionSimple.containsKey(jour)) {
            Cours coursPrecis = new Cours(valeur);
            this.composerActionSimple.put(jour,coursPrecis);
        }

    }
    //endregion

}

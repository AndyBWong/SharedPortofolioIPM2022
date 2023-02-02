/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp04.metier;



import java.util.HashMap;
import tp04.metier.Cours;
import tp04.metier.Jour;

/**
 *
 * @author perussel
 */
public class ActionSimple extends Action {
   /**
    * Le cours de l'action en fonction du jour.
    */
    private HashMap<Jour, Cours> composerActionSimple;

    //region constructor
    public ActionSimple(String libelle){
        super(libelle);
        this.composerActionSimple = new HashMap<Jour, Cours>();
    }

    /**
     * Récupère la valeur de action simple pour un jour donné.
     * @param jour Jour pour lequel on cherche la valeur de l'action simple
     * @return Le montant de la valeur de l'action pour le jour donné.
     */
    @Override
    public float getValeur(Jour jour) {
        float valeurAction;
        try {
            valeurAction = this.composerActionSimple.get(jour).getValeur();
            System.out.println("voici les cours pour ce jour " + valeurAction);
            return valeurAction;
        } catch (Exception e) {
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

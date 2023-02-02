/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp04.metier;

import java.util.HashMap;


public class ActionSimple extends Action {
   /**
    * Le cours de l'action en fonction du jour.
    */
    private HashMap<Jour, Cours> composerActionSimple;

    //constructor
    public ActionSimple(String libelle){
        super(libelle);
        this.composerActionSimple = new HashMap<Jour, Cours>();
    }
    /**
     * Recuperer la composition d'une action simple
     */
    public HashMap<Jour, Cours> getComposerActionSimple() {    
        return composerActionSimple;
    }
    /**.
     * Récupère la valeur de action simple pour un jour donné.
     * @param jour Jour pour lequel on cherche la valeur de l'action simple
     * @return Le montant de la valeur de l'action pour le jour donné.
     */
    @Override
    public float getValeur(Jour jour) {
        float valeurAction;
        if (this.composerActionSimple.containsKey(jour)) {
            valeurAction = this.composerActionSimple.get(jour).getValeur();
            System.out.println("voici les cours pour ce jour " + valeurAction);
            return valeurAction;
        } else {
            System.out.println("Aucune action a ce jour");
            return -1;
        }
    }
    
    //Enregistrer le cours de l'action selon le jour
    public HashMap<Jour,Cours> enregistrerCours(Jour jour, float valeur){
        HashMap<Jour, Cours> AS = new HashMap<Jour, Cours>();
        if (!this.composerActionSimple.containsKey(jour)) {
            Cours coursPrecis = new Cours(valeur);
            this.composerActionSimple.put(jour,coursPrecis);
            System.out.println("L'action" + libelle + "a la date" + jour + "avec comme valeur" + valeur + "a bien été enregistrer");
        }
        return AS;
    }
    //endregion

}

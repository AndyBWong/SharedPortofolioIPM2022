/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp04.metier;

import java.util.HashMap;
import java.util.Map;


public class ActionSimple extends Action {
   /**
    * Le cours de l'action en fonction du jour.
    */
    private HashMap<Jour, Cours> composerActionSimple;
    
    /**
     * HashCode du dernier jour enregistré pour le cours d'une action.
     */
    private String dernierJour;
    
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

    /**
     * Enregistrement d'un cours d'une action Simple.
     * @param jour
     * @param valeur
     * @return composerActionSimple
     */
   public HashMap<Jour,Cours> enregistrerCours(Jour jour, float valeur){
       HashMap<Jour, Cours> aS = new HashMap<Jour, Cours>();
        if (!this.composerActionSimple.containsKey(jour)) {
            Cours coursPrecis = new Cours(valeur);
            this.composerActionSimple.put(jour, coursPrecis);
            aS.put(jour, coursPrecis);
            return aS;
        }
        return aS;
    }
   
   /**
    * Récupère la valeur du cours actuel de l'action simple.
    * @return la valeur du cours actuel de l'action simple
    */
   @Override
   public float valeurActuelle() {
       Jour dernierJourEnregistre;
       for(Map.Entry<Jour, Cours> jourCour :
               this.composerActionSimple.entrySet()) {
           if (jourCour.getKey().toString().equals(this.dernierJour)) {
               dernierJourEnregistre = jourCour.getKey();
               return this.composerActionSimple.get(dernierJourEnregistre)
                       .getValeur();
           }
       }
       return -1;
   }
   
   /**
    * Retourne le hashCode du dernier jour enregistré pour un cours de l'action.
    * @return le hashCode du dernier jour enregistré pour un cours
    */
   public String getDernierJour() {
       return dernierJour;
   }
}

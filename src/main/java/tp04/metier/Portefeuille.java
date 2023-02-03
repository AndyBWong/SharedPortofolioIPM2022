/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package tp04.metier;

import java.util.HashMap;
import java.util.Collection;


/**
 *Classe Portefeuille qui représente un portefeuille d'actions.
 * @author perussel
 */
public class Portefeuille {
    /**.
     * Liste des actions du portefeuille sous forme d'une HashMap associant
     * une action à une quantité
     */
    private HashMap<Action, Quantite> possederAction;
    private HashMap<Action, Jour> jourAction;
     /**
     * Constructeur qui initialise la liste des actions du portefeuille.
     */ 
    public Portefeuille( ){
        this.possederAction = new HashMap<Action, Quantite>();
        this.jourAction = new HashMap<Action, Jour>();
    }
    /**.
     * Retourne la liste des actions du portefeuille.
     * @return la liste des actions associées à
     * leur quantité dans le portefeuille.
     */
    public HashMap<Action, Quantite> getPossederAction() {
        return possederAction;
    }
    /**
     * Permet d'acheter une action pour une quantité donnée.
     * @param action l'action à acheter.
     * @param quantite la quantité d'actions à acheter.
     */

    public void acheterAction(Action action, int quantite,Jour jour){
    // Vérification si l'action est déjà présente dans le portefeuille
    if (this.possederAction.containsKey(action)) {
        /* Si oui, on récupère la quantité existante
        et on ajoute la quantité demandée*/
        Quantite quantiteExistante = this.possederAction.get(action);
        quantiteExistante.ajouterQuantite(quantite);
    }
    else {
        // Si non, on ajoute l'action avec la quantité demandée
        this.possederAction.put(action, new Quantite(quantite));
        this.jourAction.put(action, jour);

    }
}

 /**
     * Permet de vendre une action pour une quantité donnée.
     * @param action l'action à vendre.
     * @param quantiteASoustraire la quantité d'actions à vendre.
     */
    public void vendreAction(Action action,int quantiteASoustraire,Jour jour){
    // Vérification si l'action est présente dans le portefeuille
    if (this.possederAction.containsKey(action)) {
        /*
        Si oui, on récupère la quantité possédée et
        on soustrait la quantité demandée*/
        Quantite quantitePossedee = this.possederAction.get(action);
        int quantitePresente = quantitePossedee.getQuantite();
        if (quantitePresente >= quantiteASoustraire) {
            quantitePossedee.enleverQuantite(quantiteASoustraire);
        }
        else {
            System.out.println("Impossible de vendre autant d'actions"
                    + " car la quantité demandée est supérieure"
                    + " à la quantité possédée");
        }
        if (quantitePossedee.getQuantite() == 0) {
            this.possederAction.remove(action);
            this.jourAction.remove(action, jour);
        }
    }
    else {
        /* Si la quantité demandée est supérieure à la quantité possédée,
        on affiche un message d'erreur */
        System.out.println("Impossible de vendre cette action"
                + " car elle n'est pas présente dans le portefeuille");
    }
}
    //Historique des actions
    /**
     * permet d'avoir pour un portefeuille l'action du jour.
     * @param action.
     * @return.
     */
    public Jour getJourAction(Action action) {
       return this.jourAction.get(action);
    }
    /**
     * permet d'avoir une collection sur toutes les valeurs des actions.
     * @return.
     */
    public Collection obtenirToutesLesActions(){
        return this.possederAction.values();
    }
    /**.
     * Methode de récupération de la valeur du portefeuille
     * @param jour : objet jour (Année / Jour)
     * @return valeurAction : Valeur de l'action
     */
    public float getValeur(Jour jour) {
        float valeurAction = 0;
        for (Action action: possederAction.keySet()) {
            valeurAction = (this.possederAction.get(action).getQuantite()
                    * action.getValeur(jour));
        }
        return valeurAction;
    }
    /**.
     * Consultation de la liste des actions du portefeuille
     * @return actions
     */
    public HashMap<Action,Quantite> consulterActions(){
        HashMap<Action, Quantite> actions = new HashMap<Action, Quantite>();
        for (Action action : this.possederAction.keySet()) {
            actions.put(action, this.possederAction.get(action));
        }
        return actions;
    }


}

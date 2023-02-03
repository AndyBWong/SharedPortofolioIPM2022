/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package tp04.metier;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

/**
 *
 * @author perussel
 */
public class Portefeuille {
    /**.
     * Liste des actions du portefeuillee
     */
    private HashMap<Action, Quantite> possederAction;
     /**.
     * Constructeur
     */
    public Portefeuille(){
        this.possederAction = new HashMap<Action, Quantite>();
    }
    /**.
     * Retourne la liste des actions du portefeuille
     * @return possederAction
     */
    public HashMap<Action, Quantite> getPossederAction() {
        return possederAction;
    }
    
    
    public void acheterAction(Action action, int quantite){
    if (this.possederAction.containsKey(action)){
        Quantite quantiteExistante = this.possederAction.get(action);
        quantiteExistante.ajouterQuantite(quantite);
    }
    else{
        this.possederAction.put(action,new Quantite(quantite));
    }
}

    public void vendreAction(Action action,int quantiteASoustraire){
    if (this.possederAction.containsKey(action)){
        Quantite quantitePossedee = this.possederAction.get(action);
        int quantitePresente = quantitePossedee.getQuantite();
        if (quantitePresente >= quantiteASoustraire){
            quantitePossedee.enleverQuantite(quantiteASoustraire);
        }
        else{
            System.out.println("Impossible de vendre autant d'actions car la quantité demandée est supérieure à la quantité possédée");
        }
        if (quantitePossedee.getQuantite() == 0) {
            this.possederAction.remove(action);
        }
    }
    else {
        System.out.println("Impossible de vendre cette action car elle n'est pas présente dans le portefeuille");
    }
}

    
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

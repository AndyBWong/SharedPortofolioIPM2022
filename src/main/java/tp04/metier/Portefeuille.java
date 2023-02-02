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
    
//region attribut
protected HashMap<Action,Quantite>possederAction;
    //endregion
    //region constructor
public Portefeuille(){
    this.possederAction = new HashMap<Action, Quantite>();
}
    //endregion
    //region methods
public void acheterAction(Action action, int quantite){
    // je prends une action en particulier
    if (this.possederAction.containsKey(action)){
        this.possederAction.get(action).ajouterQuantite(quantite);
    }
    else{
        this.possederAction.put(action,new Quantite(quantite));
    }

    // je vais acheter une quantite que je vais signifier pour cela je vais add dans hastable

}
public void vendreAction(Action action,int quantiteASoustraire){
    if (this.possederAction.containsKey(action)){
        int quantitePresente = possederAction.get(action).getQuantite();
        if (quantitePresente>quantiteASoustraire){
            possederAction.get(action).enleverQuantite(quantiteASoustraire);
        }
        else{
            System.out.println("Impossible d'enlever cette quantite car la quantite a enlever est trop grande");
        }

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
}

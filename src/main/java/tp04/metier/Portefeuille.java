/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp04.metier;


import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

/**
 *
 * @author perussel
 */
public class Portefeuille {
    //region attribut
protected Hashtable<Action,Quantite>possederAction;
    //endregion
    //region constructor
public Portefeuille(){
    this.possederAction = new Hashtable<Action, Quantite>();
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

public float getValeur(Jour jour){
    float valeurAction = 0;

   // boucle
    for (Action action: possederAction.keySet()){
        valeurAction = (this.possederAction.get(action).getQuantite() * action.getValeur(jour));
    }
   return valeurAction; // retourner à l'aide du jour qu'on choisi en paramètre la valeur  en return
}
//endregion

}

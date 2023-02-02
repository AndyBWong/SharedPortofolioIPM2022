/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp04.metier;

/**
 * Cours d'une action.
 */
public class Cours {
    //region attribut
float valeur;
//endregion
    //region constructor
public Cours(float valeur){
    this.valeur = valeur;
}
//endregion
    //region methods
    public float getValeur() {
        return valeur;
    }
    //endregion
}

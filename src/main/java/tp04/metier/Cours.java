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
/**
 * Valeur du cours.
 */
private float valeur;
/**
 * Valeur du cours.
 * @param valeur
 */
public Cours(final float valeur) {
    this.valeur = valeur;
}

    @Override
    public String toString() {
        return "Cours{" + "valeur=" + valeur + '}';
    }

//endregion
    //region methods
    public float getValeur() {
        return valeur;
    }
    //endregion
}

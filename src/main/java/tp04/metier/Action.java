/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp04.metier;



/**
 *
 * @author perussell
 */
public abstract class Action {
    /**
     * libelle de action.
     */
    private String libelle;
    /**
     *
     * @param libelle.
     */
    public Action(String libelle) {
        this.libelle = libelle;
    }
    /**
     * Obtenir le libelle de action.
     * @return libelle
     */
    public final String getLibelle() {
        return libelle;
    }
    /**
     *
     * @param jour
     * @return float
     */
    public abstract float getValeur(Jour jour);
    /**
     * Récupère la dernière valeur du cours d'une action.
     * @return la dernière valeur du cours d'une action
     */
    public abstract float valeurActuelle();
    //endregion
}

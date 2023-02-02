/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp04.metier;

import java.util.Objects;

/**
 *
 * @author perussell
 */
public abstract class Action {
    //region attribut
    protected String libelle;
    //endregion

    //region constructor
    public Action(String libelle){
        this.libelle = libelle;
    }
    //endregion

    //region methods

    public String getLibelle() {
        return libelle;
    }

    public abstract float getValeur(Jour jour);


    //endregion
}

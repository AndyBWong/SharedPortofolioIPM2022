/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp04.metier;

/**
 *
 * @author perussel
 */
public class Jour {
    //region attribut
    private int annee;
    private int numJour;
    //endregion

    //region constructor
    public Jour(int annee, int numJour){
        this.annee = annee;
        this.numJour = numJour;
    }
    //endregion

    //region methods
    public int getAnnee() {
        return annee;
    }

    public int getNumJour() {
        return numJour;
    }
    //endregion
  
}

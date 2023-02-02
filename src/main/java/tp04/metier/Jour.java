/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp04.metier;

public class Jour {
    //attributs
    private int annee;
    private int numJour;
    private int mois;
    //endregion

    //constructeur
    public Jour(int annee,int mois, int numJour){
        this.annee = annee;
        this.numJour = numJour;
        this.mois = mois;
    }
    

    //getters
    public int getAnnee() {
        return annee;
    }

    public int getNumJour() {
        return numJour;
    }
    
    public int getMois() {
        return mois;
    }
    
    

    @Override
    public String toString() {
        return "Jour{" + "annee=" + annee + ", numJour=" + numJour + ", mois=" + mois + '}';
    }
  
}

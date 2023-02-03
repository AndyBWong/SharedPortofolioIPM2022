/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp04.metier;

public class Jour {
    /**
     * année de jour.
     */
    private int annee;
    /**
     * numero de Jour.
     */
    private int numJour;
    /**
     * mois du jour.
     */
    private int mois;
    /**
     * Constructeur jour.
     * @param annee
     * @param mois
     * @param numJour
     */
    public Jour(int annee,int mois, int numJour) {
        this.annee = annee;
        this.numJour = numJour;
        this.mois = mois;
    }
    /**
     * Annee du jour.
     * @return annee
     */
    public int getAnnee() {
        return annee;
    }
    /**
     * num du jour.
     * @return numJour
     */
    public int getNumJour() {
        return numJour;
    }
    /**
     * mois du jour.
     * @return mois
     */
    public int getMois() {
        return mois;
    }

    @Override
    public String toString() {
        return "Jour{" + "annee=" + annee + ", numJour="
                + numJour + ", mois=" + mois + '}';
    }
}



package tp04.metier;

/**
 * attribut de la classe quantité.
 * @author andyb.
 */
public class Quantite {
    //region attribut
    /**
     * attribut quantité de la classe quantité.
     */
    private int quantite;
    //endregion

    //region constructor,
    /**
     * constructeur de la classe quantité.
     * @param quantite.
     */
    public Quantite(int quantite){
        this.quantite = quantite;
    }
    //endregion

    //region methods
    /**
     * methode permettant d'ajouter la quantité.
     * @param quantite.
     * @return la quantité.
     */
    public int  ajouterQuantite(int quantite){
        this.quantite += quantite;
        return this.quantite;
    }
    /**
     * methode permettant de soustraire la quantité.
     * @param quantite.
     * @return.
     */
    public int enleverQuantite(int quantite){
        this.quantite -= quantite;
        return this.quantite;
    }
    /**
     * permet d'avoir la quantité.
     * @return la quantité.
     */
    public int getQuantite() {
        return quantite;
    }
    /**
     * permet d'avoir la valeur quantité via la méthode toString.
     */
    @Override
    public String toString() {
        return "Quantite{" + "quantite=" + quantite + '}';
    }

}


package tp04.metier;

/**
 *
 * @author andyb
 */
public class Quantite {
    //region attribut
    private int quantite;
    //endregion

    //region constructor,
    public Quantite(int quantite){
        this.quantite = quantite;
    }
    //endregion

    //region methods
    public int  ajouterQuantite(int quantite){
        this.quantite += quantite;
        return this.quantite;
    }

    public int enleverQuantite(int quantite){
        this.quantite -= quantite;
        return this.quantite;
    }

    public int getQuantite() {
        return quantite;
    }

    @Override
    public String toString() {
        return "Quantite{" + "quantite=" + quantite + '}';
    }

    
    
}

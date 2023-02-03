package tp04.metier;

/**
 *attribut de la classe pourcentage.
 * @author andyb.
 */

public class Pourcentage {
    /**
     * attribut pourcentage.
     */
    private float pourcentage;
    //endregion
    //region constructor
    /**
     * constructeur de la classe pourcentage.
     * @param pourcentage.
     */
    public Pourcentage(float pourcentage){
        this.pourcentage = pourcentage;
    }
    //end region

    /**
     *permet d'avoir le pourcentage.
     * @return pourcentage.
     */
    public float getPourcentage() {
        return pourcentage;
    }
}

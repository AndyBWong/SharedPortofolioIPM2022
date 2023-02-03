/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package tp04.metier;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author perussel
 */
public class ActionComposee extends Action {
    /**.
     * Propriété.
     */
    private HashMap<ActionSimple, Pourcentage> composition;
    /**.
     * constructeur de l'action composée.
     * @param libelle.
     */
    public ActionComposee(String libelle){
        super(libelle);
        this.composition = new HashMap<ActionSimple,Pourcentage>();
    }
    
    public HashMap<ActionSimple, Pourcentage> getComposition() {
        return composition;
    }
    
    
    /**
     * Cette méthode retourne la valeur pour un jour donné
     * d'une action composée.
     * @param jour Jour pour lequel on veut connaître la valeur
     * @return Valeur de l'action composée
     */
    @Override
    public float getValeur(Jour jour) {
        float valeurComposition = 0;
        float sommeValeurCompo = 0;
        for (Map.Entry<ActionSimple, Pourcentage> compositionChoisi
                : composition.entrySet()) {
            valeurComposition = compositionChoisi.getKey().getValeur(jour);
            sommeValeurCompo += valeurComposition;
        }
        System.out.println(sommeValeurCompo);
        return sommeValeurCompo;
    }
    /**.
     *enregistre le pourcentage d'une action composée en fonction d"une action
     * @param action
     * @param pourcentage
     * @return compo
     */
    public HashMap<ActionSimple, Pourcentage>
        enregistrerComp(ActionSimple action, float pourcentage){
                    Pourcentage pourcentageAMettre
                            = new Pourcentage(pourcentage);
                    HashMap<ActionSimple, Pourcentage> compo =
                            new HashMap<ActionSimple, Pourcentage>();
                    float sommePourcentageComposition = 0;
                    final int maxPourcentage = 100;
                    if (pourcentage <= maxPourcentage && pourcentage >= 0) {
                        for (Map.Entry<ActionSimple, Pourcentage>
                                compositionChoisi:composition.entrySet()) {
                            System.out.println(compositionChoisi.getKey() + " "
                                    + compositionChoisi.getValue());
                            sommePourcentageComposition +=
                                    compositionChoisi.getValue()
                                            .getPourcentage();
                        }
                        if ((sommePourcentageComposition + pourcentage)
                                <= maxPourcentage) {
                            this.composition.put(action, pourcentageAMettre);
                            compo.put(action, pourcentageAMettre);
                        } else {
                            System.out.println("La somme du pourcentage"
                                    + " est au dessus de 100 ");
                        }
                    } else {
                        System.out.println("Le pourcentage est incorrect ");
                    }
                    return compo;
                }
                /**
                 * Récupère la valeur du cours actuel de l'action composée.
                 * @return la valeur du cours actuel de l'action composée
                 */
                @Override
                public float valeurActuelle() {
                    return -1;
                }
}

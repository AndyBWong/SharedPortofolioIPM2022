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
public class Portefeuille {
    
    Map<Action, LignePortefeuille> mapLignes;
    
    private class LignePortefeuille {
        
        private Action action;
        
        private int qte;
        
        public int getQte() {
            return qte;
        }
        
        public void setQte(int qte) {
            this.qte = qte;
        }
        
        public Action getAction() {
            return this.action;
        }
        
        public LignePortefeuille(Action action, int qte) {
            this.action = action;
            this.qte = qte;
        }

        public String toString() {
            return Integer.toString(qte);
        }
    }
    
    public Portefeuille() {
        this.mapLignes = new HashMap();
    }
    
    public void acheter(Action a, int q) {
    if (q <= 0) {
        throw new IllegalArgumentException("La quantité doit être positiveE.");
    }

    if (this.mapLignes.containsKey(a) == false) {
        this.mapLignes.put(a, new LignePortefeuille(a, q));
    } else {
        this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() + q);
    }
    }

    public void vendre(Action a, int q) {
    if (q <= 0) {
        throw new IllegalArgumentException("La quantité doit être positive.");
    }

    if (this.mapLignes.containsKey(a) == true) {
        int qteDisponible = this.mapLignes.get(a).getQte();
        if (qteDisponible >= q) {
            this.mapLignes.get(a).setQte(qteDisponible - q);
        } else {
            throw new IllegalArgumentException("La quantité disponible est inférieure à la quantité à vendre.");
        }
    } else {
        throw new IllegalArgumentException("L'action n'est pas présente dans le portefeuille.");
    }
    }

    public String toString() {
        return this.mapLignes.toString();
    }

    public float valeur(Jour j) {
        float total = 0;
        for (LignePortefeuille lp : this.mapLignes.values()) {
            total = total + (lp.getQte() * lp.getAction().valeur(j));
        }
        return total;
    }
}

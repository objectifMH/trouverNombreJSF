/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guess;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;

/**
 *
 * @author epsi
 */
@Named(value = "aleaBean")
@SessionScoped
public class AleaBean implements Serializable {

    private String phrase;
    private int devinette;
    private int utilisateur;
    private int nombre;
    private int min ; 
    private boolean fini ; 
    

    /**
     * Creates a new instance of AleaBean
     */
    public AleaBean() {
        phrase = "Je pense à un nombre entre 1 et 99. Pouvez-vous le trouver ?";
        nombre = 0;
        fini = false ; 
    }

    @PostConstruct
    public void init() {
        devinette = 1 + (int) (Math.random() * ((99 - 1) + 1));
        nombre = 0;
        phrase = "Je pense à un nombre entre 1 et 99. Pouvez-vous le trouver ?";
        utilisateur = 0 ; 
        fini = false ; 
    }

    /**
     * @return the phrase
     */
    public String getPhrase() {
        return phrase;
    }

    /**
     * @param phrase the phrase to set
     */
    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    /**
     * @return the utilisateur
     */
    public int getUtilisateur() {
        return utilisateur;
    }

    /**
     * @param utilisateur the utilisateur to set
     */
    public void setUtilisateur(int utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void comparer() {
        if (nombre > 4) {
            fini = true ; 
            this.setPhrase("Perdu, veux tu rejouer ?");
        } else {

            if (utilisateur > getDevinette()) {
                this.setPhrase("le nombre auquel je pense est plus petit, il reste "+(5 - (nombre+1)) + " coup(s)");
            } else if (utilisateur < getDevinette()) {
                this.setPhrase("le nombre auquel je pense est plus grand, il reste "+(5 - (nombre+1)    ) + " coup(s)");
            } else {
                this.setPhrase("Bravo , "+utilisateur+" est exactement au nombre auquel je pensais !! ");
                nombre = 5 ; 
            }
            nombre++;
        }

        if ( fini == true ){
            this.setPhrase("La partie est terminée !");
        }
        

    }

    /**
     * @return the nombre
     */
    public int getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the devinette
     */
    public int getDevinette() {
        return devinette;
    }
}

package com.example.model;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Hugo Malglaive
 * @version 1.0
 * @since SpringBoot
 */
public class AdresseForm {

    @Size(min=2, max=50)
    private String rue;

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public int getNumRue() {
        return numRue;
    }

    public void setNumRue(int numRue) {
        this.numRue = numRue;
    }

    public String getCodepostale() {
        return codepostale;
    }

    public void setCodepostale(String codepostale) {
        this.codepostale = codepostale;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    private int numRue;

    @Size(min=5, max=5)
    private String codepostale;

    private String ville;

    @Override
    public String toString() {
        return "AdresseForm{" +
                "rue='" + rue + '\'' +
                ", numRue=" + numRue +
                ", codepostale='" + codepostale + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }
}

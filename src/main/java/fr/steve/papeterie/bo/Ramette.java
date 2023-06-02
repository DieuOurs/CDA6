package fr.steve.papeterie.bo;

import java.io.Serializable;

public class Ramette extends Article implements Serializable {
    private int grammage;

    public Ramette() {

    }

    public Ramette(Integer idArticle, String marque, String ref, String designation, float pu, int qte, int grammage) {
        super(idArticle, marque, ref, designation, pu, qte);

        setGrammage(grammage);
    }

    public Ramette(String marque, String ref, String designation, float pu, int qte, int grammage) {
        super(marque, ref, designation, pu, qte);
        setGrammage(grammage);

    }


    /**
     * @return the grammage
     */
    public int getGrammage() {
        return grammage;
    }

    /**
     * @param grammage the grammage to set
     */
    public void setGrammage(int grammage) {
        this.grammage = grammage;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Ramette{" +
                "grammage=" + grammage +
                "} " + super.toString();
    }
}

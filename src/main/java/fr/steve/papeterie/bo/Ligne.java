package fr.steve.papeterie.bo;

import java.io.Serializable;

public class Ligne implements Serializable {
    //Attributs
    protected int qte;
    protected Article article;

    //Constructeurs
    Ligne(Article article, int qte) {
        setArticle(article);
        setQte(qte);
    }

    //Getters et Setters
    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }


    public Article getArticle() {
        return this.article;
    }

    private void setArticle(Article article) {
        this.article = article;

    }

    public float getPrix() {
        return article.getPrixUnitaire();
    }


    //Méthodes


	@Override
	public String toString() {
		return "Ligne{" +
				"qte=" + qte +
				", article=" + article +
				'}';
	}
}

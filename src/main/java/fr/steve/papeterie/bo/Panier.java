package fr.steve.papeterie.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Eni Ecole Le panier stocke les articles sélectionnés par
 * l'utilisateur au cours de sa navigation. Le panier n'est pas
 * sauvegardé.
 */
public class Panier implements Serializable {

    // Attributs d'instance
    private final List<Ligne> lignesPanier;
    private float montant;
	private int idPanier;

    // Constructeurs
    public Panier(int idPanier) {
        float montant;
		this.idPanier = idPanier;
        lignesPanier = new ArrayList<Ligne>();
    }

    // Getters et Setters

    /**
     * @return the lignesPanier
     */
    public final List<Ligne> getLignesPanier() {
        return lignesPanier;
    }

    /**
     * Ajouter une ligne au panier. Le prix de la ligne est calculé (Qte*prix)
     *
     * @param numero
     * @param article
     * @param qte
     */
    public void addLigne(Article article, int qte) {

        Ligne ligneAdding = new Ligne(article, qte);
        lignesPanier.add(ligneAdding);
    }

    /**
     * Retourne la ligne sélectionnée du Panier ou null si pas trouvée
     *
     * @param index
     * @return
     */
    public final Ligne getLigne(int index) {
        return lignesPanier.get(index);
    }

    /**
     * Présenter le détail du panier
     */
	@Override
	public String toString() {
		return "Panier{" +
				"lignesPanier=" + lignesPanier +
				", montant=" + montant +
				", idPanier=" + idPanier +
				'}';
	}

	/**
     * Supprimer la ligne du panier. La quantité en stock augmente de la
     * quantité associée à la ligne
     *
     * @param numero
     */
    public void removeLigne(int index) {
        lignesPanier.remove(index);
    }

    /**
     * Modifier la quantité placée dans le panier La quantité en stock augment
     * ou diminue en fonction de cette nouvelle qté
     *
     * @param index
     * @param newQte
     * @throws PlusEnStockException
     */
    public void updateLigne(int index, int newQte) {
        this.getLigne(index).setQte(newQte);
    }

    public float getMontant() {
        this.montant = 0;
        this.lignesPanier.forEach(ligne -> this.montant += ligne.getArticle().getPrixUnitaire() * ligne.getQte());
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

}

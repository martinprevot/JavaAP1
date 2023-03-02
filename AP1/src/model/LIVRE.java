package model;


public class LIVRE {
	private String ISBN,titre;
	private int prix;
	private AUTEUR Auteur;
	private ADHERENT emprunteur;


	public AUTEUR getAuteur() {
		return Auteur;
	}
	public void setAuteur(AUTEUR auteur) {
		Auteur = auteur;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public ADHERENT getEmprunteur() {
		return emprunteur;
	}
	public void setEmprunteur(ADHERENT emprunt) {
		this.emprunteur = emprunt;
	}




	public LIVRE(String iSBN, String titre, int prix, ADHERENT emprunteur) {
		super();
		ISBN = iSBN;
		this.titre = titre;
		this.prix = prix;
		this.emprunteur = emprunteur;
	}
	public LIVRE(String ISBN, String titre, int prix,ADHERENT emprunt, AUTEUR Auteur) {
		this.ISBN=ISBN;
		this.titre = titre;
		this.prix = prix;
		this.emprunteur = emprunt;
		this.Auteur = Auteur;

	}
	public LIVRE(String iSBN, String titre, int prix) {
		super();
		ISBN = iSBN;
		this.titre = titre;
		this.prix = prix;

	}
	public LIVRE(String iSBN, String titre, int prix, AUTEUR auteur) {
		super();
		ISBN = iSBN;
		this.titre = titre;
		this.prix = prix;
		Auteur = auteur;
	} 
	public void AFFICHERLIVRE() {
		System.out.print("ISBN : "+ISBN+", ");
		System.out.print("Titre : "+titre+", ");
		System.out.print("Prix : "+prix+", ");

		if (Auteur==null) {
			System.out.print("Auteur inconnue, ");
		}
		else 
		{
			System.out.println("Auteur : "+Auteur.getNom() +", ");
		}
		if	(emprunteur==null) 
		{
			System.out.println("Livre dispo !");
		}
		else 
		{
			System.out.print("Livre emprunter par :"+emprunteur.getNom());
		}
	}	
	public String Ligne() {
		String str;
		str=ISBN +" : '"+titre+"'";
		if (Auteur==null)
			str=str+" de "+"Auteur inconnu";
		else
			str=str+" de "+Auteur.getNom();
		if (emprunteur==null)
			str=str+" - "+"dispo";
		else
		{
			str=str+" - "+"Non dispo";
		}		
		return str;
	}
	


}

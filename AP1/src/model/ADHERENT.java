package model;
import java.util.ArrayList;
public class ADHERENT {

	private int num;
	private String nom;
	private String prenom;
	private String dateadhesion;
	private ArrayList <LIVRE> meslivres;

	public ADHERENT(int num,String nom, String prenom, String dateadhesion) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateadhesion = dateadhesion;
		this.num=num;
		meslivres = new ArrayList <LIVRE> ();
	}


	public ADHERENT(int num, String nom, String prenom,String dateadhesion,
			ArrayList<LIVRE> meslivres) {
		super();
		this.num = num;
		this.nom = nom;
		this.prenom = prenom;
		this.dateadhesion = dateadhesion;
		this.meslivres = meslivres;
	}


	public ArrayList<LIVRE> getMeslivres() {
		return meslivres;
	}
	public void setMeslivres(ArrayList<LIVRE> meslivres) {
		this.meslivres = meslivres;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDateadhesion() {
		return dateadhesion;
	}
	public void setDateadhesion(String dateadhesion) {
		this.dateadhesion = dateadhesion;
	}
	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}

	public void AfficherAdherent()
	{
		System.out.print("Num : "+num+", ");
		System.out.print("Nom : "+nom+", ");
		System.out.print("Prenom : "+prenom+", ");
		System.out.print("Date d'adhesion : "+dateadhesion);

	}


	public void ajouterLivre(LIVRE l) {
		meslivres.add(l);
	}

}


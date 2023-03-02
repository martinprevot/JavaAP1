package model;
public class AUTEUR{

	private String num,nom,prenom,description,date;

	
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public AUTEUR(String num,String nom, String prenom, String description, String date) {
		super();
		this.num = num;
		this.nom = nom;
		this.prenom = prenom;
		this.description = description;
		this.date = date;
	}
	public void AfficherAuteur(){
		System.out.print("Num : "+num+",");
		System.out.print("Nom : "+nom+",");
		System.out.print("Prenom : "+prenom+",");
		System.out.print("Description : "+description+",");
		System.out.print("Date : "+date);

	}
	public String Ligne() {
		String str;
		str=num +" : "+nom+"  "+prenom;
	
		return str;
	}

}

package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class model {
	private static ArrayList<AUTEUR> au;
	private static ArrayList<LIVRE> li ;
	private static ArrayList<ADHERENT> adh1;
	private Connection con;	
	private static String BDD = "AP1";
	private static String url = "jdbc:mysql://localhost:3306/" + BDD;
	private static String user = "root";
	private static String passwd = "";


	public static ArrayList<AUTEUR> getAu() {
		return au;
	}

	public static void setAu(ArrayList<AUTEUR> au) {
		model.au = au;
	}

	public ArrayList<LIVRE> getLi() {
		return li;
	}

	public static void setLi(ArrayList<LIVRE> li) {
		model.li = li;
	}

	public static ArrayList<ADHERENT> getAdh1() {
		return adh1;
	}

	public static void setAdh1(ArrayList<ADHERENT> adh1) {
		model.adh1 = adh1;
	}

	public model() {
		li=new ArrayList<LIVRE> ();
		au=new ArrayList<AUTEUR> ();
		adh1=new ArrayList<ADHERENT> ();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, user, passwd);
			this.con = conn;
			System.out.println("Connection OK");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getALL() throws SQLException, ClassNotFoundException{	

		au.clear();
		li.clear();
		adh1.clear();

		li = new ArrayList<LIVRE>();
		au = new ArrayList<AUTEUR>();
		adh1 = new ArrayList<ADHERENT>();


		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, user, passwd );
		System.out.println("Connection OK");

		//*********************************************
		// Chargement de l'ensemble des adherents
		//*********************************************
		String requete  ="SELECT * FROM adherent";
		ResultSet resultats,maj;
		Statement stmt = conn.createStatement();
		resultats = stmt.executeQuery(requete);
		System.out.println("ok");
		while(resultats.next()) {
			System.out.println(resultats.getInt(1)+" : "+resultats.getString(2)+" ");
		}

		//*********************************************
		// on ajoute les auteurs dans notre arraylist
		//*********************************************
		String requete3 ="SELECT * FROM auteur";
		Statement stmt2 = conn.createStatement();
		maj = stmt2.executeQuery(requete3);

		while(maj.next()) {
			AUTEUR ad = new AUTEUR(maj.getString(1),maj.getString(2), maj.getString(3), maj.getString(5),maj.getString(4));
			au.add(ad);

		}

		//*********************************************
		// on ajoute les livres dans notre arraylist
		//*********************************************
		String requete4 ="SELECT * FROM livre";
		stmt2 = conn.createStatement();
		maj = stmt2.executeQuery(requete4);

		while(maj.next()) {
			LIVRE l1 = new LIVRE(maj.getString(1), maj.getString(2), maj.getInt(3));
			li.add(l1);
		}



		//*********************************************
		// on ajoute les adherents dans notre arraylist
		//*********************************************
		String requete5 ="SELECT * FROM adherent";
		stmt2 = conn.createStatement();
		maj = stmt2.executeQuery(requete5);
		while(maj.next()) {
			ADHERENT adh = new ADHERENT(maj.getInt(1),maj.getString(2), maj.getString(3), maj.getString(4));
			adh1.add(adh);
		}
		for (int i = 0; i < adh1.size(); i++) {
			System.out.println(adh1.get(i).getDateadhesion());
		}
		/*
		 * TEST FIND LIVRE
		LIVRE testlivre;
		testlivre=findlivre("2");
		System.out.println("LE LIVRE 2 : ");
		testlivre.AFFICHERLIVRE();


	 	TEST FIND AUTEUR 

		AUTEUR testauteur;
		testauteur=findauteur("5");
		System.out.println("LE LIVRE 2 : ");
		testauteur.AfficherAuteur();
	 	TEST FIND ADHERENT 

		ADHERENT testadherent;
		testadherent=findadherent("4");
		System.out.println("LE LIVRE 4 : ");
		testadherent.AfficherAdherent();
		 */

		//*********************************************
		// Affecte un auteur a un livre 
		//*********************************************
		String requete6 ="SELECT livre.ISBN,auteur.num FROM auteur,livre where livre.auteur=auteur.num";
		Statement stmt3 = conn.createStatement();
		maj = stmt3.executeQuery(requete6);
		while(maj.next()) {
			String mo=maj.getString(1);
			String ma=maj.getString(2);
			LIVRE lelivre=findlivre(mo);
			AUTEUR lauteur=findauteur(ma);
			lelivre.setAuteur(lauteur);
			//findlivre(maj.getString(1)).setAuteur(findauteur(maj.getString(2)));

		}
		li.get(0).AFFICHERLIVRE();

		//*********************************************
		// Affecte un adherent a un livre 
		//*********************************************
		String requete7="SELECT livre.ISBN, adherent.num FROM adherent,livre WHERE livre.adherent= adherent.num";
		Statement stmt4 = conn.createStatement();
		maj = stmt4.executeQuery(requete7);
		while(maj.next()) {
			String isbn=maj.getString(1);
			int numadh=maj.getInt(2);
			LIVRE lelivre=findlivre(isbn);
			ADHERENT ladherent=findadherent(numadh);
			lelivre.setEmprunteur(ladherent);
			ladherent.ajouterLivre(lelivre);


		}
		li.get(1).AFFICHERLIVRE();

		System.out.println("------------");
		adh1.get(0).AfficherAdherent();

	}


	//*********************************************
	// Méthode pour trouver livre
	//*********************************************
	public static LIVRE findlivre (String ISBN) {

		LIVRE lelivre = null;
		for (int i = 0; i < li.size(); i++) {
			if (li.get(i).getISBN().equals(ISBN)) {
				lelivre =li.get(i);
				return lelivre;
			}

		}
		return null;

	}
	//*********************************************
	// Insertion dans la bdd sur phpmyadmin avec JAVA
	//*********************************************
	public static void creeradh (String num,String prenom,String nom, String email) throws SQLException, ClassNotFoundException {
		String requete2 ="INSERT INTO adherent VALUES ('"+num+"','"+nom+"','"+prenom+"','"+email+"')";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, user, passwd );
		Statement stmt2 = conn.createStatement();
		stmt2.executeUpdate(requete2);
	}
	//*********************************************
	// Méthode pour trouver auteur
	//*********************************************
	public static AUTEUR findauteur (String num) 
	{
		AUTEUR findauteur = null;

		for (int i = 0; i < au.size(); i++) 
		{
			if (au.get(i).getNum().equals(num)) 
			{
				findauteur=au.get(i);
				return findauteur;
			}

		}
		return null;
	}
	//*********************************************
	// Méthode pour trouver adherent
	//*********************************************
	public static ADHERENT findadherent (int num ) 
	{

		ADHERENT findadherent = null;

		for (int i = 0; i < adh1.size(); i++) 
		{
			if (adh1.get(i).getNum()==(num)) 
			{
				findadherent=adh1.get(i);
				return findadherent;
			}
		}
		return null;
	}
	//*********************************************
	// Méthode pour inserez adherent dans bdd avec isbn de livre 
	//*********************************************
	public void AdhenrentToBDD(int numadh,String numlivre) throws ClassNotFoundException, SQLException {
		String requete2 ="UPDATE `livre` SET `adherent` = '"+numadh+"' WHERE `livre`.`ISBN` = '"+numlivre+"';";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, user, passwd );
		Statement stmt2 = conn.createStatement();
		stmt2.executeUpdate(requete2);
	}
	//*********************************************
	// Méthode pour retirer adherent dans bdd avec isbn de livre 
	//*********************************************
	public void Restituer (String numlivre) throws ClassNotFoundException, SQLException {
		String requete2 ="UPDATE `livre` SET `adherent` = NULL WHERE `livre`.`ISBN` = '"+numlivre+"';";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, user, passwd );
		Statement stmt2 = conn.createStatement();
		stmt2.executeUpdate(requete2);
	}
	public void ajouterLivre(int ISBN, String titre,int prix,int i) throws SQLException, ClassNotFoundException {
		String requete1 = "INSERT INTO `livre` (`ISBN`, `titre`, `prix`, `adherent`, `auteur`) VALUES ('"+ISBN+"', '"+titre+"', '"+prix+"', NULL, '"+i+"');";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, user, passwd );
		Statement stmt2 = conn.createStatement();
		stmt2.executeUpdate(requete1);
	}

	public void ajouterAuteur(int id, String nom,String prenom,String description) throws SQLException, ClassNotFoundException {
		String requete1 = "INSERT INTO `auteur` (`num`, `nom`, `prenom`, `description`) VALUES ('"+id+"', '"+nom+"', '"+prenom+"','"+description+"');";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, user, passwd );
		Statement stmt2 = conn.createStatement();
		stmt2.executeUpdate(requete1);
	}
	public static String existelivre(String string) throws SQLException, ClassNotFoundException {
		String requete1 = "SELECT * FROM `livre` WHERE livre.ISBN = "+string+";";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, user, passwd );
		Statement stmt2 = conn.createStatement();
		ResultSet maj = stmt2.executeQuery(requete1);
		String mo=maj.getString(1);
		return mo;

	}



}

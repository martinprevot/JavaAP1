package controller;
import java.sql.SQLException;
import model.model;
import view.BIBLIOTEQUE;

public class main {
	private static model m;
	
	public static model getM() {
		return m;
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {	
		System.out.println("Main MVC");
		m = new model();
		BIBLIOTEQUE window = new BIBLIOTEQUE();
		window.main(args);
		m.getALL();
	}
}

  
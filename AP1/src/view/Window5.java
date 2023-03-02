package view;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JList;

import controller.main;
import model.ADHERENT;
import model.LIVRE;
import java.awt.List;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window5 {

	private static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window5 window = new Window5();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Window5() throws ClassNotFoundException, SQLException {
		main.getM().getALL();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 519, 330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		List list = new List();
		list.setBounds(53, 90, 344, 135);
		frame.getContentPane().add(list);
		
		
		//*********************************************
		// Afficher tout les livres dans la liste
		//*********************************************
		JLabel lblListeDesLivres = new JLabel("Liste des livres ");
		lblListeDesLivres.setBounds(167, 69, 154, 15);
		frame.getContentPane().add(lblListeDesLivres);
		
		JButton btnRetour = new JButton("");
		Image img = new ImageIcon(this.getClass().getResource("/Go-back-icon.png")).getImage();
		Image newImage  = img.getScaledInstance(15, 15, Image.SCALE_DEFAULT);
		btnRetour.setIcon(new ImageIcon("C:\\Users\\marti\\Desktop\\eclipse_workspace\\AP1\\img\\buttonRetour.png"));
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BIBLIOTEQUE window = new BIBLIOTEQUE();
				window.frame.setVisible(true);
				try {
					Window5.frame.setVisible(false);
				} catch (Exception e1) {
					e1.printStackTrace();
				}		
			}
		});
		btnRetour.setBounds(156, 239, 147, 41);
		frame.getContentPane().add(btnRetour);
		btnRetour.setBorder(null); 
		btnRetour.setContentAreaFilled(false); 


		for (int i = 0; i <  main.getM().getLi().size(); i++) {
			list.add((main.getM().getLi().get(i).Ligne()));

		}
	
	}
}

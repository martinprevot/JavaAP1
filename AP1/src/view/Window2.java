package view;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.main;
import model.ADHERENT;
import model.LIVRE;
import model.model;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Window2 {

	private static JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window2 window = new Window2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Window2() throws ClassNotFoundException, SQLException {
		main.getM().getALL();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNumroDadherent = new JLabel("Numéro d'adherent");
		lblNumroDadherent.setBounds(12, 26, 157, 15);
		frame.getContentPane().add(lblNumroDadherent);

		textField = new JTextField();
		textField.setBounds(168, 24, 114, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(168, 170, 114, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblIsbnDuLivre = new JLabel("ISBN du livre");
		lblIsbnDuLivre.setBounds(64, 173, 127, 15);
		frame.getContentPane().add(lblIsbnDuLivre);

		JButton btnReserver = new JButton("");
		btnReserver.setIcon(new ImageIcon("C:\\Users\\marti\\Desktop\\eclipse_workspace\\AP1\\img\\buttonReserver.png"));

		btnReserver.setEnabled(false);
		btnReserver.setBounds(311, 168, 89, 25);
		frame.getContentPane().add(btnReserver);

		JButton btnValider = new JButton("");
		btnValider.setIcon(new ImageIcon("C:\\Users\\marti\\Desktop\\eclipse_workspace\\AP1\\img\\buttonValider1.png"));

		btnValider.setBounds(311, 21, 89, 25);
		frame.getContentPane().add(btnValider);

		JLabel lblNumroDadherent_1 = new JLabel("Numéro d'adherent : ");
		lblNumroDadherent_1.setBounds(90, 74, 277, 15);
		frame.getContentPane().add(lblNumroDadherent_1);

		JLabel label = new JLabel("");
		label.setEnabled(false);
		label.setBounds(191, 233, 197, 15);
		frame.getContentPane().add(label);

		JButton btnRetour = new JButton("");
		btnRetour.setBorder(null); 
		btnRetour.setContentAreaFilled(false);
		btnValider.setBorder(null); 
		btnValider.setContentAreaFilled(false);
		Image img = new ImageIcon(this.getClass().getResource("/Go-back-icon.png")).getImage();
		Image newImage  = img.getScaledInstance(15, 15, Image.SCALE_DEFAULT);
		
		btnRetour.setIcon(new ImageIcon("C:\\Users\\marti\\Desktop\\eclipse_workspace\\AP1\\img\\buttonRetour.png"));
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BIBLIOTEQUE window = new BIBLIOTEQUE();
				window.frame.setVisible(true);
				try {
					Window2.frame.setVisible(false);
				} catch (Exception e1) {
					e1.printStackTrace();
				}		
			}
		});
		btnRetour.setBounds(12, 221, 107, 37);
		frame.getContentPane().add(btnRetour);
		
		btnReserver.setBorder(null); 
		btnReserver.setContentAreaFilled(false);
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ADHERENT ad ;
				ad = main.getM().findadherent(Integer.parseInt(textField.getText()));
				if (ad==null) 
				{
					lblNumroDadherent_1.setText("Numéro d'adherent : Invalide");

				}
				else 
				{
					lblNumroDadherent_1.setText("Numéro d'adherent : Valide");
					btnReserver.setEnabled(true);
					textField_1.setEditable(true);




				}

			}

		});
		btnReserver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LIVRE livre;
				livre = main.getM().findlivre(textField_1.getText());
				if (livre == null)
				{
					label.setText("ISBN du livre inexistant.");
				}
				else
				{
					if (livre.getEmprunteur() == null )
					{
						label.setVisible(true);
						label.setText("Le livre a bien été réserver.");
						ADHERENT ad = main.getM().findadherent(Integer.parseInt(textField.getText()));		
						livre.setEmprunteur(ad);
						String numlivre = livre.getISBN();
						int numadh = ad.getNum();
						try {
							main.getM().AdhenrentToBDD(numadh, numlivre);
							main.getM().getALL();
						} catch (ClassNotFoundException e1) 
						{
							e1.printStackTrace();
						} catch (SQLException e1) 
						{
							e1.printStackTrace();
						}
					}
					else {
						label.setVisible(true);
						label.setText("Livre déja emprunté.");
					}
				}
			}
		});
	}
}


package view;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.main;
import model.ADHERENT;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.Button;

public class Window10 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window10 window = new Window10();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window10() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 524);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\marti\\Desktop\\eclipse_workspace\\AP1\\img\\buttonEspaceAdh.png"));
		lblNewLabel.setBounds(153, -13, 150, 64);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Numéro d'adherent :");
		lblNewLabel_1.setBounds(27, 89, 131, 14);
		frame.getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(153, 86, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\marti\\Desktop\\eclipse_workspace\\AP1\\img\\buttonValider1.png"));

		btnNewButton.setBounds(268, 75, 89, 34);
		frame.getContentPane().add(btnNewButton);

		List list = new List();
		list.setBounds(56, 174, 251, 90);
		frame.getContentPane().add(list);

		List list_1 = new List();
		list_1.setBounds(56, 304, 256, 102);
		frame.getContentPane().add(list_1);

		JLabel lblNewLabel_2 = new JLabel("Info adherent :");
		lblNewLabel_2.setBounds(56, 153, 86, 14);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Liste de vos livres empruntés :");
		lblNewLabel_3.setBounds(56, 284, 215, 14);
		frame.getContentPane().add(lblNewLabel_3);

		Label label = new Label("");
		label.setBounds(28, 122, 243, 22);
		frame.getContentPane().add(label);

		JButton btnNewButton_1 = new JButton("");
		Image img = new ImageIcon(this.getClass().getResource("/Go-back-icon.png")).getImage();
		Image newImage  = img.getScaledInstance(15, 15, Image.SCALE_DEFAULT);
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\marti\\Desktop\\eclipse_workspace\\AP1\\img\\buttonRetour.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BIBLIOTEQUE window = new BIBLIOTEQUE();
				window.frame.setVisible(true);	
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(10, 436, 116, 38);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton.setBorder(null); 
		btnNewButton.setContentAreaFilled(false);
		btnNewButton_1.setBorder(null); 
		btnNewButton_1.setContentAreaFilled(false);

		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String nom, prenom, adhesion;
				if 	(textField.getText().isEmpty()){
					label.setText("Veuillez rentrer un numéro d'adherent");
				}
				else {
					ADHERENT adh = main.getM().findadherent(Integer.parseInt(textField.getText()));
					if (adh == null) {
						label.setText("Numéro d'adherent invalide ");
					}
					else {
						btnNewButton.setEnabled(false);

						nom ="Nom : "+adh.getNom();
						prenom ="Prenom : "+adh.getNom();
						adhesion = "Date d'adhesion : "+adh.getDateadhesion();
						label.setText("Numéro d'adherent valide ");
						list.add(nom);
						list.add(prenom);
						list.add(adhesion);
						for (int i = 0; i <  adh.getMeslivres().size(); i++) {
							list_1.add("ISBN : "+adh.getMeslivres().get(i).getISBN()+"  Titre : "+adh.getMeslivres().get(i).getTitre()+"  Prix : "+adh.getMeslivres().get(i).getPrix());	
						}
					}
				}
			}
		});
	}
}

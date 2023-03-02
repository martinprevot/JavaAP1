package view;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import controller.main;
import model.ADHERENT;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Window4 {

	private static JFrame frame;
	private JTextField id;
	private JTextField nom;
	private JTextField prenom;
	private JTextField textField;


	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window4 window = new Window4();
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
	public Window4() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextPane txtpnEntrerVosInformations = new JTextPane();
		txtpnEntrerVosInformations.setEditable(false);
		txtpnEntrerVosInformations.setText("Remplissez ce formulaire :");
		txtpnEntrerVosInformations.setBounds(132, 11, 169, 19);
		frame.getContentPane().add(txtpnEntrerVosInformations);

		id = new JTextField();
		id.setBounds(188, 59, 114, 19);
		frame.getContentPane().add(id);
		id.setColumns(10);

		nom = new JTextField();
		nom.setBounds(188, 91, 114, 19);
		frame.getContentPane().add(nom);
		nom.setColumns(10);

		prenom = new JTextField();
		prenom.setBounds(188, 121, 114, 19);
		frame.getContentPane().add(prenom);
		prenom.setColumns(10);

		JTextPane txtpnId = new JTextPane();
		txtpnId.setEditable(false);
		txtpnId.setText("id :");
		txtpnId.setBounds(132, 57, 46, 21);
		frame.getContentPane().add(txtpnId);

		JTextPane txtpnNom = new JTextPane();
		txtpnNom.setEditable(false);
		txtpnNom.setText("nom :");
		txtpnNom.setBounds(132, 89, 46, 21);
		frame.getContentPane().add(txtpnNom);

		JTextPane txtpnPrenom = new JTextPane();
		txtpnPrenom.setEditable(false);
		txtpnPrenom.setText("prenom :");
		txtpnPrenom.setBounds(117, 121, 63, 21);
		frame.getContentPane().add(txtpnPrenom);

		JButton btnValiderVosInformations = new JButton("");
		btnValiderVosInformations.setIcon(new ImageIcon("C:\\Users\\marti\\Desktop\\eclipse_workspace\\AP1\\img\\buttonValider1.png"));

		btnValiderVosInformations.setBounds(327, 219, 97, 25);
		frame.getContentPane().add(btnValiderVosInformations);

		JButton btnRetour = new JButton("");
		Image img = new ImageIcon(this.getClass().getResource("/Go-back-icon.png")).getImage();
		Image newImage  = img.getScaledInstance(15, 15, Image.SCALE_DEFAULT);
		btnRetour.setIcon(new ImageIcon("C:\\Users\\marti\\Desktop\\eclipse_workspace\\AP1\\img\\buttonRetour.png"));
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window7 window = new Window7();
				frame.setVisible(false);
			}
		});
		btnRetour.setBounds(10, 211, 114, 39);
		frame.getContentPane().add(btnRetour);

		JTextPane txtpnEmail = new JTextPane();
		txtpnEmail.setText("Email :");
		txtpnEmail.setEditable(false);
		txtpnEmail.setBounds(117, 153, 63, 21);
		frame.getContentPane().add(txtpnEmail);

		textField = new JTextField();
		textField.setBounds(188, 151, 114, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Adherent créer !");
		lblNewLabel.setBounds(151, 185, 232, 14);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setVisible(false);
		btnValiderVosInformations.setBorder(null); 
		btnValiderVosInformations.setContentAreaFilled(false); 
		btnRetour.setBorder(null); 
		btnRetour.setContentAreaFilled(false); 

		btnValiderVosInformations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id.getText().isEmpty()|	textField.getText().isEmpty()|	prenom.getText().isEmpty()|	nom.getText().isEmpty()) {
					lblNewLabel.setText("Erreur")	;
					lblNewLabel.setVisible(true);

				} 
				else {

					ADHERENT test = main.getM().findadherent(Integer.parseInt(id.getText()));
					if (test== null){
						try {
							main.getM().creeradh(id.getText(), prenom.getText(), nom.getText(),textField.getText());
							lblNewLabel.setText("Adherent créer !");
							lblNewLabel.setVisible(true);
						} catch (ClassNotFoundException e1) {
							e1.printStackTrace();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
					else {
						lblNewLabel.setText("L'adherent n°"+id.getText()+" existe déja.");
						lblNewLabel.setVisible(true);
					}
				}
			}

		});
	}
}

package view;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import controller.main;

import javax.swing.JTextField;
import java.awt.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Window9 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window9 window = new Window9();
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
	public Window9() {
		try {
			main.getM().getALL();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

		JLabel lblNewLabel = new JLabel("Nom :");
		lblNewLabel.setBounds(39, 79, 46, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Prenom :");
		lblNewLabel_1.setBounds(29, 104, 72, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Description :");
		lblNewLabel_2.setBounds(10, 129, 91, 14);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("id :");
		lblNewLabel_3.setBounds(55, 54, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);

		textField = new JTextField();
		textField.setBounds(105, 101, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(105, 76, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(105, 48, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(105, 126, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		List list = new List();
		list.setBounds(289, 54, 135, 122);
		frame.getContentPane().add(list);
		for (int i = 0; i <  main.getM().getAu().size(); i++) {
			list.add((main.getM().getAu().get(i).Ligne()));
		}


		JLabel lblNewLabel_4 = new JLabel("Auteur déja present :");
		lblNewLabel_4.setBounds(299, 34, 135, 14);
		frame.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Auteur ajouté !");
		lblNewLabel_5.setEnabled(false);
		lblNewLabel_5.setBounds(192, 243, 242, 14);
		frame.getContentPane().add(lblNewLabel_5);
		lblNewLabel_5.setVisible(false);
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\marti\\Desktop\\eclipse_workspace\\AP1\\img\\buttonValider1.png"));
		btnNewButton.setBounds(312, 209, 89, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("");
		Image img = new ImageIcon(this.getClass().getResource("/Go-back-icon.png")).getImage();
		Image newImage  = img.getScaledInstance(15, 15, Image.SCALE_DEFAULT);
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\marti\\Desktop\\eclipse_workspace\\AP1\\img\\buttonRetour.png"));
		btnNewButton_1.setBorder(null); 
		btnNewButton_1.setContentAreaFilled(false); 
		btnNewButton.setBorder(null); 
		btnNewButton.setContentAreaFilled(false); 

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Window7 vca = new Window7();
				frame.setVisible(false);

			}
		});
		btnNewButton_1.setBounds(10, 211, 110, 39);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_2.getText().isEmpty()|	textField.getText().isEmpty()|	textField_1.getText().isEmpty()|	textField_3.getText().isEmpty()) {
					lblNewLabel_5.setText("Erreur")	;
					lblNewLabel_5.setVisible(true);

				} 
				else {
					if (main.getM().findauteur(textField_2.getText()) != null) {
						lblNewLabel_5.setVisible(true);
						lblNewLabel_5.setText("Duplicata de numéro")	;
					}
					else {


						try {
							controller.main.getM().ajouterAuteur(Integer.parseInt(textField_2.getText()), textField_1.getText(), textField.getText(), textField_3.getText());
							lblNewLabel_5.setVisible(true);
							lblNewLabel_5.setText("Auteur ajouté")	;

						} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			}

		});





	}
}

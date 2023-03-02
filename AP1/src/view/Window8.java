package view;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.main;
import model.model;

import javax.swing.ComboBoxEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.List;
import javax.swing.JSpinner;
import java.awt.Choice;
import java.awt.Label;

public class Window8 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window8 window = new Window8();
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
	public Window8() {
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

		JLabel lblNewLabel = new JLabel("Ajouter un livre ");
		lblNewLabel.setBounds(321, 11, 187, 14);
		frame.getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(114, 55, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(114, 86, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(114, 117, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("ISBN :");
		lblNewLabel_1.setBounds(46, 58, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Titre :");
		lblNewLabel_2.setBounds(46, 89, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Prix :");
		lblNewLabel_3.setBounds(46, 120, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Auteur :");
		lblNewLabel_4.setBounds(46, 163, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);

		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\marti\\Desktop\\eclipse_workspace\\AP1\\img\\buttonValider1.png"));

		btnNewButton.setBounds(321, 214, 89, 36);
		frame.getContentPane().add(btnNewButton);

		Choice choice = new Choice();
		choice.setBounds(114, 157, 133, 71);
		frame.getContentPane().add(choice);

		Label label = new Label("Livre ajouter");
		label.setEnabled(false);
		label.setVisible(false);

		label.setBounds(124, 183, 168, 22);
		frame.getContentPane().add(label);

		JButton btnNewButton_1 = new JButton("");
		Image img = new ImageIcon(this.getClass().getResource("/Go-back-icon.png")).getImage();
		Image newImage  = img.getScaledInstance(15, 15, Image.SCALE_DEFAULT);
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\marti\\Desktop\\eclipse_workspace\\AP1\\img\\buttonRetour.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Window7 vca = new Window7();
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(10, 214, 117, 36);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.setBorder(null); 
		btnNewButton_1.setContentAreaFilled(false); 
		btnNewButton.setBorder(null); 
		btnNewButton.setContentAreaFilled(false); 


		for (int i = 0; i <  main.getM().getAu().size(); i++) {
			choice.add((main.getM().getAu().get(i).Ligne()));
		}

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{				
				if(textField_2.getText().isEmpty()|	textField.getText().isEmpty()|	textField_1.getText().isEmpty()) {
					label.setText("Erreur")	;
					label.setVisible(true);

				} 
				else {
					if (main.getM().findlivre(textField.getText())!= null) {

						label.setVisible(true);
						label.setText("Duplicata d'ISBN");
					}
					else {
						String test = main.getM().getAu().get(choice.getSelectedIndex()).getNum();
						try {
							controller.main.getM().ajouterLivre(Integer.parseInt(textField.getText()), textField_1.getText(), Integer.parseInt(textField_2.getText()),Integer.parseInt(test));
						} catch (NumberFormatException e1) {
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							e1.printStackTrace();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						label.setVisible(true);
						label.setText("Livre ajouter !");

					}
				}

			}	
		});

	}
}

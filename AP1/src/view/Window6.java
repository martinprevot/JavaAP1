package view;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.TextField;

public class Window6 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window6 window = new Window6();
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
	public Window6() {
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

		JButton btnNewButton = new JButton("");
		Image img = new ImageIcon(this.getClass().getResource("/Go-back-icon.png")).getImage();
		Image newImage  = img.getScaledInstance(15, 15, Image.SCALE_DEFAULT);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\marti\\Desktop\\eclipse_workspace\\AP1\\img\\buttonRetour.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				BIBLIOTEQUE window = new BIBLIOTEQUE();
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 213, 126, 37);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Login :");
		lblNewLabel.setBounds(227, 90, 46, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Mot de passe :");
		lblNewLabel_1.setBounds(183, 125, 90, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\marti\\Desktop\\eclipse_workspace\\AP1\\img\\buttonValider1.png"));
	
		btnNewButton_1.setBounds(301, 199, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		TextField textField = new TextField();
		textField.setBounds(279, 90, 72, 22);
		frame.getContentPane().add(textField);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(279, 125, 67, 22);
		frame.getContentPane().add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mot de passe ou login incorrect");
		lblNewLabel_2.setBounds(227, 163, 208, 14);
		lblNewLabel_2.setVisible(false);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/login2.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img1));
		lblNewLabel_3.setBounds(44, 59, 183, 143);
		frame.getContentPane().add(lblNewLabel_3);
		btnNewButton_1.setBorder(null); 
		btnNewButton_1.setContentAreaFilled(false); 
		btnNewButton.setBorder(null); 
		btnNewButton.setContentAreaFilled(false); 
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String test =  "test";
				
				if ( test.equals(textField.getText()) &&  test.equals(textField_1.getText())) {
					
					Window7 vca = new Window7();
					frame.setVisible(false);
					
					
				}
				else {
					lblNewLabel_2.setVisible(true);
					
					
				}

			}
		});
	}
}

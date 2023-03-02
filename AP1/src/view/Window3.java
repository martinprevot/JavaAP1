package view;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JTextField;

import controller.main;
import model.LIVRE;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Window3 {

	private static JFrame frame;
	private JTextField txtTest;
	private JLabel lblNewLabel;
	private JButton btnRetour;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window3 window = new Window3();
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
	public Window3() throws ClassNotFoundException, SQLException {
		initialize();
		main.getM().getALL();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txtTest = new JTextField();
		txtTest.setBounds(198, 74, 114, 19);
		frame.getContentPane().add(txtTest);
		txtTest.setColumns(10);

		JLabel lblIsbnDuLivre = new JLabel("ISBN du livre :");
		lblIsbnDuLivre.setBounds(73, 77, 126, 15);
		frame.getContentPane().add(lblIsbnDuLivre);

		JButton btnRestituer = new JButton("");
		btnRestituer.setIcon(new ImageIcon("C:\\Users\\marti\\Desktop\\eclipse_workspace\\AP1\\img\\buttonRestituer.png"));

		btnRestituer.setBounds(136, 116, 114, 31);
		frame.getContentPane().add(btnRestituer);

		lblNewLabel = new JLabel("");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setBounds(327, 179, 70, 15);
		frame.getContentPane().add(lblNewLabel);

		btnRetour = new JButton("");
		Image img = new ImageIcon(this.getClass().getResource("/Go-back-icon.png")).getImage();
		Image newImage  = img.getScaledInstance(15, 15, Image.SCALE_DEFAULT);
		btnRetour.setIcon(new ImageIcon("C:\\Users\\marti\\Desktop\\eclipse_workspace\\AP1\\img\\buttonRetour.png"));

		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				BIBLIOTEQUE window = new BIBLIOTEQUE();
				window.frame.setVisible(true);
				try {
					Window3.frame.setVisible(false);
				} catch (Exception e1) {
					e1.printStackTrace();
				}			
			}
		});
		btnRetour.setBounds(12, 217, 126, 41);
		frame.getContentPane().add(btnRetour);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setVisible(false);
		lblNewLabel_1.setBounds(88, 158, 300, 14);
		frame.getContentPane().add(lblNewLabel_1);
		btnRetour.setBorder(null); 
		btnRetour.setContentAreaFilled(false); 
		btnRestituer.setBorder(null); 
		btnRestituer.setContentAreaFilled(false); 
		btnRestituer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LIVRE livre ;
				try {
					main.getM().getALL();
					livre = main.getM().findlivre(txtTest.getText());
					if(livre == null)
					{
						lblNewLabel_1.setVisible(true);
						lblNewLabel_1.setText("ISBN Inconnue.");
					}
					else {
						if(livre.getEmprunteur()==null){
							lblNewLabel_1.setVisible(true);
							lblNewLabel_1.setText("Le livre à déja été restituer.");							
						}
						else
						{
							lblNewLabel_1.setText("Livre bien restituer.");
							lblNewLabel_1.setVisible(true);
							livre.setEmprunteur(null);
							main.getM().Restituer(livre.getISBN());
							main.getM().getALL();
						}
					}
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
	}
}

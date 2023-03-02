package view;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JPanel;

public class BIBLIOTEQUE {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BIBLIOTEQUE window = new BIBLIOTEQUE();
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
	public BIBLIOTEQUE() {

		initialize();
		frame.setBackground(Color.black);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JButton restituer = new JButton("");
		restituer.setIcon(new ImageIcon("C:\\Users\\marti\\Desktop\\eclipse_workspace\\AP1\\img\\buttonAcceuilRestituer.png"));
		JButton search = new JButton("");
		search.setIcon(new ImageIcon("C:\\Users\\marti\\Desktop\\eclipse_workspace\\AP1\\img\\buttonRechercher.png"));
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Window5 nw = new Window5();
					frame.setVisible(false);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});


		frame = new JFrame();
		frame.setBounds(100, 100, 450, 293);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		restituer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Window3 nw = null;
				try {
					nw = new  Window3();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				nw.NewScreen();
				frame.setVisible(false);


			}
		});
		restituer.setBounds(216, 17, 155, 57);
		frame.getContentPane().add(restituer);

		search.setBounds(35, 85, 155, 57);
		frame.getContentPane().add(search);
		JButton emprunter = new JButton("");
		emprunter.setIcon(new ImageIcon("C:\\Users\\marti\\Desktop\\eclipse_workspace\\AP1\\img\\buttonEmprunt.png"));
		emprunter.setBounds(35, 17, 155, 57);
		frame.getContentPane().add(emprunter);
		restituer.setBorder(null); 
		restituer.setContentAreaFilled(false); 

		JButton btnEspaceAdmin = new JButton("");
		btnEspaceAdmin.setIcon(new ImageIcon("C:\\Users\\marti\\Desktop\\eclipse_workspace\\AP1\\img\\buttonEspaceAdmin.png"));
		btnEspaceAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Window6 nw = new Window6();
				frame.setVisible(false);

			}
		});
		btnEspaceAdmin.setBounds(10, 214, 113, 29);
		frame.getContentPane().add(btnEspaceAdmin);

		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\marti\\Desktop\\eclipse_workspace\\AP1\\img\\buttonInfo.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Window10 nw = new Window10();
				frame.setVisible(false);

			}
		});
		btnNewButton.setBounds(216, 85, 155, 63);
		frame.getContentPane().add(btnNewButton);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(288, 146, 161, 108);
		frame.getContentPane().add(lblNewLabel);

		Image img = new ImageIcon(this.getClass().getResource("/book.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		JLabel lblNewLabel_1 = new JLabel("<html><font color=\"red\">Première partie de texte</font></html>");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setBounds(10, 159, 211, 48);
		frame.getContentPane().add(lblNewLabel_1);
		emprunter.setBorder(null); 
		emprunter.setContentAreaFilled(false); 
		search.setBorder(null); 
		search.setContentAreaFilled(false); 
		btnNewButton.setBorder(null); 
		btnNewButton.setContentAreaFilled(false); 
		btnEspaceAdmin.setBorder(null); 
		btnEspaceAdmin.setContentAreaFilled(false); 

		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				if (lblNewLabel_1.getBounds().x > 120) {
					lblNewLabel_1.setBounds(1,159,211,48);
				}
				else {
					lblNewLabel_1.setBounds(lblNewLabel_1.getBounds().x+2, 159, 211, 48);

				}
			};
		};
		timer.schedule(task, 100,100);





		emprunter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window2 nw = null;
				try {
					nw = new  Window2();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				nw.NewScreen();
				frame.setVisible(false);


			}
		});
	}
}

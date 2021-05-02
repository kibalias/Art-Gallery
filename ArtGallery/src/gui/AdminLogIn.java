package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminLogIn extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField UsernametextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogIn frame = new AdminLogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminLogIn() {
		setBackground(new Color(105, 105, 105));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setLayout(null);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel ArtLabel = new JLabel("ART");
		ArtLabel.setForeground(new Color(165, 42, 42));
		ArtLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		ArtLabel.setBounds(25, 71, 104, 43);
		panel.add(ArtLabel);
		
		
		JLabel lblGalleria = new JLabel("GALLERIA");
		lblGalleria.setForeground(new Color(128, 0, 0));
		lblGalleria.setFont(new Font("Bookman Old Style", Font.BOLD, 26));
		lblGalleria.setBounds(25, 96, 148, 43);
		panel.add(lblGalleria);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(new Color(128, 0, 0));
		separator.setForeground(new Color(128, 0, 0));
		separator.setBounds(185, 11, 13, 229);
		panel.add(separator);
		
		JLabel lblUserName = new JLabel("Username");
		lblUserName.setFont(new Font("Arial", Font.PLAIN, 12));
		lblUserName.setBounds(203, 93, 59, 14);
		panel.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPassword.setBounds(203, 142, 59, 14);
		panel.add(lblPassword);
		
		UsernametextField = new JTextField();
		UsernametextField.setFont(new Font("Tahoma", Font.PLAIN, 9));
		UsernametextField.setBounds(266, 89, 133, 20);
		panel.add(UsernametextField);
		UsernametextField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(266, 139, 133, 20);
		panel.add(passwordField);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String username = UsernametextField.getText();
				String password = String.valueOf(passwordField.getPassword());
				
				try {
					if(username.equals("AdminGalleria") && password.equals("amTheNextDaVinci2k21")) {
						setVisible(false);
						Artworks frame = new Artworks();
						frame.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Wrong username and password. Try Again.");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnLogIn.setBounds(276, 179, 68, 23);
		panel.add(btnLogIn);
	}
}

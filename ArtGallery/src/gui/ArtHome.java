package gui;
/*
 * NOTE: This is just to test the redirecting of a Frame to another frame.
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ArtHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArtHome frame = new ArtHome();
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
	public ArtHome() {
		setForeground(new Color(0, 0, 0));
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAppName = new JLabel("Art Galleria");
		lblAppName.setBounds(131, 40, 179, 36);
		lblAppName.setForeground(new Color(102, 0, 0));
		lblAppName.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		lblAppName.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblAppName);
		
		JLabel lblLogInNewLabel = new JLabel("Log-in");
		lblLogInNewLabel.setBounds(192, 87, 47, 23);
		lblLogInNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogInNewLabel.setBackground(Color.WHITE);
		lblLogInNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		contentPane.add(lblLogInNewLabel);
		
		JButton btnAdminNewButton = new JButton("Admin");
		btnAdminNewButton.setBounds(162, 121, 105, 29);
		btnAdminNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdminNewButton.setForeground(new Color(102, 0, 0));
		btnAdminNewButton.setBackground(new Color(255, 255, 255));
		btnAdminNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(btnAdminNewButton);
		
		JButton btnViewer = new JButton("Viewer");
		btnViewer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnViewer.setBounds(162, 160, 105, 29);
		btnViewer.setForeground(new Color(102, 0, 0));
		btnViewer.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnViewer.setBackground(Color.WHITE);
		contentPane.add(btnViewer);
		btnViewer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Viewer frame = new Viewer();
				frame.setVisible(true);
			}
		});
		btnAdminNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Artworks frame = new Artworks();
				frame.setVisible(true);
			}
		});
	}
}

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

import gui.Main;
import javax.swing.SwingConstants;

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnAdminNewButton = new JButton("Admin");
		btnAdminNewButton.setBackground(new Color(255, 255, 255));
		btnAdminNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(btnAdminNewButton);
		btnAdminNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Artworks frame = new Artworks();
				frame.setVisible(true);
			}
		});
		btnAdminNewButton.setBounds(162, 96, 121, 31);
		
		JLabel lblLogInNewLabel = new JLabel("Log-in");
		lblLogInNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogInNewLabel.setBackground(Color.WHITE);
		lblLogInNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		lblLogInNewLabel.setBounds(192, 72, 61, 23);
		contentPane.add(lblLogInNewLabel);
		
		JLabel lblAppName = new JLabel("Art Galleria");
		lblAppName.setForeground(new Color(102, 0, 0));
		lblAppName.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		lblAppName.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppName.setBounds(90, 11, 278, 50);
		contentPane.add(lblAppName);
		
		JButton btnViewer = new JButton("Viewer");
		btnViewer.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnViewer.setBackground(Color.WHITE);
		btnViewer.setBounds(162, 138, 121, 31);
		contentPane.add(btnViewer);
		btnViewer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Viewer frame = new Viewer();
				frame.setVisible(true);
			}
		});
	}
}

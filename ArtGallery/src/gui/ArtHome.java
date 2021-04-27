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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnAdminNewButton = new JButton("Admin");
		btnAdminNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnAdminNewButton);
		btnAdminNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Main mainFrame = new Main();
				mainFrame.setVisible(true);
			}
		});
		btnAdminNewButton.setBounds(162, 96, 121, 31);
		
		JLabel lblLogInNewLabel = new JLabel("Log-in");
		lblLogInNewLabel.setBackground(Color.WHITE);
		lblLogInNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		lblLogInNewLabel.setBounds(200, 72, 61, 23);
		contentPane.add(lblLogInNewLabel);
	}
}

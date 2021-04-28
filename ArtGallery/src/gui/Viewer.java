package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Viewer extends JFrame {

	private JPanel contentPane;
	private JTextField txtFldTitle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Viewer frame = new Viewer();
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
	public Viewer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Art Galleria");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(102, 0, 0));
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		lblNewLabel.setBounds(218, 0, 260, 60);
		contentPane.add(lblNewLabel);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBackground(new Color(102, 102, 102));
		searchPanel.setBounds(30, 83, 227, 291);
		contentPane.add(searchPanel);
		searchPanel.setLayout(null);
		
		JLabel lblArtTitle = new JLabel("Art Title :");
		lblArtTitle.setForeground(new Color(255, 255, 255));
		lblArtTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblArtTitle.setBounds(10, 50, 64, 17);
		searchPanel.add(lblArtTitle);
		
		txtFldTitle = new JTextField();
		txtFldTitle.setBounds(77, 49, 131, 23);
		txtFldTitle.setColumns(10);
		searchPanel.add(txtFldTitle);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(255, 255, 255));
		btnSearch.setBounds(128, 82, 80, 23);
		searchPanel.add(btnSearch);
		
		
	}
}

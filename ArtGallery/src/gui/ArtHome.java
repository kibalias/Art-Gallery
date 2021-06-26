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
import javax.swing.ImageIcon;

import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;

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
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegistryNewButton = new JButton("Registry");
		btnRegistryNewButton.setForeground(new Color(139, 0, 0));
		btnRegistryNewButton.setBackground(new Color(255, 255, 255));
		btnRegistryNewButton.setBounds(282, 144, 119, 47);
		btnRegistryNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegistryNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(btnRegistryNewButton);
		
		JButton btnViewer = new JButton("Logs");
		
		btnViewer.setForeground(new Color(139, 0, 0));
		btnViewer.setBackground(new Color(255, 255, 255));
		btnViewer.setBounds(282, 91, 119, 42);
		btnViewer.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(btnViewer);
		
		JPanel Imgpanel = new JPanel();
		Imgpanel.setBackground(Color.WHITE);
		Imgpanel.setBorder(new LineBorder(new Color(128, 0, 0)));
		Imgpanel.setBounds(32, 37, 165, 185);
		contentPane.add(Imgpanel);
		Imgpanel.setLayout(null);
		
		JLabel lblImage = new JLabel("");
		Image logo = new ImageIcon(getClass().getResource("./AG120x170.png")).getImage();
		lblImage.setIcon(new ImageIcon(logo));
		/*ImageIcon logo = createImageIcon("/ArtGalleria200x300px.png");
		lblImage.setIcon(logo);*/
		lblImage.setBounds(18, 11, 129, 163);
		Imgpanel.add(lblImage);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(128, 0, 0));
		separator.setForeground(new Color(128, 0, 0));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(234, 11, 30, 239);
		contentPane.add(separator);
		
		
		btnViewer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Logs frame = new Logs();
				frame.setVisible(true);
			}
		
		});
		btnRegistryNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Artworks frame = new Artworks();
				frame.setVisible(true);
				
			}
		});
	}
}

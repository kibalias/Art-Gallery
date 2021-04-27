package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import value.ArtworksValues;
import CRUDStatements.ArtworksCRUD;
import exe.ArtworksTemplate;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JScrollBar;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.ListSelectionModel;
/*
 * Mainframe for inputting and editing data. 
 * P.S.This is just a sample.
 * */
public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField ArtCodetextField;
	private JTextField ArtTitletextField;
	private JTextField ArtStyletextField;
	private JTextField YearOfMakingtextField;
	private JTextField ArtPricetextField;
	private JTextField ArtisttextField;
	private JTextField ArtStatustextField;
	private JTable ArtworksTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JLabel lblArtCode = new JLabel("Art Code");
		lblArtCode.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		contentPane.add(lblArtCode);
		lblArtCode.setBounds(20, 26, 86, 19);
		
		ArtCodetextField = new JTextField();
		ArtCodetextField.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		ArtCodetextField.setBounds(155, 25, 159, 20);
		contentPane.add(ArtCodetextField);
		ArtCodetextField.setColumns(10);
		
		JLabel lblArtTitle = new JLabel("Art Title");
		lblArtTitle.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		contentPane.add(lblArtTitle);
		lblArtTitle.setBounds(20, 56, 86, 19);
		
		ArtTitletextField = new JTextField();
		ArtTitletextField.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		ArtTitletextField.setColumns(10);
		ArtTitletextField.setBounds(155, 56, 159, 20);
		contentPane.add(ArtTitletextField);
		
		JLabel lblArtStyle = new JLabel("Art Style");
		lblArtStyle.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		contentPane.add(lblArtStyle);
		lblArtStyle.setBounds(20, 86, 86, 19);
		
		ArtStyletextField = new JTextField();
		ArtStyletextField.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		ArtStyletextField.setColumns(10);
		ArtStyletextField.setBounds(155, 87, 159, 20);
		contentPane.add(ArtStyletextField);
		
		JLabel lblYearOfMaking = new JLabel("Year of Making");
		lblYearOfMaking.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		contentPane.add(lblYearOfMaking);
		lblYearOfMaking.setBounds(20, 119, 101, 19);
		
		YearOfMakingtextField = new JTextField();
		YearOfMakingtextField.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		YearOfMakingtextField.setColumns(10);
		YearOfMakingtextField.setBounds(155, 118, 159, 20);
		contentPane.add(YearOfMakingtextField);
		
		JLabel lblArtist = new JLabel("Artist");
		lblArtist.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		contentPane.add(lblArtist);
		lblArtist.setBounds(20, 149, 86, 19);
		
		ArtisttextField = new JTextField();
		ArtisttextField.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		ArtisttextField.setColumns(10);
		ArtisttextField.setBounds(155, 149, 159, 20);
		contentPane.add(ArtisttextField);
		
		JLabel lblArtStatus = new JLabel("Art Status");
		lblArtStatus.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblArtStatus.setBounds(20, 179, 86, 19);
		contentPane.add(lblArtStatus);
		
		ArtStatustextField = new JTextField();
		ArtStatustextField.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		ArtStatustextField.setColumns(10);
		ArtStatustextField.setBounds(155, 180, 159, 20);
		contentPane.add(ArtStatustextField);
		
		JLabel lblArtPrice = new JLabel("Art Price");
		lblArtPrice.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		contentPane.add(lblArtPrice);
		lblArtPrice.setBounds(20, 215, 86, 19);
		
		ArtPricetextField = new JTextField();
		ArtPricetextField.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		ArtPricetextField.setColumns(10);
		ArtPricetextField.setBounds(155, 211, 159, 20);
		contentPane.add(ArtPricetextField);
		
		//save button	
		JButton btnAddButton = new JButton("ADD");
		btnAddButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ArtworksValues artworks = new ArtworksValues();
				
				boolean isFilled = !ArtCodetextField.getText().equals("") && !ArtTitletextField.getText().equals("")
									&& !YearOfMakingtextField.getText().equals("") && !ArtisttextField.getText().equals("")
									&& !ArtPricetextField.getText().equals(""); //fields that needs to be filled out
				
				try {
					if(isFilled) {
						
					//setting the values
						artworks.setArtCode(ArtCodetextField.getText());
						artworks.setArtTitle(ArtTitletextField.getText());
						artworks.setArtStyle(ArtStyletextField.getText());
						artworks.setYearOfMaking(YearOfMakingtextField.getText());
						artworks.setArtist(ArtisttextField.getText());
						artworks.setArtStatus(ArtStatustextField.getText());
						artworks.setArtPrice(Float.parseFloat(ArtPricetextField.getText()));
						
						JOptionPane.showMessageDialog(null, ArtworksTemplate.rowCheck(artworks));
						setVisible(false);
						Main frame = new Main();
						frame.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Not saved. Input Required Fields.");
						}
					} catch (Exception e1) {
					e1.printStackTrace();
				}
			} 
		});
		btnAddButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		btnAddButton.setBounds(202, 235, 68, 23);
		contentPane.add(btnAddButton);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBackground(Color.DARK_GRAY);
		tablePanel.setBounds(342, 26, 312, 208);
		contentPane.add(tablePanel);
		tablePanel.setLayout(null);
		
		ArtworksTable = new JTable();
		ArtworksTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ArtworksTable.setBounds(0, 0, 312, 208);
		ArtworksTable.setBackground(Color.WHITE);
		tablePanel.add(ArtworksTable);
		
		//Display data in table
		String[] columnNames = {"Art Code", "Art Title", "Art Style", "Year of Making", 
								"Artist", "Art Status", "Art Price"};
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		tableModel.addRow(columnNames);
		ArtworksTemplate.readData(tableModel);
		ArtworksTable.setModel(tableModel);
		
	}
}

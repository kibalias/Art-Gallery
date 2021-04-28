package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import exe.ArtworksTemplate;
import value.ArtworksValues;
import CRUDStatements.ArtworksCRUD;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Artworks extends JFrame {

	private JPanel contentPane;
	private JTextField ArtCodetextField;
	private JTextField ArtTitletextField;
	private JTextField ArtStyletextField;
	private JTextField YearOfMakingtextField;
	private JTextField ArtisttextField;
	private JTextField ArtStatustextField;
	private JTextField ArtPricetextField;
	private JTable Artworkstable;
	
	ArtworksCRUD artworkCRUD = new ArtworksCRUD();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Artworks frame = new Artworks();
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
	public Artworks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 943, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelHolder = new JPanel();
		panelHolder.setLayout(null);
		contentPane.add(panelHolder);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(32, 96, 372, 307);
		panel.setLayout(null);
		panelHolder.add(panel);
		
		JLabel ArtGalleriaLabel = new JLabel("ART GALLERIA");
		ArtGalleriaLabel.setForeground(new Color(128, 0, 0));
		ArtGalleriaLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		ArtGalleriaLabel.setBounds(306, 0, 271, 43);
		panelHolder.add(ArtGalleriaLabel);
		
		JLabel DatabaseLabel = new JLabel("DATABASE");
		DatabaseLabel.setForeground(new Color(0, 0, 0));
		DatabaseLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
		DatabaseLabel.setBounds(367, 24, 121, 43);
		panelHolder.add(DatabaseLabel);
		
//Button to redirect to Artist GUI	
		JButton btnArtist = new JButton("Artist");
		btnArtist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				setVisible(false);
				Artist frame = new Artist();
				frame.setVisible(true);
				*/
			}
		});
		btnArtist.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnArtist.setBounds(601, 69, 89, 23);
		panelHolder.add(btnArtist);
		
//Button to redirect to Buyer GUI
		JButton btnBuyer = new JButton("Buyer");
		btnBuyer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				setVisible(false);
				Buyer frame = new Buyer();
				frame.setVisible(true);
				*/
			}
		});
		btnBuyer.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnBuyer.setBounds(701, 69, 89, 23);
		panelHolder.add(btnBuyer);
		
//Button to redirect to Buyer Cart GUI
		JButton btnBuyerCart = new JButton("Buyer Cart");
		btnBuyerCart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				setVisible(false);
				BuyerCart frame = new BuyerCart();
				frame.setVisible(true);
				*/
			}
		});
		btnBuyerCart.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnBuyerCart.setBounds(799, 69, 89, 23);
		panelHolder.add(btnBuyerCart);
		
		JLabel lblArtCode = new JLabel("Art Code");
		lblArtCode.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblArtCode.setBounds(27, 35, 79, 31);
		panel.add(lblArtCode);
		
		ArtCodetextField = new JTextField();
		ArtCodetextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		ArtCodetextField.setBounds(145, 33, 185, 25);
		panel.add(ArtCodetextField);
		ArtCodetextField.setColumns(10);
		
		JLabel lblArtTitle = new JLabel("Art Title");
		lblArtTitle.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblArtTitle.setBounds(27, 70, 79, 31);
		panel.add(lblArtTitle);
		
		ArtTitletextField = new JTextField();
		ArtTitletextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		ArtTitletextField.setBounds(145, 69, 185, 25);
		panel.add(ArtTitletextField);
		ArtTitletextField.setColumns(10);
		
		JLabel lblArtStyle = new JLabel("Art Style");
		lblArtStyle.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblArtStyle.setBounds(27, 105, 79, 31);
		panel.add(lblArtStyle);
		
		ArtStyletextField = new JTextField();
		ArtStyletextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		ArtStyletextField.setColumns(10);
		ArtStyletextField.setBounds(145, 105, 185, 25);
		panel.add(ArtStyletextField);
		
		JLabel lblYearOfMaking = new JLabel("Year of Making");
		lblYearOfMaking.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblYearOfMaking.setBounds(27, 143, 92, 31);
		panel.add(lblYearOfMaking);
		
		YearOfMakingtextField = new JTextField();
		YearOfMakingtextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		YearOfMakingtextField.setColumns(10);
		YearOfMakingtextField.setBounds(145, 141, 185, 25);
		panel.add(YearOfMakingtextField);
		
		JLabel lblArtist = new JLabel("Artist");
		lblArtist.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblArtist.setBounds(27, 179, 92, 31);
		panel.add(lblArtist);
		
		ArtisttextField = new JTextField();
		ArtisttextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		ArtisttextField.setColumns(10);
		ArtisttextField.setBounds(145, 177, 185, 25);
		panel.add(ArtisttextField);
		
		JLabel lblArtStatus = new JLabel("Art Status");
		lblArtStatus.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblArtStatus.setBounds(27, 215, 92, 31);
		panel.add(lblArtStatus);
		
		ArtStatustextField = new JTextField();
		ArtStatustextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		ArtStatustextField.setColumns(10);
		ArtStatustextField.setBounds(145, 213, 185, 25);
		panel.add(ArtStatustextField);
		
		JLabel lblArtPrice = new JLabel("Art Price");
		lblArtPrice.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblArtPrice.setBounds(27, 250, 92, 31);
		panel.add(lblArtPrice);
		
		ArtPricetextField = new JTextField();
		ArtPricetextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		ArtPricetextField.setColumns(10);
		ArtPricetextField.setBounds(145, 249, 185, 25);
		panel.add(ArtPricetextField);
		
		JLabel lblArtworksLabel = new JLabel("ARTWORKS");
		lblArtworksLabel.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
		lblArtworksLabel.setBounds(32, 71, 122, 21);
		panelHolder.add(lblArtworksLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(435, 96, 453, 307);
		panelHolder.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		Artworkstable = new JTable();
		Artworkstable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Artworkstable.setBackground(Color.WHITE);
		Artworkstable.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.add(Artworkstable);
		
		//Display data in table
		String[] columnNames = {"Art Code", "Art Title", "Art Style", "Year of Making", 
								"Artist", "Art Status", "Art Price"};
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		tableModel.addRow(columnNames);
		ArtworksTemplate.readData(tableModel);
		Artworkstable.setModel(tableModel);

//Add Button
		JButton btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
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
						Artworks frame = new Artworks();
						frame.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Not saved. Input Required Fields.");
						}
					} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAdd.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		btnAdd.setBounds(63, 414, 89, 26);
		panelHolder.add(btnAdd);
		
//Save Button
		JButton btnSave = new JButton("Save");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnSave.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		btnSave.setBounds(180, 414, 89, 26);
		panelHolder.add(btnSave);
		
//Discard Button
		JButton btnDiscard = new JButton("Discard");
		btnDiscard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				JOptionPane.showMessageDialog(null, "Sucessfully Discarded Changes.");
				Artworks frame = new Artworks();
				frame.setVisible(true);
			}
		});
		btnDiscard.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		btnDiscard.setBounds(294, 414, 89, 26);
		panelHolder.add(btnDiscard);
		
//Edit Button
		JButton btnEdit = new JButton("Edit");
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnEdit.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		btnEdit.setBounds(539, 414, 89, 26);
		panelHolder.add(btnEdit);
		
//Delete Button
		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int rowIndex = Artworkstable.getSelectedRow();
				
				if(rowIndex == -1) {
					JOptionPane.showMessageDialog(
							null,
							"Please select an item first.",
							"Warning",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(JOptionPane.showConfirmDialog(null, "Are you sure?") == JOptionPane.YES_OPTION) {
				
				String toDelete = tableModel.getValueAt(rowIndex, 0).toString();
				
				artworkCRUD.Delete(toDelete);
				Artworks frame = new Artworks();
				frame.setVisible(true);
				}
				
			}
		});
		btnDelete.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		btnDelete.setBounds(701, 414, 89, 26);
		panelHolder.add(btnDelete);
		
//Back To Menu Button
		JButton btnBackToMenu = new JButton("Back to Menu");
		btnBackToMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				ArtHome frame = new ArtHome();
				frame.setVisible(true);
			}
		});
		btnBackToMenu.setBackground(Color.LIGHT_GRAY);
		btnBackToMenu.setFont(new Font("Trebuchet MS", Font.PLAIN, 9));
		btnBackToMenu.setBounds(25, 11, 96, 26);
		panelHolder.add(btnBackToMenu);
	}
}

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
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;

public class Artworks extends JFrame {

	private JPanel contentPane;
	private JTextField ArtCodetextField;
	private JTextField ArtTitletextField;
	private JTextField ArtStyletextField;
	private JTextField YearOfMakingtextField;
	private JTextField ArtisttextField;
	private JTextField ArtPricetextField;
	private JTable Artworkstable;
	
	protected ArtworksCRUD artworkCRUD = new ArtworksCRUD();
	protected ArtworksTemplate temp;
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
		btnArtist.setBackground(new Color(192, 192, 192));
		btnArtist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisible(false);
				Artist frame = new Artist();
				frame.setVisible(true);
			}
		});
		btnArtist.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnArtist.setBounds(601, 69, 89, 23);
		panelHolder.add(btnArtist);
		
//Button to redirect to Buyer GUI
		JButton btnBuyer = new JButton("Buyer");
		btnBuyer.setBackground(new Color(192, 192, 192));
		btnBuyer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisible(false);
				Buyer frame = new Buyer();
				frame.setVisible(true);	
			}
		});
		btnBuyer.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnBuyer.setBounds(701, 69, 89, 23);
		panelHolder.add(btnBuyer);
		
//Button to redirect to Buyer Cart GUI
		JButton btnBuyerCart = new JButton("Buyer Cart");
		btnBuyerCart.setBackground(new Color(192, 192, 192));
		btnBuyerCart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisible(false);
				BuyerCart frame = new BuyerCart();
				frame.setVisible(true);
				
			}
		});
		btnBuyerCart.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnBuyerCart.setBounds(799, 69, 89, 23);
		panelHolder.add(btnBuyerCart);
		
		JLabel lblArtCode = new JLabel("Art Code");
		lblArtCode.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblArtCode.setBounds(25, 35, 79, 31);
		panel.add(lblArtCode);
		
		ArtCodetextField = new JTextField();
		ArtCodetextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		ArtCodetextField.setBounds(145, 33, 185, 25);
		panel.add(ArtCodetextField);
		ArtCodetextField.setColumns(10);
		
		JLabel lblArtTitle = new JLabel("Art Title");
		lblArtTitle.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblArtTitle.setBounds(27, 77, 79, 31);
		panel.add(lblArtTitle);
		
		ArtTitletextField = new JTextField();
		ArtTitletextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		ArtTitletextField.setBounds(145, 77, 185, 25);
		panel.add(ArtTitletextField);
		ArtTitletextField.setColumns(10);
		
		JLabel lblArtStyle = new JLabel("Art Style");
		lblArtStyle.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblArtStyle.setBounds(27, 117, 79, 31);
		panel.add(lblArtStyle);
		
		ArtStyletextField = new JTextField();
		ArtStyletextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		ArtStyletextField.setColumns(10);
		ArtStyletextField.setBounds(145, 121, 185, 25);
		panel.add(ArtStyletextField);
		
		JLabel lblYearOfMaking = new JLabel("Year of Making");
		lblYearOfMaking.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblYearOfMaking.setBounds(27, 161, 92, 31);
		panel.add(lblYearOfMaking);
		
		YearOfMakingtextField = new JTextField();
		YearOfMakingtextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		YearOfMakingtextField.setColumns(10);
		YearOfMakingtextField.setBounds(145, 165, 185, 25);
		panel.add(YearOfMakingtextField);
		
		JLabel lblArtist = new JLabel("Artist ID");
		lblArtist.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblArtist.setBounds(27, 204, 92, 31);
		panel.add(lblArtist);
		
		ArtisttextField = new JTextField();
		ArtisttextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		ArtisttextField.setColumns(10);
		ArtisttextField.setBounds(145, 207, 185, 25);
		panel.add(ArtisttextField);
		
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
		Artworkstable.setFont(new Font("Arial", Font.PLAIN, 12));
		Artworkstable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Artworkstable.setBackground(Color.WHITE);
		Artworkstable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.add(Artworkstable);
		
		//Display data in table
		String[] columnNames = {"Art Code", "Art Title", "Art Style", "Year of Making", 
								"Artist ID", "Art Price"};
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		tableModel.addRow(columnNames);
		ArtworksTemplate.readData(tableModel);
		Artworkstable.setModel(tableModel);

//Add Button
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(245, 245, 245));
		btnAdd.setForeground(new Color(128, 0, 0));
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
						artworks.setArtistID(ArtisttextField.getText());
						artworks.setArtPrice(Float.parseFloat(ArtPricetextField.getText()));
						
						JOptionPane.showMessageDialog(null, ArtworksTemplate.rowCheck(artworks));
						tableModel.setRowCount(1);
						temp.readData(tableModel);
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
		btnSave.setBackground(new Color(245, 245, 245));
		btnSave.setForeground(new Color(128, 0, 0));
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
ArtworksValues artworkEdit = new ArtworksValues();
				
				boolean isFilled = !ArtCodetextField.getText().equals("") && !ArtTitletextField.getText().equals("")
									&& !YearOfMakingtextField.getText().equals("") && !ArtisttextField.getText().equals("")
									&& !ArtPricetextField.getText().equals(""); //fields that needs to be filled out
				
				try {
					if(isFilled) {
						
					//setting the values
						artworkEdit.setArtCode(ArtCodetextField.getText());
						artworkEdit.setArtTitle(ArtTitletextField.getText());
						artworkEdit.setArtStyle(ArtStyletextField.getText());
						artworkEdit.setYearOfMaking(YearOfMakingtextField.getText());
						artworkEdit.setArtistID(ArtisttextField.getText());
						artworkEdit.setArtPrice(Float.parseFloat(ArtPricetextField.getText()));
						
						ArtworksCRUD.Update(artworkEdit);
						clear();
						tableModel.setRowCount(1);
						temp.readData(tableModel);
						btnAdd.setVisible(true);
						btnSave.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "Not saved. Input Required Fields.");
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				
			}
		});
		btnSave.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		btnSave.setBounds(180, 414, 89, 26);
		btnSave.setVisible(false);
		panelHolder.add(btnSave);
		
//Discard Button
		JButton btnDiscard = new JButton("Discard");
		btnDiscard.setBackground(new Color(245, 245, 245));
		btnDiscard.setForeground(new Color(128, 0, 0));
		btnDiscard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clear();
				JOptionPane.showMessageDialog(null, "Sucessfully Discarded Changes.");
				btnAdd.setVisible(true);
				btnSave.setVisible(false);
			}
		});
		btnDiscard.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		btnDiscard.setBounds(294, 414, 89, 26);
		panelHolder.add(btnDiscard);
		
//Edit Button
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBackground(new Color(245, 245, 245));
		btnEdit.setForeground(new Color(128, 0, 0));
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSave.setVisible(true);
				int rowIndex = Artworkstable.getSelectedRow();
				
				if(rowIndex == -1) {
					JOptionPane.showMessageDialog(
							null,
							"Please select an item first.",
							"Warning",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				String toEdit = tableModel.getValueAt(rowIndex, 0).toString();
				ArtworksValues artworks = artworkCRUD.artVal(toEdit);
				setTexts(artworks);
				
				btnAdd.setVisible(false);
			}
		});
		btnEdit.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		btnEdit.setBounds(539, 414, 89, 26);
		panelHolder.add(btnEdit);
		
//Delete Button
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(245, 245, 245));
		btnDelete.setForeground(new Color(128, 0, 0));
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
				
				tableModel.setRowCount(1);
				temp.readData(tableModel);
				
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
	
private void clear() {
		
	ArtCodetextField.setText("");
	ArtTitletextField.setText("");
	ArtStyletextField.setText("");
	YearOfMakingtextField.setText("");
	ArtisttextField.setText("");
	ArtPricetextField.setText("");
	}
	
	//In editing: SETTING text into TEXTFIELDs
		public void setTexts(ArtworksValues artworks) {
			ArtCodetextField.setText(artworks.getArtCode());
			ArtTitletextField.setText(artworks.getArtTitle());
			ArtStyletextField.setText(artworks.getArtStyle());
			YearOfMakingtextField.setText(artworks.getYearOfMaking());
			ArtisttextField.setText(artworks.getArtistID());
			ArtPricetextField.setText(String.valueOf(artworks.getArtPrice()));
		}
}

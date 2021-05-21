package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import CRUDStatements.BuyerCRUD;
import exe.BuyerTemplate;
import value.BuyerValues;

public class Buyer extends JFrame {

	private JPanel contentPane;
	private JTextField BuyerIDtextField;
	private JTextField BuyerNametextField;
	private JTextField BuyerAgetextField;
	private JTextField BuyerGendertextField;
	private JTextField BuyerAddresstextField;
	private JTextField BuyerAffiliationtextField;
	private JTextField ContactNumbertextField;
	private JTable Buyertable;

	BuyerCRUD buyerCRUD = new BuyerCRUD();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buyer frame = new Buyer();
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
	public Buyer() {
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
		JButton btnArtwork = new JButton("Artwork");
		btnArtwork.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisible(false);
				Artworks frame = new Artworks();
				frame.setVisible(true);
			}
		});
		btnArtwork.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnArtwork.setBounds(601, 69, 89, 23);
		panelHolder.add(btnArtwork);
		
//Button to redirect to Artist GUI
		JButton btnArtist = new JButton("Artist");
		btnArtist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisible(false);
				Artist frame = new Artist();
				frame.setVisible(true);	
			}
		});
		btnArtist.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnArtist.setBounds(701, 69, 89, 23);
		panelHolder.add(btnArtist);
		
//Button to redirect to Buyer Cart GUI
		JButton btnBuyerCart = new JButton("Buyer Cart");
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
		
		JLabel lblBuyerID = new JLabel("Buyer ID");
		lblBuyerID.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblBuyerID.setBounds(27, 35, 79, 31);
		panel.add(lblBuyerID);
		
		BuyerIDtextField = new JTextField();
		BuyerIDtextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		BuyerIDtextField.setBounds(145, 33, 185, 25);
		panel.add(BuyerIDtextField);
		BuyerIDtextField.setColumns(10);
		
		JLabel lblBuyerName = new JLabel("Name");
		lblBuyerName.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblBuyerName.setBounds(27, 70, 79, 31);
		panel.add(lblBuyerName);
		
		BuyerNametextField = new JTextField();
		BuyerNametextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		BuyerNametextField.setBounds(145, 69, 185, 25);
		panel.add(BuyerNametextField);
		BuyerNametextField.setColumns(10);
		
		JLabel lblBuyerAge = new JLabel("Age");
		lblBuyerAge.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblBuyerAge.setBounds(27, 105, 79, 31);
		panel.add(lblBuyerAge);
		
		BuyerAgetextField = new JTextField();
		BuyerAgetextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		BuyerAgetextField.setColumns(10);
		BuyerAgetextField.setBounds(145, 105, 185, 25);
		panel.add(BuyerAgetextField);
		
		JLabel lblBuyerGender = new JLabel("Gender");
		lblBuyerGender.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblBuyerGender.setBounds(27, 143, 92, 31);
		panel.add(lblBuyerGender);
		
		BuyerGendertextField = new JTextField();
		BuyerGendertextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		BuyerGendertextField.setColumns(10);
		BuyerGendertextField.setBounds(145, 141, 185, 25);
		panel.add(BuyerGendertextField);
		
		JLabel lblBuyerAddress = new JLabel("Address");
		lblBuyerAddress.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblBuyerAddress.setBounds(27, 179, 92, 31);
		panel.add(lblBuyerAddress);
		
		BuyerAddresstextField = new JTextField();
		BuyerAddresstextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		BuyerAddresstextField.setColumns(10);
		BuyerAddresstextField.setBounds(145, 177, 185, 25);
		panel.add(BuyerAddresstextField);
		
		JLabel lblBuyerAffiliation = new JLabel("Affiliation");
		lblBuyerAffiliation.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblBuyerAffiliation.setBounds(27, 215, 92, 31);
		panel.add(lblBuyerAffiliation);
		
		BuyerAffiliationtextField = new JTextField();
		BuyerAffiliationtextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		BuyerAffiliationtextField.setColumns(10);
		BuyerAffiliationtextField.setBounds(145, 213, 185, 25);
		panel.add(BuyerAffiliationtextField);
		
		JLabel lblBuyerContactNumber = new JLabel("Contact Number");
		lblBuyerContactNumber.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblBuyerContactNumber.setBounds(27, 250, 108, 31);
		panel.add(lblBuyerContactNumber);
		
		ContactNumbertextField = new JTextField();
		ContactNumbertextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		ContactNumbertextField.setColumns(10);
		ContactNumbertextField.setBounds(145, 249, 185, 25);
		panel.add(ContactNumbertextField);
		
		JLabel lblArtworksLabel = new JLabel("BUYERS");
		lblArtworksLabel.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
		lblArtworksLabel.setBounds(32, 71, 122, 21);
		panelHolder.add(lblArtworksLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(435, 96, 453, 307);
		panelHolder.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		Buyertable = new JTable();
		Buyertable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Buyertable.setBackground(Color.WHITE);
		Buyertable.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.add(Buyertable);
		
		//Display data in table
		String[] columnNames = {"Buyer ID", "Name", "Age", "Gender", 
								"Address", "Affiliation", "Contact Number"};
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		tableModel.addRow(columnNames);
		BuyerTemplate.readData(tableModel);
		Buyertable.setModel(tableModel);

//Add Button
		JButton btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BuyerValues buyer = new BuyerValues();
				
				boolean isFilled = !BuyerIDtextField.getText().equals("") && !BuyerNametextField.getText().equals("")
									&& !BuyerAddresstextField.getText().equals("")
									&& !ContactNumbertextField.getText().equals(""); //fields that needs to be filled out
				
				try {
					if(isFilled) {
						
					//setting the values
						buyer.setBuyerId(BuyerIDtextField.getText());
						buyer.setBuyerName(BuyerNametextField.getText());
						buyer.setBuyerAge(BuyerAgetextField.getText());
						buyer.setBuyerGender(BuyerGendertextField.getText());
						buyer.setBuyerAddress(BuyerAddresstextField.getText());
						buyer.setBuyerAffiliation(BuyerAffiliationtextField.getText());
						buyer.setBuyerContactNumber(ContactNumbertextField.getText());
						
						JOptionPane.showMessageDialog(null, BuyerTemplate.rowCheck(buyer));
						setVisible(false);
						Buyer frame = new Buyer();
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
				
			BuyerValues buyerEdit = new BuyerValues();
				
				boolean isFilled = !BuyerIDtextField.getText().equals("") && !BuyerNametextField.getText().equals("")
									&& !BuyerAddresstextField.getText().equals("")
									&& !ContactNumbertextField.getText().equals(""); //fields that needs to be filled out
				
				try {
					if(isFilled) {
						
					//setting the values
						buyerEdit.setBuyerId(BuyerIDtextField.getText());
						buyerEdit.setBuyerName(BuyerNametextField.getText());
						buyerEdit.setBuyerAge(BuyerAgetextField.getText());
						buyerEdit.setBuyerGender(BuyerGendertextField.getText());
						buyerEdit.setBuyerAddress(BuyerAddresstextField.getText());
						buyerEdit.setBuyerAffiliation(BuyerAffiliationtextField.getText());
						buyerEdit.setBuyerContactNumber(ContactNumbertextField.getText());
						
						BuyerCRUD.Update(buyerEdit);
						setVisible(false);
						
						Buyer frame = new Buyer();
						frame.setVisible(true);
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
		btnDiscard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				JOptionPane.showMessageDialog(null, "Sucessfully Discarded Changes.");
				Buyer frame = new Buyer();
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
				btnSave.setVisible(true);
				int rowIndex = Buyertable.getSelectedRow();
				
				if(rowIndex == -1) {
					JOptionPane.showMessageDialog(
							null,
							"Please select an item first.",
							"Warning",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				String toEdit = tableModel.getValueAt(rowIndex, 0).toString();
				BuyerValues buyer = buyerCRUD.buyerVal(toEdit);
				setTexts(buyer);
				
				btnAdd.setVisible(false);
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
				
				int rowIndex = Buyertable.getSelectedRow();
				
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
				
				buyerCRUD.Delete(toDelete);
				Buyer frame = new Buyer();
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
	
	//In editing: SETTING text into TEXTFIELDs
		public void setTexts(BuyerValues buyer) {
			BuyerIDtextField.setText(buyer.getBuyerId());
			BuyerNametextField.setText(buyer.getBuyerName());
			BuyerAgetextField.setText(buyer.getBuyerAge());
			BuyerGendertextField.setText(buyer.getBuyerGender());
			BuyerAddresstextField.setText(buyer.getBuyerAddress());
			BuyerAffiliationtextField.setText(buyer.getBuyerAffiliation());
			ContactNumbertextField.setText(buyer.getBuyerContactNumber());	
	}
}

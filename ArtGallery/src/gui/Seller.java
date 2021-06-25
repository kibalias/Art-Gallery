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

import CRUDStatements.SellerCRUD;
import exe.BuyerTemplate;
import exe.SellerTemplate;
import value.SellerValues;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;

public class Seller extends JFrame {

	private JPanel contentPane;
	private JTextField SellerIDtextField;
	private JTextField SellerNametextField;
	private JTextField SellerAgetextField;
	private JTextField SellerAddresstextField;
	private JTextField BuyerCitytextField;
	private JTextField ContactNumbertextField;
	private JTable Sellertable;

	SellerCRUD sellerCRUD = new SellerCRUD();
	private JTextField SellerZIPtextField;
	private JTextField SellerStatetextField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seller frame = new Seller();
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
	public Seller() {
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
		
//Button to redirect to Buyer GUI
		JButton btnSeller = new JButton("Buyer");
		btnSeller.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisible(false);
				Buyer frame = new Buyer();
				frame.setVisible(true);	
			}
		});
		btnSeller.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSeller.setBounds(701, 69, 89, 23);
		panelHolder.add(btnSeller);
		
//Button to redirect to Sales GUI
		JButton btnSales = new JButton("Sales");
		btnSales.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisible(false);
				Sales frame = new Sales();
				frame.setVisible(true);
				
			}
		});
		btnSales.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSales.setBounds(799, 69, 89, 23);
		panelHolder.add(btnSales);
		
		JLabel lblSellerID = new JLabel("Seller ID");
		lblSellerID.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblSellerID.setBounds(27, 18, 79, 31);
		panel.add(lblSellerID);
		
		SellerIDtextField = new JTextField();
		SellerIDtextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		SellerIDtextField.setBounds(145, 18, 185, 25);
		panel.add(SellerIDtextField);
		SellerIDtextField.setColumns(10);
		
		JLabel lblSellerName = new JLabel("Name");
		lblSellerName.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblSellerName.setBounds(27, 54, 79, 31);
		panel.add(lblSellerName);
		
		SellerNametextField = new JTextField();
		SellerNametextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		SellerNametextField.setBounds(145, 54, 185, 25);
		panel.add(SellerNametextField);
		SellerNametextField.setColumns(10);
		
		JLabel lblSellerAge = new JLabel("Age");
		lblSellerAge.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblSellerAge.setBounds(27, 90, 79, 31);
		panel.add(lblSellerAge);
		
		SellerAgetextField = new JTextField();
		SellerAgetextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		SellerAgetextField.setColumns(10);
		SellerAgetextField.setBounds(145, 90, 185, 25);
		panel.add(SellerAgetextField);
		
		JLabel lblSellerGender = new JLabel("Gender");
		lblSellerGender.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblSellerGender.setBounds(27, 126, 92, 31);
		panel.add(lblSellerGender);
		
		JLabel lblSellerAddress = new JLabel("Address");
		lblSellerAddress.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblSellerAddress.setBounds(27, 196, 92, 31);
		panel.add(lblSellerAddress);
		
		SellerAddresstextField = new JTextField();
		SellerAddresstextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		SellerAddresstextField.setColumns(10);
		SellerAddresstextField.setBounds(145, 198, 185, 25);
		panel.add(SellerAddresstextField);
		
		JLabel lblSellerCity = new JLabel("City");
		lblSellerCity.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblSellerCity.setBounds(27, 236, 40, 31);
		panel.add(lblSellerCity);
		
		BuyerCitytextField = new JTextField();
		BuyerCitytextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		BuyerCitytextField.setColumns(10);
		BuyerCitytextField.setBounds(73, 234, 108, 25);
		panel.add(BuyerCitytextField);
		
		JLabel lblSellerContactNumber = new JLabel("Contact Number");
		lblSellerContactNumber.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblSellerContactNumber.setBounds(27, 160, 108, 31);
		panel.add(lblSellerContactNumber);
		
		ContactNumbertextField = new JTextField();
		ContactNumbertextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		ContactNumbertextField.setColumns(10);
		ContactNumbertextField.setBounds(145, 162, 185, 25);
		panel.add(ContactNumbertextField);
		
		JLabel lblZip = new JLabel("ZIP");
		lblZip.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblZip.setBounds(191, 236, 27, 31);
		panel.add(lblZip);
		
		SellerZIPtextField = new JTextField();
		SellerZIPtextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		SellerZIPtextField.setColumns(10);
		SellerZIPtextField.setBounds(222, 234, 108, 25);
		panel.add(SellerZIPtextField);
		
		SellerStatetextField = new JTextField();
		SellerStatetextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		SellerStatetextField.setColumns(10);
		SellerStatetextField.setBounds(73, 270, 257, 25);
		panel.add(SellerStatetextField);
		
		JLabel lblSellerState = new JLabel("State");
		lblSellerState.setBounds(27, 270, 40, 31);
		panel.add(lblSellerState);
		lblSellerState.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		
		JRadioButton FemaleRadioButton = new JRadioButton("Female");
		buttonGroup.add(FemaleRadioButton);
		FemaleRadioButton.setBounds(146, 128, 85, 23);
		panel.add(FemaleRadioButton);
		
		JRadioButton MaleRadioButton = new JRadioButton("Male");
		buttonGroup.add(MaleRadioButton);
		MaleRadioButton.setBounds(243, 128, 85, 23);
		panel.add(MaleRadioButton);
		
		JLabel lblSellerLabel = new JLabel("SELLERS");
		lblSellerLabel.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
		lblSellerLabel.setBounds(32, 71, 122, 21);
		panelHolder.add(lblSellerLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(435, 96, 453, 307);
		panelHolder.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		Sellertable = new JTable();
		Sellertable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Sellertable.setBackground(Color.WHITE);
		Sellertable.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.add(Sellertable);
		
		//Display data in table
		String[] columnNames = {"Buyer ID", "Name", "Age", "Gender", 
								"Address", "City", "State", "ZIP", "Contact Number"};
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		tableModel.addRow(columnNames);
		SellerTemplate.readData(tableModel);
		Sellertable.setModel(tableModel);

//Add Button
		JButton btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SellerValues seller = new SellerValues();
				
				boolean isFilled = !SellerIDtextField.getText().equals("") && !SellerNametextField.getText().equals("")
									&& !SellerAddresstextField.getText().equals("") && !BuyerCitytextField.getText().equals("")
									&& !SellerStatetextField.getText().equals("") && !SellerZIPtextField.getText().equals("")
									&& !ContactNumbertextField.getText().equals(""); //fields that needs to be filled out
				
				int bool = FemaleRadioButton.isSelected() ? 1 : 0;
				String BuyerGender = setGender(bool);
				
				try {
					if(isFilled) {
						
					//setting the values
						seller.setSellerId(SellerIDtextField.getText());
						seller.setSellerName(SellerNametextField.getText());
						seller.setSellerAge(Integer.parseInt(SellerAgetextField.getText()));
						seller.setSellerGender(BuyerGender);
						seller.setSellerAddress(SellerAddresstextField.getText());
						seller.setSellerCity(BuyerCitytextField.getText());
						seller.setSellerState(SellerStatetextField.getText());
						seller.setSellerZIP(SellerZIPtextField.getText());
						seller.setSellerContactNumber(ContactNumbertextField.getText());
						
						JOptionPane.showMessageDialog(null, SellerTemplate.rowCheck(seller));
						tableModel.setRowCount(1);
						SellerTemplate.readData(tableModel);
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
				
			SellerValues sellerEdit = new SellerValues();
				
			boolean isFilled = !SellerIDtextField.getText().equals("") && !SellerNametextField.getText().equals("")
					&& !SellerAddresstextField.getText().equals("") && !BuyerCitytextField.getText().equals("")
					&& !SellerStatetextField.getText().equals("") && !SellerZIPtextField.getText().equals("")
					&& !ContactNumbertextField.getText().equals(""); //fields that needs to be filled out
					
					int bool = FemaleRadioButton.isSelected() ? 1 : 0;
					String BuyerGender = setGender(bool);
					
				try {
					if(isFilled) {
						
					//setting the values
						sellerEdit.setSellerId(SellerIDtextField.getText());
						sellerEdit.setSellerName(SellerNametextField.getText());
						sellerEdit.setSellerAge(Integer.parseInt(SellerAgetextField.getText()));
						sellerEdit.setSellerGender(BuyerGender);
						sellerEdit.setSellerAddress(SellerAddresstextField.getText());
						sellerEdit.setSellerCity(BuyerCitytextField.getText());
						sellerEdit.setSellerState(SellerStatetextField.getText());
						sellerEdit.setSellerZIP(SellerZIPtextField.getText());
						sellerEdit.setSellerContactNumber(ContactNumbertextField.getText());
						
						SellerCRUD.Update(sellerEdit);
						setVisible(false);
						
						Seller frame = new Seller();
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
				Seller frame = new Seller();
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
				int rowIndex = Sellertable.getSelectedRow();
				
				if(rowIndex == -1) {
					JOptionPane.showMessageDialog(
							null,
							"Please select an item first.",
							"Warning",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				String toEdit = tableModel.getValueAt(rowIndex, 0).toString();
				SellerValues seller = sellerCRUD.sellerVal(toEdit);
				setTexts(seller);
				
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
				
				int rowIndex = Sellertable.getSelectedRow();
				
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
				
				sellerCRUD.Delete(toDelete);
				Seller frame = new Seller();
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
		public void setTexts(SellerValues seller) {
			SellerIDtextField.setText(seller.getSellerId());
			SellerNametextField.setText(seller.getSellerName());
			SellerAgetextField.setText(seller.getSellerAge().toString());
			SellerAddresstextField.setText(seller.getSellerAddress());
			BuyerCitytextField.setText(seller.getSellerCity());
			SellerStatetextField.setText(seller.getSellerState());
			SellerZIPtextField.setText(seller.getSellerZIP());
			ContactNumbertextField.setText(seller.getSellerContactNumber());	
	}
		
		public String setGender(int bool) {
			if(bool == 1) {
				return "F";
			}
			else {
				return "M";
			}
			
		}
}

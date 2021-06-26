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

import exe.SellerTemplate;
import value.BuyerValues;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Buyer extends JFrame {

	private JPanel contentPane;
	private JTextField BuyerIDtextField;
	private JTextField BuyerNametextField;
	private JTextField BuyerAgetextField;
	private JTextField BuyerAddresstextField;
	private JTextField BuyerCitytextField;
	private JTextField ContactNumbertextField;
	private JTable Buyertable;

	BuyerCRUD buyerCRUD = new BuyerCRUD();
	private JTextField BuyerZIPtextField;
	private JTextField BuyerStatetextField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
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
		btnArtwork.setBackground(SystemColor.menu);
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
		JButton btnSeller = new JButton("Seller");
		btnSeller.setBackground(SystemColor.menu);
		btnSeller.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisible(false);
				Seller frame = new Seller();
				frame.setVisible(true);	
			}
		});
		btnSeller.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSeller.setBounds(701, 69, 89, 23);
		panelHolder.add(btnSeller);
		
//Button to redirect to Buyer Cart GUI
		JButton btnSales = new JButton("Sales");
		btnSales.setBackground(SystemColor.menu);
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
		
		JLabel lblBuyerID = new JLabel("Buyer ID");
		lblBuyerID.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblBuyerID.setBounds(27, 18, 79, 31);
		panel.add(lblBuyerID);
		
		BuyerIDtextField = new JTextField();
		BuyerIDtextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		BuyerIDtextField.setBounds(145, 18, 185, 25);
		panel.add(BuyerIDtextField);
		BuyerIDtextField.setColumns(10);
		
		JLabel lblBuyerName = new JLabel("Name");
		lblBuyerName.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblBuyerName.setBounds(27, 54, 79, 31);
		panel.add(lblBuyerName);
		
		BuyerNametextField = new JTextField();
		BuyerNametextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		BuyerNametextField.setBounds(145, 54, 185, 25);
		panel.add(BuyerNametextField);
		BuyerNametextField.setColumns(10);
		
		JLabel lblBuyerAge = new JLabel("Age");
		lblBuyerAge.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblBuyerAge.setBounds(27, 90, 79, 31);
		panel.add(lblBuyerAge);
		
		BuyerAgetextField = new JTextField();
		BuyerAgetextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		BuyerAgetextField.setColumns(10);
		BuyerAgetextField.setBounds(145, 90, 185, 25);
		panel.add(BuyerAgetextField);
		
		JLabel lblBuyerGender = new JLabel("Gender");
		lblBuyerGender.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblBuyerGender.setBounds(27, 126, 92, 31);
		panel.add(lblBuyerGender);
		
		JLabel lblBuyerAddress = new JLabel("Address");
		lblBuyerAddress.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblBuyerAddress.setBounds(27, 195, 92, 31);
		panel.add(lblBuyerAddress);
		
		BuyerAddresstextField = new JTextField();
		BuyerAddresstextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		BuyerAddresstextField.setColumns(10);
		BuyerAddresstextField.setBounds(145, 197, 185, 25);
		panel.add(BuyerAddresstextField);
		
		JLabel lblBuyerCity = new JLabel("City");
		lblBuyerCity.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblBuyerCity.setBounds(27, 236, 40, 31);
		panel.add(lblBuyerCity);
		
		BuyerCitytextField = new JTextField();
		BuyerCitytextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		BuyerCitytextField.setColumns(10);
		BuyerCitytextField.setBounds(73, 234, 108, 25);
		panel.add(BuyerCitytextField);
		
		JLabel lblBuyerContactNumber = new JLabel("Contact Number");
		lblBuyerContactNumber.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblBuyerContactNumber.setBounds(27, 160, 108, 31);
		panel.add(lblBuyerContactNumber);
		
		JLabel lblZip = new JLabel("ZIP");
		lblZip.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblZip.setBounds(191, 236, 27, 31);
		panel.add(lblZip);
		
		BuyerZIPtextField = new JTextField();
		BuyerZIPtextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		BuyerZIPtextField.setColumns(10);
		BuyerZIPtextField.setBounds(222, 234, 108, 25);
		panel.add(BuyerZIPtextField);
		
		BuyerStatetextField = new JTextField();
		BuyerStatetextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		BuyerStatetextField.setColumns(10);
		BuyerStatetextField.setBounds(73, 270, 257, 25);
		panel.add(BuyerStatetextField);
		
		JLabel lblBuyerState = new JLabel("State");
		lblBuyerState.setBounds(27, 270, 40, 31);
		panel.add(lblBuyerState);
		lblBuyerState.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		
		JRadioButton FemaleRadioButton = new JRadioButton("Female");
		buttonGroup.add(FemaleRadioButton);
		FemaleRadioButton.setBounds(146, 128, 85, 23);
		panel.add(FemaleRadioButton);
		
		JRadioButton MaleRadioButton = new JRadioButton("Male");
		buttonGroup.add(MaleRadioButton);
		MaleRadioButton.setBounds(243, 128, 85, 23);
		panel.add(MaleRadioButton);
		
		ContactNumbertextField = new JTextField();
		ContactNumbertextField.setBounds(145, 162, 185, 25);
		panel.add(ContactNumbertextField);
		ContactNumbertextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		ContactNumbertextField.setColumns(10);
		
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
								"Address", "City", "State", "ZIP", "Contact Number"};
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		tableModel.addRow(columnNames);
		BuyerTemplate.readData(tableModel);
		Buyertable.setModel(tableModel);

//Add Button
		JButton btnAdd = new JButton("Add");
		btnAdd.setForeground(new Color(139, 0, 0));
		btnAdd.setBackground(new Color(255, 250, 250));
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BuyerValues buyer = new BuyerValues();
				
				boolean isFilled = !BuyerIDtextField.getText().equals("") && !BuyerNametextField.getText().equals("")
									&& !BuyerAddresstextField.getText().equals("") && !BuyerCitytextField.getText().equals("")
									&& !BuyerStatetextField.getText().equals("") && !BuyerZIPtextField.getText().equals("")
									&& !ContactNumbertextField.getText().equals(""); //fields that needs to be filled out
				
				int bool = FemaleRadioButton.isSelected() ? 1 : 0;
				String BuyerGender = setGender(bool);
				
				try {
					if(isFilled) {
						
					//setting the values
						buyer.setBuyerId(BuyerIDtextField.getText());
						buyer.setBuyerName(BuyerNametextField.getText());
						buyer.setBuyerAge(Integer.parseInt(BuyerAgetextField.getText()));
						buyer.setBuyerGender(BuyerGender);
						buyer.setBuyerAddress(BuyerAddresstextField.getText());
						buyer.setBuyerCity(BuyerCitytextField.getText());
						buyer.setBuyerState(BuyerStatetextField.getText());
						buyer.setBuyerZIP(BuyerZIPtextField.getText());
						buyer.setBuyerContactNumber(ContactNumbertextField.getText());
						
						JOptionPane.showMessageDialog(null, BuyerTemplate.rowCheck(buyer));
						tableModel.setRowCount(1);
						BuyerTemplate.readData(tableModel);
           
						clear();
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
		btnSave.setBackground(new Color(255, 250, 250));
		btnSave.setForeground(new Color(139, 0, 0));
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			BuyerValues buyerEdit = new BuyerValues();
				
			boolean isFilled = !BuyerIDtextField.getText().equals("") && !BuyerNametextField.getText().equals("")
					&& !BuyerAddresstextField.getText().equals("") && !BuyerCitytextField.getText().equals("")
					&& !BuyerStatetextField.getText().equals("") && !BuyerZIPtextField.getText().equals("")
					&& !ContactNumbertextField.getText().equals(""); //fields that needs to be filled out
					
					int bool = FemaleRadioButton.isSelected() ? 1 : 0;
					String BuyerGender = setGender(bool);
					
				try {
					if(isFilled) {
						
					//setting the values
						buyerEdit.setBuyerId(BuyerIDtextField.getText());
						buyerEdit.setBuyerName(BuyerNametextField.getText());
						buyerEdit.setBuyerAge(Integer.parseInt(BuyerAgetextField.getText()));
						buyerEdit.setBuyerGender(BuyerGender);
						buyerEdit.setBuyerAddress(BuyerAddresstextField.getText());
						buyerEdit.setBuyerCity(BuyerCitytextField.getText());
						buyerEdit.setBuyerState(BuyerStatetextField.getText());
						buyerEdit.setBuyerZIP(BuyerZIPtextField.getText());
						buyerEdit.setBuyerContactNumber(ContactNumbertextField.getText());
						
						BuyerCRUD.Update(buyerEdit);
						tableModel.setRowCount(1);
						BuyerTemplate.readData(tableModel);
						clear();
						
					} else {
						JOptionPane.showMessageDialog(null, "Not saved. Input Required Fields.");
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}finally {
						btnSave.setVisible(false);
						btnAdd.setVisible(true);
					}
				
			}
		});
		btnSave.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		btnSave.setBounds(180, 414, 89, 26);
		btnSave.setVisible(false);
		panelHolder.add(btnSave);
		
//Discard Button
		JButton btnDiscard = new JButton("Discard");
		btnDiscard.setForeground(new Color(139, 0, 0));
		btnDiscard.setBackground(new Color(255, 250, 250));
		btnDiscard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSave.setVisible(false);
				JOptionPane.showMessageDialog(null, "Sucessfully Discarded Changes.");
				tableModel.setRowCount(1);
				BuyerTemplate.readData(tableModel);
				clear();
				btnAdd.setVisible(true);
			}
		});
		btnDiscard.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		btnDiscard.setBounds(294, 414, 89, 26);
		panelHolder.add(btnDiscard);
		
//Edit Button
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBackground(new Color(255, 250, 250));
		btnEdit.setForeground(new Color(139, 0, 0));
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
		btnDelete.setForeground(new Color(139, 0, 0));
		btnDelete.setBackground(new Color(255, 250, 250));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
				tableModel.setRowCount(1);
				BuyerTemplate.readData(tableModel);
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
			BuyerAgetextField.setText(buyer.getBuyerAge().toString());
			BuyerAddresstextField.setText(buyer.getBuyerAddress());
			BuyerCitytextField.setText(buyer.getBuyerCity());
			BuyerStatetextField.setText(buyer.getBuyerState());
			BuyerZIPtextField.setText(buyer.getBuyerZIP());
			ContactNumbertextField.setText(buyer.getBuyerContactNumber());	
	}
		public void clear() {
			BuyerIDtextField.setText("");
			BuyerNametextField.setText("");
			BuyerAgetextField.setText("");
			BuyerAddresstextField.setText("");
			BuyerCitytextField.setText("");
			BuyerStatetextField.setText("");
			BuyerZIPtextField.setText("");
			ContactNumbertextField.setText("");	
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

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

import CRUDStatements.ArtistCRUD;
import CRUDStatements.BuyerCRUD;
import exe.ArtistTemplate;
import value.ArtistValues;

public class Artist extends JFrame {

	private JPanel contentPane;
	private JTextField ArtistNametextField;
	private JTextField ArtistAgetextField;
	private JTextField ArtistGendertextField;
	private JTextField ArtistAddresstextField;
	private JTextField ArtistContactNumbertextField;
	private JTable Artisttable;
	
	ArtistCRUD artistCRUD = new ArtistCRUD();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Artist frame = new Artist();
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
	public Artist() {
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
		JButton btnBuyer = new JButton("Buyer");
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
		
		JLabel lblArtistName = new JLabel("Name");
		lblArtistName.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblArtistName.setBounds(27, 35, 79, 31);
		panel.add(lblArtistName);
		
		ArtistNametextField = new JTextField();
		ArtistNametextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		ArtistNametextField.setBounds(145, 38, 185, 25);
		panel.add(ArtistNametextField);
		ArtistNametextField.setColumns(10);
		
		JLabel lblArtistAge = new JLabel("Age");
		lblArtistAge.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblArtistAge.setBounds(27, 91, 79, 31);
		panel.add(lblArtistAge);
		
		ArtistAgetextField = new JTextField();
		ArtistAgetextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		ArtistAgetextField.setBounds(145, 93, 185, 25);
		panel.add(ArtistAgetextField);
		ArtistAgetextField.setColumns(10);
		
		JLabel lblArtistGender = new JLabel("Gender");
		lblArtistGender.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblArtistGender.setBounds(27, 145, 79, 31);
		panel.add(lblArtistGender);
		
		ArtistGendertextField = new JTextField();
		ArtistGendertextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		ArtistGendertextField.setColumns(10);
		ArtistGendertextField.setBounds(145, 147, 185, 25);
		panel.add(ArtistGendertextField);
		
		JLabel lblArtistAddress = new JLabel("Address");
		lblArtistAddress.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblArtistAddress.setBounds(27, 196, 92, 31);
		panel.add(lblArtistAddress);
		
		ArtistAddresstextField = new JTextField();
		ArtistAddresstextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		ArtistAddresstextField.setColumns(10);
		ArtistAddresstextField.setBounds(145, 198, 185, 25);
		panel.add(ArtistAddresstextField);
		
		JLabel lblArtistContactNumber = new JLabel("Contact Number");
		lblArtistContactNumber.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblArtistContactNumber.setBounds(27, 250, 108, 31);
		panel.add(lblArtistContactNumber);
		
		ArtistContactNumbertextField = new JTextField();
		ArtistContactNumbertextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		ArtistContactNumbertextField.setColumns(10);
		ArtistContactNumbertextField.setBounds(145, 249, 185, 25);
		panel.add(ArtistContactNumbertextField);
		
		JLabel lblArtistsLabel = new JLabel("ARTISTS");
		lblArtistsLabel.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
		lblArtistsLabel.setBounds(32, 71, 122, 21);
		panelHolder.add(lblArtistsLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(435, 96, 453, 307);
		panelHolder.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		Artisttable = new JTable();
		Artisttable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Artisttable.setBackground(Color.WHITE);
		Artisttable.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.add(Artisttable);
		
		//Display data in table
		String[] columnNames = {"Name", "Age", "Gender", 
								"Address", "Contact Number"};
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		tableModel.addRow(columnNames);
		ArtistTemplate.readData(tableModel);
		Artisttable.setModel(tableModel);

//Add Button
		JButton btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArtistValues artist = new ArtistValues();
				
				boolean isFilled = !ArtistNametextField.getText().equals("") && !ArtistAddresstextField.getText().equals(""); 
				//fields that needs to be filled out
				
				try {
					if(isFilled) {
						
					//setting the values
						artist.setArtistName(ArtistNametextField.getText());
						artist.setArtistAge(ArtistAgetextField.getText());
						artist.setArtistGender(ArtistGendertextField.getText());
						artist.setArtistAddress(ArtistAddresstextField.getText());
						artist.setArtistContactNumber(ArtistContactNumbertextField.getText());
						
						JOptionPane.showMessageDialog(null, ArtistTemplate.rowCheck(artist));
						setVisible(false);
						Artist frame = new Artist();
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
				
			ArtistValues artistEdit = new ArtistValues();
				
				boolean isFilled = !ArtistNametextField.getText().equals("") && !ArtistAddresstextField.getText().equals("");
				//fields that needs to be filled out
				
				try {
					if(isFilled) {
						
					//setting the values
						artistEdit.setArtistName(ArtistNametextField.getText());
						artistEdit.setArtistAge(ArtistAgetextField.getText());
						artistEdit.setArtistGender(ArtistGendertextField.getText());
						artistEdit.setArtistAddress(ArtistAddresstextField.getText());
						artistEdit.setArtistContactNumber(ArtistContactNumbertextField.getText());
						
						ArtistCRUD.Update(artistEdit);
						JOptionPane.showMessageDialog(null, "Saved Changes.");
						setVisible(false);
						
						Artist frame = new Artist();
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
				Artist frame = new Artist();
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
				int rowIndex = Artisttable.getSelectedRow();
				
				if(rowIndex == -1) {
					JOptionPane.showMessageDialog(
							null,
							"Please select an item first.",
							"Warning",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				String toEdit = tableModel.getValueAt(rowIndex, 0).toString();
				ArtistValues artist = artistCRUD.artistVal(toEdit);
				setTexts(artist);
				
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
				
				int rowIndex = Artisttable.getSelectedRow();
				
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
				
				artistCRUD.Delete(toDelete);
				Artist frame = new Artist();
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
		public void setTexts(ArtistValues artist) {
			ArtistNametextField.setText(artist.getArtistName());
			ArtistAgetextField.setText(artist.getArtistAge());
			ArtistGendertextField.setText(artist.getArtistGender());
			ArtistAddresstextField.setText(artist.getArtistAddress());
			ArtistContactNumbertextField.setText(artist.getArtistContactNumber());	
	}
}

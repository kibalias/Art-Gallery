package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

import CRUDStatements.SalesCRUD;
import exe.SalesTemplate;
import value.SalesValues;

public class Sales extends JFrame {

	private JPanel contentPane;
	private JTable Carttable;
	
	SalesCRUD salesCRUD = new SalesCRUD();
	private JTextField AmounttextField;
	private JTextField DatetextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sales frame = new Sales();
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
	public Sales() {
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
		
//Button to redirect to Artwork GUI	
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
		JButton btnSeller = new JButton("Seller");
		btnSeller.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisible(false);
				Seller frame = new Seller();
				frame.setVisible(true);
				
			}
		});
		btnSeller.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSeller.setBounds(799, 69, 89, 23);
		panelHolder.add(btnSeller);
		
//ComboBoxes
		JComboBox ArtCodecomboBox = new JComboBox();
		ArtCodecomboBox.setBounds(146, 142, 185, 32);
		panel.add(ArtCodecomboBox);
		ArtCodecomboBox.addItem("Select");
		SalesCRUD.ArtCodeComboBox(ArtCodecomboBox);
		
		JComboBox BuyerIDcomboBox = new JComboBox();
		BuyerIDcomboBox.setBounds(146, 43, 185, 32);
		panel.add(BuyerIDcomboBox);
		BuyerIDcomboBox.addItem("Select");
		SalesCRUD.BuyerIDComboBox(BuyerIDcomboBox);
		
		JComboBox SellerIDcomboBox = new JComboBox();
		SellerIDcomboBox.setBounds(146, 92, 185, 32);
		panel.add(SellerIDcomboBox);
		SellerIDcomboBox.addItem("Select");
		SalesCRUD.SellerIDComboBox(SellerIDcomboBox);
		
		JLabel lblBuyerId = new JLabel("Buyer ID");
		lblBuyerId.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblBuyerId.setBounds(40, 48, 78, 23);
		panel.add(lblBuyerId);
		
		JLabel lblSellerId = new JLabel("Seller ID");
		lblSellerId.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblSellerId.setBounds(40, 102, 78, 23);
		panel.add(lblSellerId);
		
		JLabel lblArtCode = new JLabel("Art Code");
		lblArtCode.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblArtCode.setBounds(40, 152, 78, 23);
		panel.add(lblArtCode);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblAmount.setBounds(40, 197, 78, 23);
		panel.add(lblAmount);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblDate.setBounds(40, 240, 78, 23);
		panel.add(lblDate);
		
		AmounttextField = new JTextField();
		AmounttextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		AmounttextField.setColumns(10);
		AmounttextField.setBounds(146, 193, 185, 25);
		panel.add(AmounttextField);
		
		DatetextField = new JTextField("YYYY-MM-DD");
		DatetextField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		DatetextField.setColumns(10);
		DatetextField.setBounds(146, 238, 185, 25);
		panel.add(DatetextField);
		
		JLabel lblSalesLabel = new JLabel("SALES");
		lblSalesLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalesLabel.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
		lblSalesLabel.setBounds(32, 71, 67, 21);
		panelHolder.add(lblSalesLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(435, 96, 453, 307);
		panelHolder.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		Carttable = new JTable();
		Carttable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Carttable.setBackground(Color.WHITE);
		Carttable.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.add(Carttable);
		
		//Display data in table
		String[] columnNames = {"id", "Buyer Id", "Sales Id", "Art Code", "Amount", "Date"};
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		tableModel.addRow(columnNames);
		SalesTemplate.readData(tableModel);
		Carttable.setModel(tableModel);

//Add Button
		JButton btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SalesValues sales = new SalesValues();
				
				String art_code = (String) ArtCodecomboBox.getSelectedItem();
				String buyer_id = (String) BuyerIDcomboBox.getSelectedItem();
				String seller_id = (String) SellerIDcomboBox.getSelectedItem();
				
				boolean isFilled = !art_code.equals("") && !art_code.equals("Select") 
									&& !buyer_id.equals("") && !buyer_id.equals("Select") && 
									!seller_id.equals("") && !seller_id.equals("Select"); //fields that needs to be filled out
				
				try {
					if(isFilled) {
						//LocalDate date = LocalDate.parse(DatetextField.getText());
						Date DateOfSale = new SimpleDateFormat("yyyy-MM-dd").parse(DatetextField.getText());
						java.sql.Date date = new java.sql.Date(DateOfSale.getTime());
						
					//setting the values
						sales.setArtCode(art_code);
						sales.setBuyerId(buyer_id);
						sales.setSellerId(seller_id);
						sales.setAmount(Float.parseFloat(AmounttextField.getText()));
						sales.setDateOfSale(date);
						
						JOptionPane.showMessageDialog(null, SalesTemplate.rowCheck(sales));
						setVisible(true);
						tableModel.setRowCount(1);
						SalesTemplate.readData(tableModel);
					} else {
						JOptionPane.showMessageDialog(null, "Not saved. Input Required Fields.");
						}
					} catch (ParseException e1) {
						JOptionPane.showMessageDialog(null, "Format Date this way (YYYY-MM-DD).");
						e1.printStackTrace();
				}
			}
		}); 
		btnAdd.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		btnAdd.setBounds(126, 414, 89, 26);
		panelHolder.add(btnAdd);
		
//Discard Button
		JButton btnDiscard = new JButton("Discard");
		btnDiscard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				JOptionPane.showMessageDialog(null, "Sucessfully Discarded Changes.");
				Sales frame = new Sales();
				frame.setVisible(true);
			}
		});
		btnDiscard.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		btnDiscard.setBounds(237, 414, 89, 26);
		panelHolder.add(btnDiscard);

		
//Delete Button
		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int rowIndex = Carttable.getSelectedRow();
				
				if(rowIndex == -1) {
					JOptionPane.showMessageDialog(
							null,
							"Please select an item first.",
							"Warning",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(JOptionPane.showConfirmDialog(null, "Are you sure?") == JOptionPane.YES_OPTION) {
				
				int toDelete = (int) tableModel.getValueAt(rowIndex, 0);
				
				salesCRUD.Delete(toDelete);
				Sales frame = new Sales();
				frame.setVisible(true);
				}
				
			}
		});
		btnDelete.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		btnDelete.setBounds(799, 414, 89, 26);
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

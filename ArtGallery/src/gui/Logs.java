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
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

import CRUDStatements.ArtworksCRUD;
import CRUDStatements.LogsCRUD;
import exe.ArtworksTemplate;
import exe.SalesTemplate;
import value.ArtworksValues;
import value.SalesValues;
import javax.swing.JSeparator;

public class Logs extends JFrame {

	private JPanel contentPane;
	private JTable Logstable;
	private JTextField BuyerIDtextField;
	private JTextField BuyerNametextField;
	private JTextField SellerIDtextField;
	private JTextField SellerNametextField;
	private JTextField ArtCodetextField;
	private JTextField ArtTitletextField;
	private JTextField DOTtextField;
	private JTextField AmounttextField;
	protected LogsCRUD logsCRUD = new LogsCRUD();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logs frame = new Logs();
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
	public Logs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 943, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelHolder = new JPanel();
		panelHolder.setLayout(null);
		contentPane.add(panelHolder);
		
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
		
		JLabel lblLogsLabel = new JLabel("LOGS");
		lblLogsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogsLabel.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
		lblLogsLabel.setBounds(32, 71, 51, 21);
		panelHolder.add(lblLogsLabel);
		
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
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(32, 93, 466, 310);
		panelHolder.add(panel);
		
//Display data in table		
		Logstable = new JTable();
		Logstable.setFont(new Font("Arial", Font.PLAIN, 12));
		Logstable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Logstable.setBackground(Color.WHITE);
		panel.add(Logstable);
		
		String[] columnNames = {"id", "Buyer Id", "Sales Id", "Art Code", "Amount", "Date"};
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		tableModel.addRow(columnNames);
		SalesTemplate.readData(tableModel);
		Logstable.setModel(tableModel);
		
		BuyerIDtextField = new JTextField();
		BuyerIDtextField.setText("ID");
		BuyerIDtextField.setBackground(Color.ORANGE);
		BuyerIDtextField.setEditable(false);
		BuyerIDtextField.setBounds(531, 125, 169, 23);
		panelHolder.add(BuyerIDtextField);
		BuyerIDtextField.setColumns(10);
		
		JLabel Buyer = new JLabel("Buyer");
		Buyer.setHorizontalAlignment(SwingConstants.LEFT);
		Buyer.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
		Buyer.setBounds(549, 93, 70, 21);
		panelHolder.add(Buyer);
		
		BuyerNametextField = new JTextField();
		BuyerNametextField.setText("Name");
		BuyerNametextField.setEditable(false);
		BuyerNametextField.setColumns(10);
		BuyerNametextField.setBounds(531, 159, 169, 23);
		panelHolder.add(BuyerNametextField);
		
		JLabel lblSeller = new JLabel("Seller");
		lblSeller.setHorizontalAlignment(SwingConstants.LEFT);
		lblSeller.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
		lblSeller.setBounds(549, 200, 51, 21);
		panelHolder.add(lblSeller);
		
		SellerIDtextField = new JTextField();
		SellerIDtextField.setBackground(Color.ORANGE);
		SellerIDtextField.setText("ID");
		SellerIDtextField.setEditable(false);
		SellerIDtextField.setColumns(10);
		SellerIDtextField.setBounds(531, 231, 169, 23);
		panelHolder.add(SellerIDtextField);
		
		SellerNametextField = new JTextField();
		SellerNametextField.setText("Name");
		SellerNametextField.setEditable(false);
		SellerNametextField.setColumns(10);
		SellerNametextField.setBounds(531, 265, 169, 23);
		panelHolder.add(SellerNametextField);
		
		JLabel lblArtwork = new JLabel("Artwork");
		lblArtwork.setHorizontalAlignment(SwingConstants.LEFT);
		lblArtwork.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
		lblArtwork.setBounds(549, 305, 70, 21);
		panelHolder.add(lblArtwork);
		
		ArtCodetextField = new JTextField();
		ArtCodetextField.setBackground(Color.ORANGE);
		ArtCodetextField.setText("Code");
		ArtCodetextField.setEditable(false);
		ArtCodetextField.setColumns(10);
		ArtCodetextField.setBounds(531, 337, 169, 23);
		panelHolder.add(ArtCodetextField);
		
		ArtTitletextField = new JTextField();
		ArtTitletextField.setText("Title");
		ArtTitletextField.setEditable(false);
		ArtTitletextField.setColumns(10);
		ArtTitletextField.setBounds(531, 371, 169, 23);
		panelHolder.add(ArtTitletextField);
		
		JLabel dateOfTransaction = new JLabel("Date of");
		dateOfTransaction.setHorizontalAlignment(SwingConstants.CENTER);
		dateOfTransaction.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
		dateOfTransaction.setBounds(745, 183, 132, 21);
		panelHolder.add(dateOfTransaction);
		
		JLabel lblTransaction = new JLabel("Transaction");
		lblTransaction.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransaction.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
		lblTransaction.setBounds(743, 198, 132, 21);
		panelHolder.add(lblTransaction);
		
		DOTtextField = new JTextField();
		DOTtextField.setText("YYYY-MM-DD");
		DOTtextField.setEditable(false);
		DOTtextField.setColumns(10);
		DOTtextField.setBounds(743, 226, 132, 23);
		panelHolder.add(DOTtextField);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setHorizontalAlignment(SwingConstants.LEFT);
		lblAmount.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
		lblAmount.setBounds(776, 260, 70, 21);
		panelHolder.add(lblAmount);
		
		AmounttextField = new JTextField();
		AmounttextField.setEditable(false);
		AmounttextField.setColumns(10);
		AmounttextField.setBounds(743, 290, 132, 23);
		panelHolder.add(AmounttextField);
		
		//More Details Button
				JButton btnDetails = new JButton("More Details>>>");
				btnDetails.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						btnDetails.setVisible(true);
						int rowIndex = Logstable.getSelectedRow();
						
						if(rowIndex == -1) {
							JOptionPane.showMessageDialog(
									null,
									"Please select an item first.",
									"Warning",
									JOptionPane.WARNING_MESSAGE);
							return;
						}
						
						String toFind = tableModel.getValueAt(rowIndex, 0).toString();
						SalesValues sales = logsCRUD.saleVal(toFind);
						String findBuyer = tableModel.getValueAt(rowIndex, 1).toString();
						String findSeller = tableModel.getValueAt(rowIndex, 2).toString();
						String findArtwork = tableModel.getValueAt(rowIndex, 3).toString();
						String buyer_name, seller_name, art_title;
						buyer_name = LogsCRUD.getBuyer(findBuyer);
						seller_name = LogsCRUD.getSeller(findSeller);
						art_title = LogsCRUD.getArtwork(findArtwork);
						setTexts(sales, buyer_name, seller_name, art_title);
						
					}
				});
				btnDetails.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
				btnDetails.setBounds(377, 414, 121, 26);
				panelHolder.add(btnDetails);
				
				JSeparator separator = new JSeparator();
				separator.setOrientation(SwingConstants.VERTICAL);
				separator.setBackground(Color.BLACK);
				separator.setForeground(Color.BLACK);
				separator.setBounds(725, 147, 11, 231);
				panelHolder.add(separator);
	}
	
	//setting texts to Text Fields
	public void setTexts(SalesValues sales, String buyer_name, String seller_name, String art_title) {
		ArtCodetextField.setText(sales.getArtCode());
		ArtTitletextField.setText(art_title);
		BuyerIDtextField.setText(sales.getBuyerId());
		BuyerNametextField.setText(buyer_name);
		SellerIDtextField.setText(sales.getSellerId());
		SellerNametextField.setText(seller_name);
		AmounttextField.setText(sales.getAmount().toString());
		DOTtextField.setText(sales.getDateOfSale().toString());
		/*
		 * ArtTitletextField.setText(artworks.getArtTitle());
		 * 
		 */
		}
}

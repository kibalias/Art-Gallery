package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import exe.ArtworksTemplate;
import value.ArtworksValues;
import CRUDStatements.ArtworksCRUD;
import java.awt.SystemColor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class Viewer extends JFrame {

	private JPanel contentPane;
	private JTextField txtFldTitle;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Viewer frame = new Viewer();
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
	public Viewer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Art Galleria");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(102, 0, 0));
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		lblNewLabel.setBounds(218, 0, 260, 60);
		contentPane.add(lblNewLabel);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBackground(new Color(102, 102, 102));
		searchPanel.setBounds(30, 83, 227, 291);
		contentPane.add(searchPanel);
		searchPanel.setLayout(null);
		
		JLabel lblArtTitle = new JLabel("Art Title :");
		lblArtTitle.setForeground(new Color(255, 255, 255));
		lblArtTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblArtTitle.setBounds(10, 50, 64, 17);
		searchPanel.add(lblArtTitle);
		
		txtFldTitle = new JTextField();
		txtFldTitle.setBounds(77, 49, 131, 23);
		txtFldTitle.setColumns(10);
		searchPanel.add(txtFldTitle);
		
		JPanel panel = new JPanel();
		panel.setBounds(287, 83, 378, 291);
		contentPane.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Art Title", "ArtStyle", "Year of Making", "Artist", "Price", "Status"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(83);
		table.getColumnModel().getColumn(3).setPreferredWidth(86);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setBounds(0, 0, 378, 291);
		panel.add(table);
		
		//Display table data for viewers
		String[] columnNames = {"Art Title", "ArtStyle", "Year of Making", "Artist", "Price", "Status"};
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		tableModel.addRow(columnNames);
		ArtworksTemplate.readViewerData(tableModel);
		table.setModel(tableModel);
		
		//Return to Main Menu 	
		JButton btnReturn = new JButton("Back to Menu");
		btnReturn.setBackground(SystemColor.activeCaptionBorder);
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnReturn.setBounds(30, 26, 102, 23);
		contentPane.add(btnReturn);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBackground(Color.WHITE);
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRefresh.setBounds(576, 56, 89, 23);
		contentPane.add(btnRefresh);
		
		//Search Button 	
				JButton btnSearch = new JButton("Search");
				btnSearch.setBackground(new Color(255, 255, 255));
				btnSearch.setBounds(128, 82, 80, 23);
				searchPanel.add(btnSearch);
				
				btnSearch.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						boolean isFilled = !txtFldTitle.getText().equals(""); //fields that needs to be filled out
						
						try {
							if(isFilled) {
	
								String artTitle = txtFldTitle.getText();  //getSearched String
								tableModel.setRowCount(1);				
								ArtworksTemplate.searchResult(tableModel, artTitle);
								
								
								
								
							} else {
								JOptionPane.showMessageDialog(null, "Please Enter an Art Title");
								}
							} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				});
				
				
		btnRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableModel.setRowCount(1);
				ArtworksTemplate.readViewerData(tableModel);
				txtFldTitle.setText(" ");
			}
		});
		
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				ArtHome frame = new ArtHome();
				frame.setVisible(true);
			}
		});
		
	}
}

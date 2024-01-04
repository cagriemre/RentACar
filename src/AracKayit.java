import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class AracKayit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textID;
	private JTextField textMarka;
	private JTextField textModel;
	private JTextField textYil;
	private JTextField textVites;
	private JTextField textYakit;
	private JTextField textUcret;
	private JTable tableAracKayit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AracKayit frame = new AracKayit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    public void Insert() {
    	
    
    }
	public AracKayit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelAracKayit = new JPanel();
		panelAracKayit.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Ara\u00E7 Kay\u0131t", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panelAracKayit.setBounds(10, 20, 369, 473);
		contentPane.add(panelAracKayit);
		panelAracKayit.setLayout(null);
		
		JLabel lblPlaka = new JLabel("Plaka");
		lblPlaka.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPlaka.setBounds(10, 28, 87, 35);
		panelAracKayit.add(lblPlaka);
		
		JLabel lblMarka = new JLabel("Marka");
		lblMarka.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMarka.setBounds(10, 77, 87, 35);
		panelAracKayit.add(lblMarka);
		
		JLabel lblModel = new JLabel("Model");
		lblModel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblModel.setBounds(10, 125, 87, 35);
		panelAracKayit.add(lblModel);
		
		JLabel lblYil = new JLabel("Yıl");
		lblYil.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblYil.setBounds(10, 170, 87, 35);
		panelAracKayit.add(lblYil);
		
		JLabel lblVites = new JLabel("Vites");
		lblVites.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVites.setBounds(10, 215, 87, 35);
		panelAracKayit.add(lblVites);
		
		JLabel lblYakit = new JLabel("Yakıt");
		lblYakit.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblYakit.setBounds(10, 260, 87, 35);
		panelAracKayit.add(lblYakit);
		
		JLabel lblUcret = new JLabel("Günlük Ücret");
		lblUcret.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUcret.setBounds(10, 305, 99, 35);
		panelAracKayit.add(lblUcret);
		
		JButton btnEkle = new JButton("Ekle");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement statement = null;
				DbHelper db = new DbHelper();
				
				try {
					con=db.getConnection();
					String query = "insert into araclar.carinfo(Plaka,Marka,Model,Yıl,Yakıt,"
							+ "Vites,Gunluk_Ucret)"
							+ "values (?,?,?,?,?,?,?)";
					statement = con.prepareStatement(query);
					statement.setString(1, textID.getText());
					statement.setString(2, textMarka.getText());
					statement.setString(3, textModel.getText());
					statement.setString(4, textYakit.getText());
					statement.setString(5, textVites.getText());
					statement.setString(6, textYil.getText());
					statement.setString(7, textUcret.getText());
					statement.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Araç başarıyla eklendi.");
				}
				catch(SQLException Exception) {
					db.ShowError(Exception);
					
				}
				
				String Plaka = textID.getText();
				String marka = textMarka.getText();	
				String model = textModel.getText();	
				String yakit = textYakit.getText();	
				String vites = textVites.getText();	
				String yil = textYil.getText();	
				String ucret = textUcret.getText();	
				}
				
				
				
			
		});
		btnEkle.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnEkle.setBounds(57, 379, 116, 50);
		panelAracKayit.add(btnEkle);
		
		JButton btnIptal = new JButton("İptal");
		btnIptal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminGirisi a = new AdminGirisi();
				a.setVisible(true);
				setVisible(false);
			}
		});
		btnIptal.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnIptal.setBounds(213, 379, 116, 50);
		panelAracKayit.add(btnIptal);
		
		textID = new JTextField();
		textID.setFont(new Font("Tahoma", Font.BOLD, 14));
		textID.setBounds(173, 35, 156, 25);
		panelAracKayit.add(textID);
		textID.setColumns(10);
		
		textMarka = new JTextField();
		textMarka.setFont(new Font("Tahoma", Font.BOLD, 14));
		textMarka.setColumns(10);
		textMarka.setBounds(173, 84, 156, 25);
		panelAracKayit.add(textMarka);
		
		textModel = new JTextField();
		textModel.setFont(new Font("Tahoma", Font.BOLD, 14));
		textModel.setColumns(10);
		textModel.setBounds(173, 135, 156, 25);
		panelAracKayit.add(textModel);
		
		textYil = new JTextField();
		textYil.setFont(new Font("Tahoma", Font.BOLD, 14));
		textYil.setColumns(10);
		textYil.setBounds(173, 180, 156, 25);
		panelAracKayit.add(textYil);
		
		textVites = new JTextField();
		textVites.setFont(new Font("Tahoma", Font.BOLD, 14));
		textVites.setColumns(10);
		textVites.setBounds(173, 225, 156, 25);
		panelAracKayit.add(textVites);
		
		textYakit = new JTextField();
		textYakit.setFont(new Font("Tahoma", Font.BOLD, 14));
		textYakit.setColumns(10);
		textYakit.setBounds(173, 270, 156, 25);
		panelAracKayit.add(textYakit);
		
		textUcret = new JTextField();
		textUcret.setFont(new Font("Tahoma", Font.BOLD, 14));
		textUcret.setColumns(10);
		textUcret.setBounds(173, 315, 156, 25);
		panelAracKayit.add(textUcret);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(389, 20, 414, 390);
		contentPane.add(scrollPane);
		
		tableAracKayit = new JTable();
		tableAracKayit.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tableAracKayit.setFont(new Font("Tahoma", Font.BOLD, 10));
		scrollPane.setViewportView(tableAracKayit);
		tableAracKayit.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Plaka", "Marka", "Model", "Y\u0131l", "Vites", "Yak\u0131t", "Ucret"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JButton btnNewButton = new JButton("Güncelle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
int c;
				
				DbHelper db = new DbHelper();
				Connection con = null;
				PreparedStatement pst = null;
				
				try {
					con=db.getConnection();
					pst = con.prepareStatement("select * from carinfo");
					ResultSet rs = pst.executeQuery();
					
					ResultSetMetaData rd = (ResultSetMetaData) rs.getMetaData();
					c = rd.getColumnCount();
					DefaultTableModel df = (DefaultTableModel)tableAracKayit.getModel();
					df.setRowCount(0);
					
					while(rs.next()) {
						
						Vector v2 = new Vector();
						
						for(int i = 1 ; i <=c ; i++) {
							
							v2.add(rs.getString("Plaka"));
							v2.add(rs.getString("Marka"));
							v2.add(rs.getString("Model"));
							v2.add(rs.getString("Yıl"));
							v2.add(rs.getString("Yakıt"));
							v2.add(rs.getString("Vites"));
							v2.add(rs.getString("Gunluk_Ucret"));
							
						}
						df.addRow(v2);
						
						
					}
					
				}
				 catch(SQLException Exception) {
					 db.ShowError(Exception);
				 }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(519, 432, 141, 38);
		contentPane.add(btnNewButton);
		tableAracKayit.getColumnModel().getColumn(0).setPreferredWidth(83);
		tableAracKayit.getColumnModel().getColumn(0).setMinWidth(30);
		tableAracKayit.getColumnModel().getColumn(1).setPreferredWidth(83);
		tableAracKayit.getColumnModel().getColumn(1).setMinWidth(30);
		tableAracKayit.getColumnModel().getColumn(2).setPreferredWidth(83);
		tableAracKayit.getColumnModel().getColumn(2).setMinWidth(30);
		tableAracKayit.getColumnModel().getColumn(3).setPreferredWidth(83);
		tableAracKayit.getColumnModel().getColumn(3).setMinWidth(30);
		tableAracKayit.getColumnModel().getColumn(4).setPreferredWidth(83);
		tableAracKayit.getColumnModel().getColumn(4).setMinWidth(30);
		tableAracKayit.getColumnModel().getColumn(5).setPreferredWidth(83);
		tableAracKayit.getColumnModel().getColumn(5).setMinWidth(30);
		tableAracKayit.getColumnModel().getColumn(5).setMaxWidth(2147483645);
		tableAracKayit.getColumnModel().getColumn(6).setPreferredWidth(83);
		tableAracKayit.getColumnModel().getColumn(6).setMinWidth(30);
	}
}

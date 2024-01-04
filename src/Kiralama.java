import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Kiralama extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textMusteriID;
	private JTextField textAdSoyad;
	private JTextField textUcret;
	private JTextField textGunSayisi;
	private JTable table;
	private JTextField textPlaka;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kiralama frame = new Kiralama();
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

	
	public Kiralama() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelKiralama = new JPanel();
		panelKiralama.setBounds(10, 17, 314, 486);
		panelKiralama.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Ara\u00E7 Kiralama", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panelKiralama);
		panelKiralama.setLayout(null);
		
		JLabel lblPlaka = new JLabel("Araç Plaka");
		lblPlaka.setBounds(10, 20, 95, 36);
		lblPlaka.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelKiralama.add(lblPlaka);
		
		JLabel lblMusteriID = new JLabel("E-mail");
		lblMusteriID.setBounds(10, 91, 95, 36);
		lblMusteriID.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelKiralama.add(lblMusteriID);
		
		JLabel lblMusteriAdSoyad = new JLabel("Ad Soyad");
		lblMusteriAdSoyad.setBounds(10, 161, 95, 36);
		lblMusteriAdSoyad.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelKiralama.add(lblMusteriAdSoyad);
		
		JLabel lblToplamUcret = new JLabel("Toplam Ücret");
		lblToplamUcret.setBounds(10, 300, 105, 36);
		lblToplamUcret.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelKiralama.add(lblToplamUcret);
		
		JButton btnKirala = new JButton("Kirala");
		btnKirala.setBounds(55, 387, 111, 49);
		btnKirala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnKirala, "Araç kiralama işleminiz başarıyla gerçekleşmiştir.");
				
			}
		});
		btnKirala.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelKiralama.add(btnKirala);
		
		textMusteriID = new JTextField();
		textMusteriID.setFont(new Font("Tahoma", Font.BOLD, 12));
		textMusteriID.setBounds(140, 101, 164, 21);
		panelKiralama.add(textMusteriID);
		textMusteriID.setColumns(10);
		
		textAdSoyad = new JTextField();
		textAdSoyad.setFont(new Font("Tahoma", Font.BOLD, 12));
		textAdSoyad.setBounds(140, 171, 164, 21);
		textAdSoyad.setColumns(10);
		panelKiralama.add(textAdSoyad);
		
		textUcret = new JTextField();
		textUcret.setFont(new Font("Tahoma", Font.BOLD, 12));
		textUcret.setBounds(140, 310, 164, 21);
		textUcret.setColumns(10);
		panelKiralama.add(textUcret);
		
		JLabel lblGunSayisi = new JLabel("Gün Sayısı");
		lblGunSayisi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGunSayisi.setBounds(10, 230, 95, 36);
		panelKiralama.add(lblGunSayisi);
		
		textGunSayisi = new JTextField();
		textGunSayisi.setFont(new Font("Tahoma", Font.BOLD, 12));
		textGunSayisi.setColumns(10);
		textGunSayisi.setBounds(140, 240, 164, 21);
		panelKiralama.add(textGunSayisi);
		
		JButton btnIptal = new JButton("İptal");
		btnIptal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				setVisible(false);
			}
		});
		btnIptal.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnIptal.setBounds(193, 387, 111, 49);
		panelKiralama.add(btnIptal);
		
		textPlaka = new JTextField();
		textPlaka.setFont(new Font("Tahoma", Font.BOLD, 12));
		textPlaka.setBounds(139, 30, 165, 21);
		panelKiralama.add(textPlaka);
		textPlaka.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel d1 = (DefaultTableModel) table.getModel();
				
				int selectedIndex = table.getSelectedRow();
				
				textPlaka.setText(d1.getValueAt(selectedIndex, 0).toString());
				
				
				
			}
		});
		scrollPane.setBounds(334, 10, 380, 243);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 10));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Plaka", "Marka", "Model", "Y\u0131l", "Yak\u0131t", "Vites", "G\u00FCnl\u00FCk \u00DCcret"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JButton btnNewButton = new JButton("Araçları Göster");
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
					DefaultTableModel df = (DefaultTableModel) table.getModel();
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
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(464, 399, 131, 52);
		contentPane.add(btnNewButton);
	}
}

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class MusteriKayit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textisim;
	private JTextField textSoyisim;
	private JTextField textEmail;
	private JTable tableMusteriKayit;
	private JPasswordField passwordSifre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusteriKayit frame = new MusteriKayit();
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
	public MusteriKayit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelMusteriKayit = new JPanel();
		panelMusteriKayit.setLayout(null);
		panelMusteriKayit.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "M\u00FC\u015Fteri Kay\u0131t", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panelMusteriKayit.setBounds(10, 20, 369, 473);
		contentPane.add(panelMusteriKayit);
		
		JButton btnEkle = new JButton("Ekle");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement statement = null;
				DbHelper db = new DbHelper();
				
				try {
					con=db.getConnection();
					String query = "insert into araclar.customer(Ad,Soyad,Email,Sifre)"
							+ "values (?,?,?,?)";
					statement = con.prepareStatement(query);
					statement.setString(1, textisim.getText());
					statement.setString(2, textSoyisim.getText());
					statement.setString(3, textEmail.getText());
					statement.setString(4, passwordSifre.getText());
					
					statement.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Kaydınız başarıyla gerçekleştirilmiştir.");
				}
				catch(SQLException Exception) {
					db.ShowError(Exception);
					
				}
				String isim = textisim.getText();
				String soyisim = textSoyisim.getText();
				String email = textEmail.getText();
				
			
			}
		});
		btnEkle.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnEkle.setBounds(57, 379, 116, 50);
		panelMusteriKayit.add(btnEkle);
		
		JButton btnIptal = new JButton("İptal");
		btnIptal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				setVisible(false);
			}
		});
		btnIptal.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnIptal.setBounds(213, 379, 116, 50);
		panelMusteriKayit.add(btnIptal);
		
		JLabel lblisim = new JLabel("Soyisim");
		lblisim.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblisim.setBounds(32, 116, 100, 50);
		panelMusteriKayit.add(lblisim);
		
		JLabel lblSoyisim = new JLabel("Email");
		lblSoyisim.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSoyisim.setBounds(32, 195, 100, 50);
		panelMusteriKayit.add(lblSoyisim);
		
		JLabel lblEmail = new JLabel("Şifre");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEmail.setBounds(32, 274, 100, 50);
		panelMusteriKayit.add(lblEmail);
		
		textisim = new JTextField();
		textisim.setFont(new Font("Tahoma", Font.BOLD, 14));
		textisim.setBounds(170, 55, 159, 30);
		panelMusteriKayit.add(textisim);
		textisim.setColumns(10);
		
		textSoyisim = new JTextField();
		textSoyisim.setFont(new Font("Tahoma", Font.BOLD, 14));
		textSoyisim.setColumns(10);
		textSoyisim.setBounds(170, 128, 159, 30);
		panelMusteriKayit.add(textSoyisim);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		textEmail.setColumns(10);
		textEmail.setBounds(170, 207, 159, 30);
		panelMusteriKayit.add(textEmail);
		
		JLabel lblMusteriID = new JLabel("İsim");
		lblMusteriID.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMusteriID.setBounds(32, 43, 116, 50);
		panelMusteriKayit.add(lblMusteriID);
		
		passwordSifre = new JPasswordField();
		passwordSifre.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordSifre.setBounds(170, 288, 159, 30);
		panelMusteriKayit.add(passwordSifre);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(390, 19, 413, 474);
		contentPane.add(scrollPane);
		
		tableMusteriKayit = new JTable();
		tableMusteriKayit.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setViewportView(tableMusteriKayit);
		tableMusteriKayit.setFont(new Font("Tahoma", Font.BOLD, 13));
		tableMusteriKayit.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"M\u00FC\u015Fteri ID", "\u0130sim", "Soyisim", "Email"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableMusteriKayit.getColumnModel().getColumn(0).setPreferredWidth(112);
		tableMusteriKayit.getColumnModel().getColumn(0).setMinWidth(30);
		tableMusteriKayit.getColumnModel().getColumn(1).setPreferredWidth(112);
		tableMusteriKayit.getColumnModel().getColumn(1).setMinWidth(30);
		tableMusteriKayit.getColumnModel().getColumn(2).setPreferredWidth(112);
		tableMusteriKayit.getColumnModel().getColumn(2).setMinWidth(30);
		tableMusteriKayit.getColumnModel().getColumn(3).setPreferredWidth(112);
		tableMusteriKayit.getColumnModel().getColumn(3).setMinWidth(30);
	}
}

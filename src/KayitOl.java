import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import java.awt.Color;

public class KayitOl extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textAd;
	private JTextField textSoyad;
	private JTextField textEmail;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KayitOl frame = new KayitOl();
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
	public KayitOl() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Kay\u0131t Ol", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 10, 496, 503);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAd = new JLabel("Ad");
		lblAd.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAd.setBounds(36, 60, 132, 46);
		panel.add(lblAd);
		
		JLabel lblSoyad = new JLabel("Soyad");
		lblSoyad.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSoyad.setBounds(36, 136, 132, 46);
		panel.add(lblSoyad);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(36, 214, 132, 46);
		panel.add(lblEmail);
		
		JLabel lblSifre = new JLabel("Şifre");
		lblSifre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSifre.setBounds(36, 286, 132, 46);
		panel.add(lblSifre);
		
		textAd = new JTextField();
		textAd.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAd.setBounds(178, 67, 147, 33);
		panel.add(textAd);
		textAd.setColumns(10);
		
		textSoyad = new JTextField();
		textSoyad.setFont(new Font("Tahoma", Font.BOLD, 14));
		textSoyad.setColumns(10);
		textSoyad.setBounds(178, 143, 147, 33);
		panel.add(textSoyad);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		textEmail.setColumns(10);
		textEmail.setBounds(178, 221, 147, 33);
		panel.add(textEmail);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordField.setBounds(178, 293, 147, 33);
		panel.add(passwordField);
		
		JButton btnIptal = new JButton("Geri");
		btnIptal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				setVisible(false);
				
			}
		});
		btnIptal.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnIptal.setBounds(325, 392, 125, 46);
		panel.add(btnIptal);
		
		JButton btnKayitOl = new JButton("Kayıt Ol");
		btnKayitOl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement statement = null;
				DbHelper db = new DbHelper();
				
				try {
					con=db.getConnection();
					String query = "insert into araclar.customer(Ad,Soyad,Email,Sifre)"
							+ "values (?,?,?,?)";
					statement = con.prepareStatement(query);
					statement.setString(1, textAd.getText());
					statement.setString(2, textSoyad.getText());
					statement.setString(3, textEmail.getText());
					statement.setString(4, passwordField.getText());
					
					
					statement.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Kayıt işlemi başarıyla tamamlandı.");
				}
				catch(SQLException Exception) {
					db.ShowError(Exception);
					
				}
			}
		});
		btnKayitOl.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnKayitOl.setBounds(178, 392, 125, 46);
		panel.add(btnKayitOl);
	}
}

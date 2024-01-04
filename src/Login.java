import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textEmail;
	private JPasswordField textSifre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setForeground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 560);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("RENT A CAR");
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblNewLabel_2.setBounds(69, 0, 608, 117);
		contentPane.add(lblNewLabel_2);
		
		JPanel panelGiris = new JPanel();
		panelGiris.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Giri\u015F", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panelGiris.setBounds(69, 127, 669, 336);
		contentPane.add(panelGiris);
		panelGiris.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEmail.setBounds(115, 89, 147, 45);
		panelGiris.add(lblEmail);
		
		JLabel lbsifre = new JLabel("Şifre");
		lbsifre.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbsifre.setBounds(115, 158, 147, 45);
		panelGiris.add(lbsifre);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		textEmail.setBounds(319, 100, 167, 28);
		panelGiris.add(textEmail);
		textEmail.setColumns(10);
		
		JButton btnGiris = new JButton("Giriş");
		btnGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kiralama k = new Kiralama()	;
				
				Connection con = null;
				
				DbHelper db = new DbHelper();
				
				try {
					
					con= db.getConnection();
					Statement stm = con.createStatement();
					String email = textEmail.getText();
					@SuppressWarnings("deprecation")
					String password = textSifre.getText();
					
					String query = "select * from customer where Email='"+email+"' and Sifre='"+password+"'";
					ResultSet rs = stm.executeQuery(query);
					
					if(rs.next()) {
						dispose();
						Kiralama kiralama = new Kiralama();
						kiralama.show();
					}
					else {
						JOptionPane.showMessageDialog(btnGiris, "Hatalı e-mail veya şifre.");
						
					}
					
					
				}
				catch(SQLException Exception) {
					db.ShowError(Exception);
					
				}
				
				
			}
		});
		btnGiris.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnGiris.setBounds(319, 242, 137, 60);
		panelGiris.add(btnGiris);
		
		textSifre = new JPasswordField();
		textSifre.setFont(new Font("Tahoma", Font.BOLD, 15));
		textSifre.setBounds(319, 171, 167, 28);
		panelGiris.add(textSifre);
		
		JButton btnKayitOl = new JButton("Kayıt Ol");
		btnKayitOl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KayitOl k = new KayitOl();
				k.setVisible(true);
				setVisible(false);
				
			}
		});
		btnKayitOl.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnKayitOl.setBounds(485, 242, 137, 60);
		panelGiris.add(btnKayitOl);
		
		JButton btnAdminGirisi = new JButton("Admin Girişi");
		btnAdminGirisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminGirisi a = new AdminGirisi();
				a.setVisible(true);
				setVisible(false);
				
			}
		});
		btnAdminGirisi.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdminGirisi.setBounds(531, 22, 128, 45);
		panelGiris.add(btnAdminGirisi);
	}
}

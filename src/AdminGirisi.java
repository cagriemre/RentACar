import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminGirisi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textKullaniciAdi;
	private JPasswordField passwordSifre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGirisi frame = new AdminGirisi();
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
	public AdminGirisi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelAdminGirisi = new JPanel();
		panelAdminGirisi.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Admin Giri\u015Fi", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panelAdminGirisi.setBounds(10, 10, 496, 375);
		contentPane.add(panelAdminGirisi);
		panelAdminGirisi.setLayout(null);
		
		JLabel lblKullaniciAdi = new JLabel("Kullanıcı Adı");
		lblKullaniciAdi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblKullaniciAdi.setBounds(21, 65, 148, 54);
		panelAdminGirisi.add(lblKullaniciAdi);
		
		JLabel lblSifre = new JLabel("Şifre");
		lblSifre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSifre.setBounds(21, 165, 148, 54);
		panelAdminGirisi.add(lblSifre);
		
		textKullaniciAdi = new JTextField();
		textKullaniciAdi.setFont(new Font("Tahoma", Font.BOLD, 14));
		textKullaniciAdi.setBounds(191, 74, 166, 32);
		panelAdminGirisi.add(textKullaniciAdi);
		textKullaniciAdi.setColumns(10);
		
		passwordSifre = new JPasswordField();
		passwordSifre.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordSifre.setBounds(191, 175, 166, 32);
		panelAdminGirisi.add(passwordSifre);
		
		JButton btnGiris = new JButton("Giriş");
		btnGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kullaniciAdi = textKullaniciAdi.getText();
				String sifre = passwordSifre.getText();
				String login = "Kullanıcı adı veya şifre yanlış";
				if(kullaniciAdi.equals("emre") && sifre.equals("emre123")) {
					AracKayit m = new AracKayit();
					m.setVisible(true);
					setVisible(false);
					
				}
				else {
					JOptionPane.showMessageDialog(btnGiris,login,"Hatalı giriş",0);
				}
			}
		});
		btnGiris.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnGiris.setBounds(156, 271, 140, 54);
		panelAdminGirisi.add(btnGiris);
		
		JButton btnIptal = new JButton("İptal");
		btnIptal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				setVisible(false);
				
			}
		});
		btnIptal.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnIptal.setBounds(317, 271, 140, 54);
		panelAdminGirisi.add(btnIptal);
	}

}

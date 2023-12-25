import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

public class Kiralama extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textMusteriID;
	private JTextField textAdSoyad;
	private JTextField textUcret;
	private JTextField textGunSayisi;

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
		setBounds(100, 100, 530, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelKiralama = new JPanel();
		panelKiralama.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Ara\u00E7 Kiralama", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelKiralama.setBounds(10, 10, 496, 486);
		contentPane.add(panelKiralama);
		panelKiralama.setLayout(null);
		
		JLabel lblAracID = new JLabel("Araç ID");
		lblAracID.setBounds(10, 20, 95, 36);
		lblAracID.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelKiralama.add(lblAracID);
		
		JLabel lblMusteriID = new JLabel("Müşteri ID");
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
		btnKirala.setBounds(223, 387, 111, 49);
		btnKirala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnKirala.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelKiralama.add(btnKirala);
		
		JComboBox comboBoxAracID = new JComboBox();
		comboBoxAracID.setBounds(140, 30, 164, 21);
		panelKiralama.add(comboBoxAracID);
		
		textMusteriID = new JTextField();
		textMusteriID.setBounds(140, 101, 164, 21);
		panelKiralama.add(textMusteriID);
		textMusteriID.setColumns(10);
		
		textAdSoyad = new JTextField();
		textAdSoyad.setBounds(140, 171, 164, 21);
		textAdSoyad.setColumns(10);
		panelKiralama.add(textAdSoyad);
		
		textUcret = new JTextField();
		textUcret.setBounds(140, 310, 164, 21);
		textUcret.setColumns(10);
		panelKiralama.add(textUcret);
		
		JLabel lblGunSayisi = new JLabel("Gün Sayısı");
		lblGunSayisi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGunSayisi.setBounds(10, 230, 95, 36);
		panelKiralama.add(lblGunSayisi);
		
		textGunSayisi = new JTextField();
		textGunSayisi.setColumns(10);
		textGunSayisi.setBounds(140, 240, 164, 21);
		panelKiralama.add(textGunSayisi);
		
		JButton btnIptal = new JButton("İptal");
		btnIptal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnIptal.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnIptal.setBounds(362, 387, 111, 49);
		panelKiralama.add(btnIptal);
	}
}

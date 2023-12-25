import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
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
	public main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 596);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 10, 490, 539);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnArabaKayit = new JButton("Araba Kayıt");
		btnArabaKayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AracKayit arackayit = new AracKayit();
			arackayit.setVisible(true);
			}
		});
		btnArabaKayit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnArabaKayit.setBounds(162, 61, 157, 66);
		panel.add(btnArabaKayit);
		
		JButton btnMusteri = new JButton("Müşteri Kayıt");
		btnMusteri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MusteriKayit m = new MusteriKayit();
				m.setLocation(getLocation());
			}
		});
		btnMusteri.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMusteri.setBounds(162, 172, 157, 66);
		panel.add(btnMusteri);
		
		JButton btnKiralama = new JButton("Araç Kiralama");
		btnKiralama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kiralama k = new Kiralama();
				k.setVisible(true);
				
			}
		});
		btnKiralama.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnKiralama.setBounds(162, 285, 157, 66);
		panel.add(btnKiralama);
		
		JButton btnCikis = new JButton("Çıkış");
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCikis.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCikis.setBounds(162, 402, 157, 66);
		panel.add(btnCikis);
	}
}

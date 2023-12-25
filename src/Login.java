import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
	private JTextField textUsername;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("RENT A CAR");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblNewLabel_2.setBounds(69, 0, 608, 117);
		contentPane.add(lblNewLabel_2);
		
		JPanel panelGiris = new JPanel();
		panelGiris.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Giri\u015F", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panelGiris.setBounds(69, 127, 669, 336);
		contentPane.add(panelGiris);
		panelGiris.setLayout(null);
		
		JLabel lblUsername = new JLabel("Kullanıcı Adı");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsername.setBounds(115, 89, 147, 45);
		panelGiris.add(lblUsername);
		
		JLabel lbsifre = new JLabel("Şifre");
		lbsifre.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbsifre.setBounds(115, 158, 147, 45);
		panelGiris.add(lbsifre);
		
		textUsername = new JTextField();
		textUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		textUsername.setBounds(319, 102, 167, 28);
		panelGiris.add(textUsername);
		textUsername.setColumns(10);
		
		JButton btnGiris = new JButton("Giriş");
		btnGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textUsername.getText();
				String sifre = textSifre.getText();
				String login = "Kullanıcı adı veya şifre yanlış";
				if(username.equals("emre") && sifre.equals("3131")) {
					main m = new main();
					m.setVisible(true);
					
				}
				else {
					JOptionPane.showMessageDialog(btnGiris,login,"Hatalı giriş",0);
				}
				
				
				
				
				
			}
		});
		btnGiris.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnGiris.setBounds(349, 242, 137, 60);
		panelGiris.add(btnGiris);
		
		textSifre = new JPasswordField();
		textSifre.setFont(new Font("Tahoma", Font.BOLD, 15));
		textSifre.setBounds(319, 171, 167, 28);
		panelGiris.add(textSifre);
	}
}

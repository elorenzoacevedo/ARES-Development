package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * Main menu for the ARES application
 * @author Ezequiel Lorenzo
 * @version 11/21/2022
 *
 */
public class MainMenu extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5843332480414625328L;
	private JPanel contentPane;
	private JButton btnSalir;
	private JButton btnIniciarSesion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		new MainMenu();
		
	}

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		initComponents();
		createEvents();
		setVisible(true);
	}
	
	private void initComponents() {
		
		
		try {
			
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 400, 300);
			setResizable(false);
			setLocationRelativeTo(null);
			contentPane = new JPanel();
			contentPane.setBackground(SystemColor.menu);
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JPanel pnlTitle = new JPanel();
			pnlTitle.setBackground(new Color(192, 192, 192));
			pnlTitle.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			pnlTitle.setBounds(10, 11, 366, 75);
			contentPane.add(pnlTitle);
			pnlTitle.setLayout(null);
			
			JLabel lblTitle = new JLabel("ARES");
			lblTitle.setForeground(new Color(0, 0, 0));
			lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitle.setFont(new Font("Trebuchet MS", Font.BOLD, 45));
			lblTitle.setBounds(10, 11, 345, 53);
			pnlTitle.add(lblTitle);
			
			btnIniciarSesion = new JButton("Iniciar Sesi\u00F3n");
			btnIniciarSesion.setActionCommand("Iniciar Sesion");
			btnIniciarSesion.setFocusable(false);
			btnIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnIniciarSesion.setBackground(Color.LIGHT_GRAY);
			btnIniciarSesion.setBounds(106, 142, 180, 39);
			contentPane.add(btnIniciarSesion);
			
			btnSalir = new JButton("Salir");
			btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnSalir.setFocusable(false);
			btnSalir.setBackground(Color.LIGHT_GRAY);
			btnSalir.setBounds(126, 192, 140, 39);
			contentPane.add(btnSalir);
		}
		catch(Throwable t) {
			t.printStackTrace();
		}
		
	}
	
	private void createEvents() {
		btnSalir.addActionListener(this);
		btnIniciarSesion.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String command = e.getActionCommand();
		
		switch(command) {
		
		//Exit button
		case "Salir" : System.exit(0); break;
		//Login button
		case "Iniciar Sesion" : 
			//Login code here
			
			//Login code here
			dispose();
			new ApplicationWindow();
			break;
			
		}
		
	}
}

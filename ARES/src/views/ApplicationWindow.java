package views;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

/**
 * Main application window for the ARES application
 * @author Ezequiel Lorenzo
 * @version 11/21/2022
 */
public class ApplicationWindow extends JFrame implements ActionListener{

	private static final long serialVersionUID = -8681803560609606939L;
	private JPanel contentPane;
	private CardLayout panels;
	private JList<String> gradeList;
	private DefaultListModel<String> model = new DefaultListModel<>();
	private JButton btnMenuPrincipal;
	private JButton btnAñadirGrado;
	private JButton button;
	
	private final String GRADES_PANEL = "Grades Panel";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationWindow frame = new ApplicationWindow();
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
	public ApplicationWindow() {
		initComponents();
		//If admin user
		administrativeTasks();
		//If admin user
		createEvents();
		setVisible(true);
	}
	
	private void initComponents() {
		
		try {
			
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1000, 500);
			setLocationRelativeTo(null);
			contentPane = new JPanel();
			contentPane.setBackground(SystemColor.menu);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(new CardLayout(0, 0));
			
			JPanel pnlGradeList = new JPanel();
			contentPane.add(pnlGradeList, GRADES_PANEL);
			
			JScrollPane scrollPane = new JScrollPane();
			
			button = new JButton("New button");
			button.setBackground(Color.LIGHT_GRAY);
			button.setFocusable(false);
			
			btnMenuPrincipal = new JButton("Men\u00FA Principal");
			btnMenuPrincipal.setActionCommand("Menu Principal");
			btnMenuPrincipal.setBackground(Color.LIGHT_GRAY);
			btnMenuPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnMenuPrincipal.setFocusable(false);
			
			btnAñadirGrado = new JButton("A\u00F1adir Grado");
			btnAñadirGrado.setBackground(Color.LIGHT_GRAY);
			btnAñadirGrado.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnAñadirGrado.setFocusable(false);
			btnAñadirGrado.setVisible(false);
			GroupLayout gl_pnlGradeList = new GroupLayout(pnlGradeList);
			gl_pnlGradeList.setHorizontalGroup(
				gl_pnlGradeList.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnlGradeList.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_pnlGradeList.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnlGradeList.createSequentialGroup()
								.addGap(10)
								.addComponent(button, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
								.addGap(131)
								.addComponent(btnAñadirGrado, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
								.addGap(155)
								.addComponent(btnMenuPrincipal, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
								.addGap(22))
							.addGroup(gl_pnlGradeList.createSequentialGroup()
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE)
								.addGap(11))))
			);
			gl_pnlGradeList.setVerticalGroup(
				gl_pnlGradeList.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnlGradeList.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_pnlGradeList.createParallelGroup(Alignment.LEADING)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnMenuPrincipal, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnAñadirGrado, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
						.addGap(25))
			);
			
			gradeList = new JList<>();
			gradeList.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
			gradeList.setModel(model);
			gradeList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			gradeList.setBackground(Color.LIGHT_GRAY);
			scrollPane.setViewportView(gradeList);
			pnlGradeList.setLayout(gl_pnlGradeList);
			
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			
			JMenu mnNewMenu = new JMenu("New menu");
			menuBar.add(mnNewMenu);
			
			JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
			mnNewMenu.add(mntmNewMenuItem);
			
		}
		
		catch(Throwable t) {
			t.printStackTrace();
		}
	}
	
	private void createEvents() {
		panels = (CardLayout) contentPane.getLayout();
		btnMenuPrincipal.addActionListener(this);
	}
	
	private void administrativeTasks() {
		btnAñadirGrado.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String command = e.getActionCommand();
		
		switch(command) {
		
		case "Menu Principal" : 
			dispose();
			new MainMenu();
			break;
			
		}
		
	}
}
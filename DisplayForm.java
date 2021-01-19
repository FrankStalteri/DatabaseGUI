import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class DisplayForm {

	private JFrame displayForm;
	private JTable displayTable;

	/**
	 * Launch the application.
	 */
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayForm window = new DisplayForm();
					window.displayForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DisplayForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		displayForm = new JFrame();
		displayForm.setTitle("Display Form");
		displayForm.setBounds(100, 100, 450, 300);
		displayForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		displayForm.getContentPane().setLayout(null);
		
		JLabel displayTitleLabel = new JLabel("Display Table");
		displayTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		displayTitleLabel.setBounds(152, 10, 138, 23);
		displayForm.getContentPane().add(displayTitleLabel);
		
		displayTable = new JTable();
		displayTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"firstName", "lastName", "age"
			}
		));
		displayTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		displayTable.setBounds(95, 43, 247, 134);
		displayForm.getContentPane().add(displayTable);
		
		JButton displayButton = new JButton("Display");
		displayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName = "";
				String lastName = "";
				String age = "";
				
				try {
					String user = "root";
					String password = "";
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", user, password);
					Statement stmnt = con.createStatement();
					
					String sql = "Select * from test";
					
					ResultSet results = stmnt.executeQuery(sql);
					
					while (results.next()) {
						firstName = results.getString("firstName");
						lastName = results.getString("lastName");
						age = results.getString("age");
						
						// to console
						System.out.println("First Name: " + firstName);
						System.out.println("Last Name: " + lastName);
						System.out.println("Age: " + age + "\n");
						
						String [] tableData = {firstName, lastName, age};
						DefaultTableModel model = (DefaultTableModel)displayTable.getModel();
						displayTable.setModel(model);
						
						model.addRow(tableData);
					}
				}
				catch (Exception a) {
					a.printStackTrace();
				}
			}
		});
		displayButton.setToolTipText("Displays table.");
		displayButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		displayButton.setBounds(176, 196, 85, 39);
		displayForm.getContentPane().add(displayButton);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				displayForm.setVisible(false);
				menu.run();
			}
		});
		btnNewButton.setToolTipText("Go to menu page.");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(0, 0, 85, 21);
		displayForm.getContentPane().add(btnNewButton);
		
	}
}

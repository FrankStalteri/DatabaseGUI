import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddForm {

	private JFrame frmAddForm;
	private JTextField firstNameText;
	private JTextField lastNameText;
	private JTextField ageText;

	/**
	 * Launch the application.
	 */
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddForm window = new AddForm();
					window.frmAddForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddForm = new JFrame();
		frmAddForm.setTitle("Add Form");
		frmAddForm.setBounds(100, 100, 450, 300);
		frmAddForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddForm.getContentPane().setLayout(null);
		
		JLabel addFormTitle = new JLabel("Add Form");
		addFormTitle.setFont(new Font("Tahoma", Font.BOLD, 19));
		addFormTitle.setBounds(174, 10, 108, 23);
		frmAddForm.getContentPane().add(addFormTitle);
		
		JLabel firstNameLabel = new JLabel("First Name:");
		firstNameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		firstNameLabel.setBounds(10, 72, 76, 13);
		frmAddForm.getContentPane().add(firstNameLabel);
		
		JLabel lastNameLabel = new JLabel("Last Name:");
		lastNameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lastNameLabel.setBounds(10, 120, 76, 13);
		frmAddForm.getContentPane().add(lastNameLabel);
		
		JLabel ageLabel = new JLabel("Age:");
		ageLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		ageLabel.setBounds(10, 165, 76, 13);
		frmAddForm.getContentPane().add(ageLabel);
		
		firstNameText = new JTextField();
		firstNameText.setToolTipText("Enter first name.");
		firstNameText.setBounds(146, 70, 96, 19);
		frmAddForm.getContentPane().add(firstNameText);
		firstNameText.setColumns(10);
		
		lastNameText = new JTextField();
		lastNameText.setToolTipText("Enter last name.");
		lastNameText.setColumns(10);
		lastNameText.setBounds(146, 118, 96, 19);
		frmAddForm.getContentPane().add(lastNameText);
		
		ageText = new JTextField();
		ageText.setToolTipText("Enter age.");
		ageText.setColumns(10);
		ageText.setBounds(146, 163, 96, 19);
		frmAddForm.getContentPane().add(ageText);
		
		JLabel statusLabel = new JLabel("");
		statusLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		statusLabel.setBounds(294, 121, 122, 23);
		frmAddForm.getContentPane().add(statusLabel);
		
		JButton addButton = new JButton("Add");
		addButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					// holds the values from text fields later
					String firstName = "";
					String lastName = "";
					int age = 0;
					
					String user = "root";
					String password = "";
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", user, password);
					Statement stmnt = con.createStatement();
					
					// get the values from text field
					firstName = firstNameText.getText();
					lastName = lastNameText.getText();
					age = Integer.parseInt(ageText.getText());
					
					String sql =  "insert into test (firstName, lastName, age)" + 
					"values (" + "'" + firstName + "',"  + "'" + lastName + "'," + "'" + age + "')"; 
					
					if (stmnt.execute(sql) == false) {
						//System.out.println("Record added.");
						String message = "Record added.";
						statusLabel.setText(message);
						firstNameText.setText(null);
						lastNameText.setText(null);
						ageText.setText(null);
					}
					else {
						//System.out.println("Recorded failed to add.");
						String message = "Failed to add record.";
						statusLabel.setText(message);
					}
				}
				catch (Exception a) {
					a.printStackTrace();
				}
			}
		});
		addButton.setToolTipText("Add record to database.");
		addButton.setBounds(157, 211, 85, 42);
		frmAddForm.getContentPane().add(addButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAddForm.setVisible(false);
				Menu menu = new Menu();
				menu.run();
			}
		});
		backButton.setBounds(0, 0, 85, 21);
		frmAddForm.getContentPane().add(backButton);
	}
}

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JRadioButton;
import java.awt.Color;

public class UpdateForm {

	private JFrame updateForm;
	private JTextField dataText;
	private JTextField firstNameText;

	/**
	 * Launch the application.
	 */
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateForm window = new UpdateForm();
					window.updateForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UpdateForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		updateForm = new JFrame();
		updateForm.setTitle("Update Form");
		updateForm.setBounds(100, 100, 450, 300);
		updateForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		updateForm.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Table");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(146, 10, 132, 20);
		updateForm.getContentPane().add(lblNewLabel);
		
		JLabel updateByLabel = new JLabel("Update By:");
		updateByLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		updateByLabel.setBounds(176, 40, 85, 20);
		updateForm.getContentPane().add(updateByLabel);
		
		JRadioButton firstNameRDButton = new JRadioButton("First Name");
		firstNameRDButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		firstNameRDButton.setBounds(16, 76, 103, 21);
		updateForm.getContentPane().add(firstNameRDButton);
		
		JRadioButton lastNameRDButton = new JRadioButton("Last Name");
		lastNameRDButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		lastNameRDButton.setBounds(16, 118, 103, 21);
		updateForm.getContentPane().add(lastNameRDButton);
		
		JRadioButton ageRDButton = new JRadioButton("Age");
		ageRDButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		ageRDButton.setBounds(16, 157, 103, 21);
		updateForm.getContentPane().add(ageRDButton);
		
		dataText = new JTextField();
		dataText.setToolTipText("Enter information.");
		dataText.setBounds(249, 97, 96, 19);
		updateForm.getContentPane().add(dataText);
		dataText.setColumns(10);

		firstNameText = new JTextField();
		firstNameText.setToolTipText("Enter the first name (identifier).");
		firstNameText.setBounds(249, 147, 96, 19);
		updateForm.getContentPane().add(firstNameText);
		firstNameText.setColumns(10);
		
		JLabel statusLabel = new JLabel("");
		statusLabel.setForeground(Color.RED);
		statusLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		statusLabel.setBounds(185, 214, 241, 20);
		updateForm.getContentPane().add(statusLabel);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = "root";
				String password = "";
				
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", user, password);
					if (firstNameRDButton.isSelected()) {
		
						PreparedStatement stmnt = con.prepareStatement("Update test set firstName = ? where firstName = ?");
						
						String firstName = dataText.getText();
						String identifier = firstNameText.getText();
						
						if (firstName.contentEquals("") && identifier.contentEquals("")) {
							statusLabel.setText("Text boxes are missing values.");
							
							con.close();
						}
						else {
							
							stmnt.setString(1, firstName);
							stmnt.setString(2, identifier);
							stmnt.executeUpdate();
							
							statusLabel.setText("Table updated.");
							dataText.setText(null);
							firstNameText.setText(null);
							con.close();
						}
					}
					else if (lastNameRDButton.isSelected()) {
						//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", user, password);
						PreparedStatement stmnt = con.prepareStatement("Update test set lastName = ? where firstName = ?");
						
						String lastName = dataText.getText();
						String identifier = firstNameText.getText();
						
							if (lastName.contains("") && identifier.contains("")) {
								statusLabel.setText("Text boxes are missing values.");
								
								con.close();
							}
							else {
								
								stmnt.setString(1, lastName);
								stmnt.setString(2, identifier);
								stmnt.executeUpdate();
								
								statusLabel.setText("Table updated.");
								dataText.setText(null);
								firstNameText.setText(null);
								con.close();
							}
					}
					else if (ageRDButton.isSelected()) {
						//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", user, password);
						PreparedStatement stmnt = con.prepareStatement("Update test set age = ? where firstName = ?");
						
						String age = dataText.getText();
						String identifier = firstNameText.getText();
						
						if (age.contains("") && identifier.contains("")) {
							statusLabel.setText("Text boxes are missing values.");
							
							con.close();
						}
						else {
							
							stmnt.setString(1, age);
							stmnt.setString(2, identifier);
							stmnt.executeUpdate();
							
							statusLabel.setText("Table updated.");
							dataText.setText(null);
							firstNameText.setText(null);
							con.close();
						}
					}
					else {
						statusLabel.setText("No choice selected.");
					}
				}
				catch (Exception a) {
					a.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(90, 194, 85, 59);
		updateForm.getContentPane().add(btnNewButton);	
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateForm.setVisible(false);
				Menu menu = new Menu();
				menu.run();
			}
		});
		backButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		backButton.setToolTipText("Back to menu.");
		backButton.setBounds(2, 0, 85, 21);
		updateForm.getContentPane().add(backButton);
		
	}
}

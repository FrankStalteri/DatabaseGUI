import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.sql.*;
public class RemoveForm {

	private JFrame frmRemoveForm;
	private JTextField deleteText;

	/**
	 * Launch the application.
	 */
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveForm window = new RemoveForm();
					window.frmRemoveForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RemoveForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRemoveForm = new JFrame();
		frmRemoveForm.setTitle("Remove Form");
		frmRemoveForm.setBounds(100, 100, 450, 300);
		frmRemoveForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRemoveForm.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Remove Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(148, 10, 133, 22);
		frmRemoveForm.getContentPane().add(lblNewLabel);
		
		JButton backButton = new JButton("Back");
		backButton.setToolTipText("Back to menu.");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRemoveForm.setVisible(false);
				Menu menu = new Menu();
				menu.run();
			}
		});
		backButton.setBounds(0, 0, 85, 21);
		frmRemoveForm.getContentPane().add(backButton);
		
		JLabel lblNewLabel_1 = new JLabel("Remove record by last name column.\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(101, 42, 256, 22);
		frmRemoveForm.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(162, 93, 119, 22);
		frmRemoveForm.getContentPane().add(lblNewLabel_2);
		
		deleteText = new JTextField();
		deleteText.setToolTipText("Enter last name to delete.");
		deleteText.setBounds(148, 143, 133, 19);
		frmRemoveForm.getContentPane().add(deleteText);
		deleteText.setColumns(10);
		
		JLabel statusLabel = new JLabel("");
		statusLabel.setBounds(172, 120, 95, 13);
		frmRemoveForm.getContentPane().add(statusLabel);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String user = "root";
					String password = "";
					
					String lastName = deleteText.getText();
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", user, password);
					Statement stmnt = con.createStatement();
					
					String sql = "delete from test where lastName = " + "'" + lastName + "'";
					
					if (stmnt.execute(sql) == false) {
						String message =  "Record deleted.";
						statusLabel.setText(message);
						deleteText.setText(null);
						//System.out.println("Record removed.");
					}
					else {
						String message = "Delete failed.";
						statusLabel.setText(message);
						//System.out.println("Delete failed.");
					}
				}
				catch (Exception a) {
					a.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(168, 193, 85, 47);
		frmRemoveForm.getContentPane().add(btnNewButton);
	}
}

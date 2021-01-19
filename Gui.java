import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Gui {

	private JFrame frmLoginForm;
	private JTextField userTextField;
	private JPasswordField pwdTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frmLoginForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginForm = new JFrame();
		frmLoginForm.setTitle("Login Form");
		frmLoginForm.setBounds(100, 100, 450, 300);
		frmLoginForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginForm.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("Database Connector");
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		titleLabel.setBounds(107, 10, 240, 23);
		frmLoginForm.getContentPane().add(titleLabel);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		usernameLabel.setBounds(10, 81, 75, 13);
		frmLoginForm.getContentPane().add(usernameLabel);
		
		JLabel pwdLabel = new JLabel("Password:");
		pwdLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		pwdLabel.setBounds(10, 132, 75, 13);
		frmLoginForm.getContentPane().add(pwdLabel);
		
		userTextField = new JTextField();
		userTextField.setToolTipText("Enter user name.");
		userTextField.setBounds(113, 79, 119, 19);
		frmLoginForm.getContentPane().add(userTextField);
		userTextField.setColumns(10);
		
		JLabel statusLabel = new JLabel("");
		statusLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		statusLabel.setBounds(107, 172, 221, 13);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setToolTipText("Login to database.");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = userTextField.getText();
				String pwd = pwdTextField.getText();
				String user = "Frank";
				String pass = "hello";
				
				if (userName.equals(user) && pwd.equals(pass)) {
					//System.out.println("Logged in.");
					//String message = "Logged in.";
					//statusLabel.setText(message);
					frmLoginForm.setVisible(false);
					Menu menu = new Menu();
					menu.run();
				}
				else {
					//System.out.println("Incorrect credentials. Try again.");
					String message = "Incorrect credentials. Try again.";
					statusLabel.setText(message);
				}
				
			}
		});
		btnNewButton.setBounds(163, 195, 95, 42);
		frmLoginForm.getContentPane().add(btnNewButton);
		frmLoginForm.getContentPane().add(statusLabel);
		
		pwdTextField = new JPasswordField();
		pwdTextField.setToolTipText("Enter password.");
		pwdTextField.setBounds(113, 130, 119, 19);
		frmLoginForm.getContentPane().add(pwdTextField);
	}
}

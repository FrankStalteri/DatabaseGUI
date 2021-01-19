import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

	private JFrame frmMenu;

	/**
	 * Launch the application.
	 */
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frmMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenu = new JFrame();
		frmMenu.setTitle("Menu");
		frmMenu.setBounds(100, 100, 450, 300);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenu.getContentPane().setLayout(null);
		
		JLabel menuTitleLabel = new JLabel("Menu");
		menuTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		menuTitleLabel.setBounds(182, 10, 146, 23);
		frmMenu.getContentPane().add(menuTitleLabel);
		
		JButton addBtn = new JButton("Add Record");
		addBtn.setToolTipText("Go to add page.");
		addBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMenu.setVisible(false);
				AddForm addForm = new AddForm();
				addForm.run();
				
			}
		});
		addBtn.setBounds(37, 70, 117, 52);
		frmMenu.getContentPane().add(addBtn);
		
		JButton deleteBtn = new JButton("Delete Record");
		deleteBtn.setToolTipText("Go to delete page.");
		deleteBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMenu.setVisible(false);
				RemoveForm removeForm = new RemoveForm();
				removeForm.run();
			}
		});
		deleteBtn.setBounds(283, 70, 123, 52);
		frmMenu.getContentPane().add(deleteBtn);
		
		JButton displayBtn = new JButton("Display Table");
		displayBtn.setToolTipText("Go to display page.");
		displayBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMenu.setVisible(false);
				DisplayForm updateForm = new DisplayForm();
				updateForm.run();
			}
		});
		displayBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		displayBtn.setBounds(37, 176, 117, 52);
		frmMenu.getContentPane().add(displayBtn);
		
		JButton updateBtn = new JButton("Update Record");
		updateBtn.setToolTipText("Go to update page.");
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMenu.setVisible(false);
				UpdateForm updateForm = new UpdateForm();
				updateForm.run();
			}
		});
		updateBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		updateBtn.setBounds(283, 176, 123, 52);
		frmMenu.getContentPane().add(updateBtn);
	
	}
}

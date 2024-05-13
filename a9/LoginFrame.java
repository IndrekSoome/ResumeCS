package a9;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

import javax.swing.*;

/**
 * This class represents a login frame for the App.
 * The class extends JDialog to create a dialog window for user login.
 */
class LoginFrame extends JDialog {
    private static LoginFrame v;
  //  JFrame parent;
    /**
     * Method that creates a new instance of LoginFrame 
     * @param parent The parent JFrame.
     */
    public static LoginFrame V(JFrame parent) {
    	if (v == null)
    		v = new LoginFrame(parent);
    	return v;
    }
    private final JLabel lblUsername = new JLabel("Username");
    private final JLabel lblPassword = new JLabel("Password");

    private final JTextField txtUsername = new JTextField(15);
    private final JPasswordField txtPassword = new JPasswordField();

    private final JButton btnLogin = new JButton("Login");
    private final JButton btnCancel = new JButton("Cancel");
    
    public LoginFrame() {
        this(null);
    }

    LoginFrame(final JFrame parent) {
        super(parent, "Log in window");
        // Organizing components and adding labels and text fields to panel
        JPanel pnlLabels = new JPanel(new GridLayout(2,1,20,20));
        pnlLabels.add(lblUsername);
        pnlLabels.add(lblPassword);
        
        JPanel pnlTextfields = new JPanel(new GridLayout(2,1,20,20));
        pnlTextfields.add(txtUsername);
        pnlTextfields.add(txtPassword);
       
        JPanel pnlOrganizer = new JPanel();
        // Add panels to main organizer panel
        pnlOrganizer.add(pnlLabels);
        pnlOrganizer.add(pnlTextfields);
        
        JPanel pnlButtons = new JPanel();
        // Add buttons to button panel
        pnlButtons.add(btnLogin);
        pnlButtons.add(btnCancel);
        
        // Setting layout and add components to frame
        setLayout(new BorderLayout());
        add(pnlOrganizer, BorderLayout.CENTER);
        add(pnlButtons, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
		
        // Action listeners for login/cancel buttons
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//note how we get the password text from JTextPassword
            	String password = String.valueOf(txtPassword.getPassword());
            	String username = txtUsername.getText().trim();
            	
            	// Verifying login credentials
                if (verifyLogin(username, password)) {
                    parent.setVisible(true);
                    ((MainWindow) parent).enableAll(); 
                    setVisible(false);
                } else {
                	JOptionPane.showMessageDialog(null, "Incorrect username/password", "Login", JOptionPane.ERROR_MESSAGE );

                }
            }
            /**
             * Method that verifies the login credentials.
             * @param username, entered username.
             * @param password, entered password.
             * @return True if the credentials are correct, otherwise false.
             */
			private boolean verifyLogin(String username, String password) {
				if (username.equalsIgnoreCase("healthy") && password.equalsIgnoreCase("donuts"))
					return true;
				return false;
			} 
        
			
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	txtPassword.setText("");
            	txtUsername.setText("");
                setVisible(false);
            
            }
        });
    }
}

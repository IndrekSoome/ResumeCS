package a9;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

/**
 * Main application, class that works as user interface Exercise Tracker.
 * This class manages all components, handles user interactions, and manages all login related information.
 */
public class App extends JFrame {
    private ArrayList<Exercise> exercises = new ArrayList<>();
    private JTextArea exerciseTextArea;
    private JTextField nameField, dateField, durationField, distanceField;
    private JTextArea commentArea;
    private JComboBox<String> typeComboBox;

    private boolean loggedIn = false;

    /**
     * This constructs the main application frame, setting up components and initializing event handlers.
     */
    public App() {
        setTitle("Exercise Tracker");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Setup the input panel with labels and text fields
        JPanel inputPanel = new JPanel(new GridLayout(0, 2));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);

        JLabel dateLabel = new JLabel("Date (MM/dd/yyyy):");
        dateField = new JTextField();
        inputPanel.add(dateLabel);
        inputPanel.add(dateField);

        JLabel durationLabel = new JLabel("Duration:");
        durationField = new JTextField();
        inputPanel.add(durationLabel);
        inputPanel.add(durationField);

        JLabel distanceLabel = new JLabel("Distance:");
        distanceField = new JTextField();
        inputPanel.add(distanceLabel);
        inputPanel.add(distanceField);

        JLabel typeLabel = new JLabel("Type:");
        String[] exerciseTypes = {"Run Walk", "WeightLifting", "RockClimbing"};
        typeComboBox = new JComboBox<>(exerciseTypes);
        inputPanel.add(typeLabel);
        inputPanel.add(typeComboBox);

        JLabel commentLabel = new JLabel("Comment:");
        commentArea = new JTextArea();
        inputPanel.add(commentLabel);
        inputPanel.add(commentArea);

        JButton addButton = new JButton("Add Exercise");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addExercise();
            }
        });
        inputPanel.add(addButton);
        
        add(inputPanel, BorderLayout.NORTH);

        exerciseTextArea = new JTextArea();
        add(new JScrollPane(exerciseTextArea), BorderLayout.CENTER);
        // Setup the save button with its action listene
        JButton saveButton = new JButton("Save Exercises");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveExercises();
            }
        });
        add(saveButton, BorderLayout.SOUTH);
        // Disablesisables components until user logs in
        disableAll();
        showLoginDialog();
    }
    /**
     * Enables all input fields and buttons in the UI.
     */

    void enableAll() {
    	
    }
    /**
     * Disables all input fields and buttons in the UI.
     */

    void disableAll() {
    	
    }

    
   
    /**
     * Displays the login to authenticate user.
     */
    private void showLoginDialog() {
        LoginFrame loginFrame = new LoginFrame(this);
        loginFrame.setVisible(true);
    }
    /**
     * Adds an exercise to the list and updates the UI.
     */
    private void addExercise() {
    	
    }
        
    /**
     * Updates the text area with the list of exercises.
     */
    private void updateExerciseTextArea() {
        exerciseTextArea.setText("");
        for (Exercise exercise : exercises) {
            exerciseTextArea.append(exercise.toString() + "\n");
        }
    }
    /**
     * Saves exercises.
     */

    private void saveExercises() {
    }
	
    /**
     * Logs out the current user and disables components.
     */
    private void logout() {
        loggedIn = false;
        disableAll();
        showLoginDialog();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow window = new MainWindow();
                window.setVisible(true);
            }
        });
    }
}




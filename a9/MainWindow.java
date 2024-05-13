package a9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * The MainWindow class extends JFrame and functions as the main application window for the exercise tracking application.
 * It class handles user interactions for adding exercises, managing exercise data, and providing save and login functionality.
 */
public class MainWindow extends JFrame {
    private LoginFrame passDialog = LoginFrame.V(this);
    private JComboBox<String> cboType;
    
    private JMenuItem menuLogin, menuSave, menuLogout;
    
    private JTextField txtName, txtDate, txtDuration, txtDistance;
    private JTextArea areaComments, areaSummary;
    private JPanel pnlLeft, pnlRight;
    private JLabel lblSummary;
    private JButton btnAdd;
    private ArrayList<Exercise> exercises = new ArrayList<>();

    /**
     * Constructs the main window and initializes the user interface components,
     * layout configuration, and event listeners.
     */
    public MainWindow() {
        super("Exercise Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setupMenu();
        initializePanels();
        layoutComponents();
        disableAll();
        setLocationRelativeTo(null);
    }
    /**
     * Initializes panels for displaying exercise data and input fields.
     */
    private void initializePanels() {
        RightPanelReady();
        LeftPanelReady();
    }
    /**
     * CSets the layout and adds the panels to the frame.
     */
    private void layoutComponents() {
        btnAdd = new JButton("Add Exercise");
        btnAdd.addActionListener(e -> addExercise());
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(btnAdd);

        this.setLayout(new BorderLayout());
        this.add(pnlLeft, BorderLayout.CENTER);
        this.add(pnlRight, BorderLayout.EAST);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }
    /**
     * Disables all user input components.
     */
    void disableAll() {
        txtDate.setEditable(false);
        txtDuration.setEditable(false);
        txtDistance.setEditable(false);
        txtName.setEditable(false);
        cboType.setEnabled(false);
        btnAdd.setEnabled(false);
        menuLogout.setEnabled(false);
        menuSave.setEnabled(false);
        areaComments.setEditable(false);
    }
    /**
     * Enables all user input components.
     */
    void enableAll() {
        txtDate.setEditable(true);
        txtDuration.setEditable(true);
        txtDistance.setEditable(true);
        txtName.setEditable(true);
        cboType.setEnabled(true);
        btnAdd.setEnabled(true);
        menuLogout.setEnabled(true);
        menuSave.setEnabled(true);
        areaComments.setEditable(true);
    }
    /**
     * Sets up the right panel
     */
    private void RightPanelReady() {
        lblSummary = new JLabel("Exercise Summary");
        pnlRight = new JPanel(new BorderLayout());
        pnlRight.add(lblSummary, BorderLayout.NORTH);
        areaSummary = new JTextArea(10, 30);
        areaSummary.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaSummary);
        pnlRight.add(scrollPane, BorderLayout.CENTER);
    }
    /**
     * Sets up the left panel
     */
    private void LeftPanelReady() {
        pnlLeft = new JPanel(new BorderLayout());
        JPanel pnlInputs = new JPanel(new GridLayout(5, 2, 5, 5));

        txtName = new JTextField(20);
        txtDate = new JTextField(20);
        txtDuration = new JTextField(20);
        txtDistance = new JTextField(20);
        String[] types = {"Weight Lifting", "Run/Walk", "Rock Climbing"};
        cboType = new JComboBox<>(types);

        pnlInputs.add(new JLabel("Type:"));
        pnlInputs.add(cboType);
        pnlInputs.add(new JLabel("Name:"));
        pnlInputs.add(txtName);
        pnlInputs.add(new JLabel("Date (MM/dd/yyyy):"));
        pnlInputs.add(txtDate);
        pnlInputs.add(new JLabel("Duration:"));
        pnlInputs.add(txtDuration);
        pnlInputs.add(new JLabel("Distance:"));
        pnlInputs.add(txtDistance);

        pnlLeft.add(pnlInputs, BorderLayout.NORTH);

        JPanel pnlComments = new JPanel(new BorderLayout());
        pnlComments.add(new JLabel("Comments:"), BorderLayout.NORTH);
        areaComments = new JTextArea(4, 20);
        pnlComments.add(new JScrollPane(areaComments), BorderLayout.CENTER);

        pnlLeft.add(pnlComments, BorderLayout.CENTER);
    }
    /**
     * Adds an exercise to the list based on user input
     * Updates the exercise summary display.
     */
    private void addExercise() {
    	String type = (String) cboType.getSelectedItem();
        String name = txtName.getText().trim();
        String dateString = txtDate.getText().trim();
        String durationString = txtDuration.getText().trim();
        String distanceString = txtDistance.getText().trim();
        String comments = areaComments.getText().trim();

        if (name.isEmpty() || dateString.isEmpty() || durationString.isEmpty() || distanceString.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            Date date = df.parse(dateString);
            double duration = Double.parseDouble(durationString);
            double distance = Double.parseDouble(distanceString);

            Exercise exercise = null;
            switch (type) {
                case "Run/Walk":
                    exercise = new RunWalk(name, date, duration, distance, comments);
                    break;
                case "Rock Climbing":
                    int repetitions = Integer.parseInt(distanceString); // Here we assume that distance field is used for repetitions
                    exercise = new RockClimbing(name, date, duration, distance, repetitions, comments);
                    break;
                case "Weight Lifting":
                    double weight = Double.parseDouble(distanceString); // Here we assume that distance field is used for weight
                    exercise = new WeightLifting(name, df.format(date), duration, comments);
                    ((WeightLifting) exercise).setWeight(weight);
                    break;
            }

            if (exercise != null) {
                exercises.add(exercise);
                areaSummary.append(exercise.toSummaryString() + "\n");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "The duration must be a non-zero number. The date must be entered in mm/dd/yyyy format. ");
        }
    }
    /**
     * Initializes and displays the menu bar and all related items.
     */
    private void setupMenu() {
    	// Descriptive comments about the menu setup
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        // Login
        menuLogin = new JMenuItem("Login");
        menuLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Login logic or show login dialog
                passDialog.setVisible(true);
            }
        });

        // Logout
        menuLogout = new JMenuItem("Logout");
        menuLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	// Disable all input fields and controls
                disableAll();
            }
        });

        // Save
        menuSave = new JMenuItem("Save");
        menuSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	// Save all exercises to a file
                saveExercises();
            }
        });

        // Populate File Menu
        fileMenu.add(menuLogin);
        fileMenu.add(menuLogout);
        fileMenu.add(menuSave);
        fileMenu.addSeparator();
        fileMenu.add(new JMenuItem("Exit")).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit program
            }
        });

        // Add menus to menu bar
        menuBar.add(fileMenu);
        JMenu helpMenu = new JMenu("Help");
        helpMenu.add(new JMenuItem("About")).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAboutDialog();
            }
        });
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);
    }
    /**
     * Saves the current list of exercises to a file in a chosen location on computer.
     */
    public void saveExercises() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File f = fileChooser.getSelectedFile();
            try (PrintWriter out = new PrintWriter(f)) {
                for (Exercise ex : exercises) {
                    out.println(ex);
                }
                JOptionPane.showMessageDialog(this, "Exercises saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(this, "Failed to save file.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    
        
        
    }
    /**
     * Displays dialog providing information about the application.
     */
    private void showAboutDialog() {
        JOptionPane.showMessageDialog(this, "Exercise Tracker, Spring 2024", "About Exercise Tracker", JOptionPane.INFORMATION_MESSAGE);
    }
  }

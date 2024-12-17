import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.sql.*;

public class LogInGUI extends JFrame {
    static String uname = "root";
    static String password = "naolfekadu123";
    static String url = "jdbc:mysql://localhost:3306/hotelmanagement";
    public LogInGUI() {
        // Set up the JFrame
        setTitle("Login Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create a JPanel with BorderLayout
        JPanel panel = new JPanel(new BorderLayout());

        // Create labels and text fields for user input
        JLabel firstNameLabel = new JLabel("First Name:");
        JTextField firstNameField = new JTextField(20);

        JLabel lastNameLabel = new JLabel("Last Name:");
        JTextField lastNameField = new JTextField(20);

        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField(3);

        JLabel genderLabel = new JLabel("Gender:");
        JRadioButton maleRadioButton = new JRadioButton("Male");
        JRadioButton femaleRadioButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);

        // Create a JPanel to hold the labels and text fields with an EmptyBorder
        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 5, 5)); // 6 rows, 2 columns
        inputPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Add empty border for spacing

        // Add components to the inputPanel
        inputPanel.add(firstNameLabel);
        inputPanel.add(firstNameField);
        inputPanel.add(lastNameLabel);
        inputPanel.add(lastNameField);
        inputPanel.add(ageLabel);
        inputPanel.add(ageField);
        inputPanel.add(genderLabel);
        inputPanel.add(maleRadioButton);
        inputPanel.add(new JLabel()); // Empty label for spacing
        inputPanel.add(femaleRadioButton);
        inputPanel.add(usernameLabel);
        inputPanel.add(usernameField);
        inputPanel.add(passwordLabel);
        inputPanel.add(passwordField);

        // Create a button for login
        JButton loginButton = new JButton("Login");

        // Add components to the panel using BorderLayout
        panel.add(inputPanel, BorderLayout.CENTER);
        panel.add(loginButton, BorderLayout.SOUTH);

        // Add the panel to the JFrame
        add(panel);

        // Make the JFrame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LogInGUI();
        });
    }
}

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;


class RegisterUserPage extends  JPanel{
    private int top = 80;
    static String uname = "root";
    static String dbPassword = "naolfekadu123";
    static String url = "jdbc:mysql://localhost:3306/hotelmanagement";

    RegisterUserPage(CardLayout cardLayout, JPanel container) {
        setLayout(null);

        JLabel createAccountTitle = new JLabel("Register User");
        createAccountTitle.setBounds(400, 30, 400, 100);
        createAccountTitle.setFont(new Font(createAccountTitle.getFont().getName(), Font.BOLD, 48));

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(440, top, 200, 100);
        JTextField firstNameInput = new JTextField();
        firstNameInput.setBounds(440, top+60, 220, 25);

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(440, top+61, 200, 100);
        JTextField lastNameInput = new JTextField();
        lastNameInput.setBounds(440, top+120, 220, 25);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(440, top+110, 200, 100);
        JTextField ageInput = new JTextField();
        ageInput.setBounds(440, top+170, 220, 25);

        JLabel addressLabel = new JLabel("Adress:");
        addressLabel.setBounds(440, top+160, 200,100);
        JTextField addressInput = new JTextField();
        addressInput.setBounds(440, top+220, 220, 25);

        JLabel contactLabel = new JLabel("Contact:");
        contactLabel.setBounds(440, top+210, 200, 100);
        JTextField contactInput = new JTextField();
        contactInput.setBounds(440, top+270,220, 25);

        JLabel emergencyContact = new JLabel("Emergency Contact");
        emergencyContact.setBounds(440, top+260, 200, 100);
        JTextField emergencyContactInput = new JTextField();
        emergencyContactInput.setBounds(440, top+320, 220, 25);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(440, top+310, 200, 100);
        JTextField usernameInput = new JTextField();
        usernameInput.setBounds(440, top+370, 220, 25);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(440, top+360, 200, 100);
        JTextField passwordInput = new JPasswordField();
        passwordInput.setBounds(440, top+420, 220, 25);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(440, top+440, 200, 50);
        // Create a ButtonGroup to group the radio buttons
        ButtonGroup genderGroup = new ButtonGroup();
        // Create radio buttons for Male and Female
        JRadioButton maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setBounds(440, top + 470, 100, 30);
        JRadioButton femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setBounds(550, top + 470, 100, 30);
        // Add radio buttons to the ButtonGroup
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);


        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(440, top+505, 220, 30);
        createAccountButton.addActionListener(new ActionListener() {
           // @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("🎊 registering user");
                try{
                    Connection con = DriverManager.getConnection(url, uname, dbPassword);
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Customer(FirstName, LastName, Gender, Contact, Address, EmergencyContact, username, password, Age) values (?, ?, ?,?,?, ?,?, ?,?)");
                    pst.setString(1,firstNameInput.getText());
                    pst.setString(2,lastNameInput.getText());
                    pst.setInt(9,Integer.parseInt(ageInput.getText()));
                    pst.setString(5,addressInput.getText());
                    pst.setString(4,contactInput.getText());
                    pst.setString(6, emergencyContactInput.getText());
                    pst.setString(7,usernameInput.getText());
                    pst.setString(8,passwordInput.getText());

                    String selectedGender=" ";
                    if (maleRadioButton.isSelected())
                        selectedGender = "Male";
                    else if (femaleRadioButton.isSelected())
                        selectedGender = "Female";

                    pst.setString(3, selectedGender);


                    int k = pst.executeUpdate();
                    if(k==1){
                        System.out.println("User added");
                    }
                }catch(SQLException error){
                    error.printStackTrace();
                }
            }
        });
        JButton backButton3 = new JButton("Back");
        backButton3.setBounds(680, top+505, 60, 30);

        backButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(container, "employeeDashboard");
            }
        });

        /*  JButton logInButton = new JButton("Log In");
        logInButton.setBounds(440, top+495, 220, 30);
        logInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(container, "logInPage");
            }
        }); */

        add(createAccountTitle);
        add(firstNameLabel);
        add(firstNameInput);
        add(lastNameLabel);
        add(lastNameInput);
        add(ageLabel);
        add(ageInput);
        add(addressLabel);
        add(addressInput);
        add(contactLabel);
        add(contactInput);
        add(emergencyContact);
        add(emergencyContactInput);
        add(usernameLabel);
        add(usernameInput);
        add(passwordLabel);
        add(passwordInput);
        add(genderLabel);
        add(maleRadioButton);
        add(femaleRadioButton);
        //add(logInButton);
        add(createAccountButton);
        add(backButton3);
    }
}






class CreateAccountPage extends JPanel {
    private int top = 150;

    CreateAccountPage(CardLayout cardLayout, JPanel container) {
        setLayout(null);

        JLabel createAccountTitle = new JLabel("Create Account");
        createAccountTitle.setBounds(400, 100, 400, 100);
        createAccountTitle.setFont(new Font(createAccountTitle.getFont().getName(), Font.PLAIN, 48));

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(440, top, 200, 100);
        JTextField firstNameInput = new JTextField();
        firstNameInput.setBounds(440, top+60, 220, 25);

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(440, top+61, 200, 100);
        JTextField lastNameInput = new JTextField();
        lastNameInput.setBounds(440, top+120, 220, 25);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(440, top+110, 200, 100);
        JTextField ageInput = new JTextField();
        ageInput.setBounds(440, top+170, 220, 25);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(440, top+160, 200, 100);
        JTextField usernameInput = new JTextField();
        usernameInput.setBounds(440, top+220, 220, 25);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(440, top+210, 200, 100);
        JTextField passwordInput = new JPasswordField();
        passwordInput.setBounds(440, top+270, 220, 25);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(440, top+260, 200, 100);
        // Create a ButtonGroup to group the radio buttons
        ButtonGroup genderGroup = new ButtonGroup();
        // Create radio buttons for Male and Female
        JRadioButton maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setBounds(440, top + 315, 100, 30);
        JRadioButton femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setBounds(550, top + 315, 100, 30);
        // Add radio buttons to the ButtonGroup
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);


//        JLabel usernameLabelCA = new JLabel("Username:");
//        usernameLabelCA.setBounds(440, 150, 200, 100);
//        JTextField usernameInputCA = new JTextField();
//        usernameInputCA.setBounds(440, 215, 220, 25);

//        JLabel passwordLabelCA = new JLabel("Password:");
//        passwordLabelCA.setBounds(440, 220, 200, 100);
//        JPasswordField passwordInputCA = new JPasswordField();
//        passwordInputCA.setBounds(440, 280, 220, 25);

        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(440, top+355, 220, 30);
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("🎊 creating employee account");
//                    String username = firstNameInput.getText();
//                    char[] passwordChars = passwordInputCA.getPassword(); // Get the password as a character array
//                    String password = new String(passwordChars); // Convert the character array to a string
//                    System.out.println(username);
//                    System.out.println("Password: " + password);
                    /*

                    String query = "SELECT * FROM staff WHERE empID = "+empId;
                    try{
                        Connection con = DriverManager.getConnection(url, uname, password);
                        Statement statement = con.createStatement();
                        ResultSet result = statement.executeQuery(query);



                        DefaultTableModel tableModel = new DefaultTableModel();
                        tableModel.addColumn("ID");
                        tableModel.addColumn("First Name");
                        tableModel.addColumn("Last Name");
                        tableModel.addColumn("Gender");
                        tableModel.addColumn("Skills");
                        tableModel.addColumn("Field");
                        tableModel.addColumn("University");
                        tableModel.addColumn("Address");
                        tableModel.addColumn("Rating");
                        table1.setModel(tableModel);


                        while(result.next()){
                            String UniversityData = "";
                            String[] rowData = new String[9];
                            for(int i = 1; i <= 9; i++){
                                UniversityData += result.getString(i)+":";
                                rowData[i-1] = result.getString(i);
                            }
                            tableModel.addRow(rowData);
                            System.out.println(UniversityData);
                        }

                    }catch(SQLException searchError){
                        searchError.printStackTrace();
                    }
                */


            }
        });

        JButton logInButton = new JButton("Log In");
        logInButton.setBounds(440, top+390, 220, 30);
        logInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(container, "logInPage");
            }
        });

        add(createAccountTitle);
        add(firstNameLabel);
        add(firstNameInput);
        add(lastNameLabel);
        add(lastNameInput);
        add(ageLabel);
        add(ageInput);
        add(usernameLabel);
        add(usernameInput);
        add(passwordLabel);
        add(passwordInput);
        add(genderLabel);
        add(maleRadioButton);
        add(femaleRadioButton);


//        add(usernameLabelCA);
//        add(usernameInputCA);
       // add(passwordLabelCA);
        //add(passwordInputCA);
        add(logInButton);
        add(createAccountButton);
    }
}


class LogInPage extends JPanel {

    static String uname = "root";
    static String dbPassword = "naolfekadu123";
    static String url = "jdbc:mysql://localhost:3306/hotelmanagement";
    PreparedStatement pst;
    private int top = 150;
    boolean userFound = false;
    LogInPage(CardLayout cardLayout, JPanel container) {
        setLayout(null);

//        JButton nextPageButton = new JButton("Next Page");
//        nextPageButton.setBounds(500, 400, 100, 30);

        JLabel logInTitle = new JLabel("Log In");
        logInTitle.setBounds(480, 100, 200, 100);
        logInTitle.setFont(new Font(logInTitle.getFont().getName(), Font.BOLD, 48));

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(440, 150, 200, 100);
        JTextField usernameInput = new JTextField();
        usernameInput.setBounds(440, 215, 220, 25);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(440, 220, 200, 100);
        JPasswordField passwordInput = new JPasswordField();
        passwordInput.setBounds(440, 280, 220, 25);

        JLabel userChoice = new JLabel("You are: ");
        userChoice.setBounds(440, 300, 200, 50);

        JRadioButton customerButton = new JRadioButton("A Customer");
        customerButton.setBounds(440, 330, 100, 30);
        JRadioButton employeeButton = new JRadioButton("An Employee");
        employeeButton.setBounds(440, 350, 100, 30);

        //adding them to a button group
        ButtonGroup userGroup = new ButtonGroup();
        userGroup.add(customerButton);
        userGroup.add(employeeButton);

        JLabel alert = new JLabel();
        alert.setForeground(Color.PINK); // Set the foreground color to red
        alert.setBounds(440, 320, 200, 100);

        JButton logInButton = new JButton("Log In");
        logInButton.setBounds(440, 390, 220, 30);
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(customerButton.isSelected())
                    cardLayout.show(container, "customerDashboard");
                else if(employeeButton.isSelected())
                    cardLayout.show(container, "employeeDashboard");
                /* ⛔⛔⛔
                userFound = false;
                String username = usernameInput.getText();
                char[] passwordArr = passwordInput.getPassword();
                String userPassword = new String(passwordArr);

                String query = "SELECT * FROM employee WHERE username = '" + username + "'";
                try{
                    Connection con = DriverManager.getConnection(url, uname, dbPassword);
                    Statement statement = con.createStatement();
                    ResultSet result = statement.executeQuery(query);

                    while(result.next()){
                        for(int i = 1; i <= 7; i++){
                            System.out.println(result.getString(i));
                        }
                        if(userPassword.equals(result.getString(7))) {
                            cardLayout.show(container, "dashboard");
                        }
                        else {
                            System.out.println("Wrong password!");
                            alert.setText("Wrong password!");

                        }
                        userFound = true;
                    }
                }catch(SQLException searchError){
                    searchError.printStackTrace();
                }
                if (!userFound) {
                    System.out.println("User not found!");
                    alert.setText("User not found!");
                }
                */
            }
        });
        /*
        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(440, 355, 220, 30);

        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(container, "createAccountPage");
            }
        });
        */


//        nextPageButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                cardLayout.show(container, "dashboard");
//            }
//        });

        //add(nextPageButton);
        add(logInTitle);
        add(usernameLabel);
        add(usernameInput);
        add(passwordLabel);
        add(passwordInput);
        add(userChoice);
        add(customerButton);
        add(employeeButton);
        add(logInButton);
        add(alert);
        //add(createAccountButton);
    }
}




class DeleteUserPage extends JPanel{
    private int top = 50;

    static String uname = "root";
    static String dbPassword = "naolfekadu123";
    static String url = "jdbc:mysql://localhost:3306/hotelmanagement";
    String usersQuery = "SELECT * FROM Customer";
    private JTable usersTable;
    private String[][] usersData; // Removed {{}}
    String[] columnNames = {"Customer ID", "First Name", "Last Name", "Gender", "Age", "Contact", "Address", "Emer. Contact", "Username"};

    java.util.List<String[]> rows;

    JScrollPane scrollPane;
    public DeleteUserPage(CardLayout cardLayout, JPanel container){
        setLayout(null);
        JLabel headerLabel = new JLabel("Account Manager");
        headerLabel.setBounds(180, top+50, 400, 50);
        headerLabel.setFont(new Font(headerLabel.getFont().getName(), Font.BOLD, 36));
        add(headerLabel);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException error) {
            error.printStackTrace();
        }

        try {
            Connection con = DriverManager.getConnection(url, uname, dbPassword);
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(usersQuery);

            ResultSetMetaData rsmd = result.getMetaData();

            // Determine the number of columns dynamically
            int columnCount = rsmd.getColumnCount();

            // Create an ArrayList to store the rows of data
            rows = new java.util.ArrayList<>();

            while (result.next()) {
                String[] rowData = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                        rowData[i - 1] = result.getString(i);
                }
                rows.add(rowData);
            }

            // Convert the ArrayList to a 2D array
            usersData = new String[rows.size()][];
            for (int i = 0; i < rows.size(); i++) {
                usersData[i] = rows.get(i);
            }
        } catch (SQLException fetchError) {
            fetchError.printStackTrace();
        }

        // Create a DefaultTableModel to hold the data and column names
        DefaultTableModel model = new DefaultTableModel(usersData, columnNames);

        // Create a JTable with the DefaultTableModel
        usersTable = new JTable(model);
        usersTable.setEnabled(false);

        // Create a custom cell renderer to make the first name column bold
        // Apply the custom renderer to the first name column
        usersTable.getColumnModel().getColumn(0);

        // Create a JScrollPane to add the JTable to (for scrolling)
        scrollPane = new JScrollPane(usersTable);
        scrollPane.setBounds(180, top + 150, 750, 320);
        add(scrollPane);


        JLabel deleteIdLabel = new JLabel("User ID: ");
        deleteIdLabel.setFont(new Font(this.getFont().getName(),Font.PLAIN,16));
        deleteIdLabel.setBounds(180, top+50+450, 90, 25);
        add(deleteIdLabel);
        JTextField deleteIdInput = new JTextField();
        deleteIdInput.setBounds(250,top+50+450, 60,25);
        add(deleteIdInput);
        JButton deleteBtn = new JButton("Delete User");
        deleteBtn.setBounds(340,top+50+450, 100,25);

        JButton backButton5 = new JButton("Back");
        backButton5.setBounds(870, top+50+450, 60,30);

        backButton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(container, "employeeDashboard");
            }
        });
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int customerID = Integer.parseInt(deleteIdInput.getText());
                try{
                    Connection con = DriverManager.getConnection(url, uname, dbPassword);
                    PreparedStatement pst = con.prepareStatement("DELETE FROM Customer WHERE CustomerID = ?;");
                    pst.setInt(1,customerID);

                    int k = pst.executeUpdate();
                    if(k==1){
                        System.out.println("User removed");
                    }
                }catch(SQLException error){
                    error.printStackTrace();
                }

                try {
                    Connection con = DriverManager.getConnection(url, uname, dbPassword);
                    Statement statement = con.createStatement();
                    ResultSet result = statement.executeQuery(usersQuery);

                    ResultSetMetaData rsmd = result.getMetaData();

                    // Determine the number of columns dynamically
                    int columnCount = rsmd.getColumnCount();

                    // Create an ArrayList to store the rows of data
                    rows = new java.util.ArrayList<>();

                    while (result.next()) {
                        String[] rowData = new String[columnCount];
                        for (int i = 1; i <= columnCount; i++) {
                            rowData[i - 1] = result.getString(i);
                        }
                        rows.add(rowData);
                    }

                    // Convert the ArrayList to a 2D array
                    usersData = new String[rows.size()][];
                    for (int i = 0; i < rows.size(); i++) {
                        usersData[i] = rows.get(i);
                    }
                } catch (SQLException fetchError) {
                    fetchError.printStackTrace();
                }

                // Create a DefaultTableModel to hold the data and column names
                DefaultTableModel model = new DefaultTableModel(usersData, columnNames);

                // Create a JTable with the DefaultTableModel
                usersTable = new JTable(model);
                usersTable.setEnabled(false);

                // Create a custom cell renderer to make the first name column bold
                // Apply the custom renderer to the first name column
                usersTable.getColumnModel().getColumn(0);

                // Create a JScrollPane to add the JTable to (for scrolling)
                scrollPane = new JScrollPane(usersTable);
                scrollPane.setBounds(180, top + 150, 750, 320);
                add(scrollPane);


            }
        });

        add(deleteBtn);
        add(backButton5);



    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class EmployeeDashboardPage extends JPanel {
    private int top = 150;
    public boolean setRegisterButton = true;

    EmployeeDashboardPage(CardLayout cardLayout, JPanel container) {
        setLayout(null);
//        JButton prevPageButton = new JButton("Previous Page");
//        prevPageButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                cardLayout.show(container, "logInPage");
//            }
//        });
//        add(prevPageButton);
        JLabel welcomeLabel = new JLabel("Welcome");
        welcomeLabel.setBounds(440, top, 300, 50);
        welcomeLabel.setFont(new Font(welcomeLabel.getFont().getName(), Font.BOLD, 48));
        JLabel menuLabel = new JLabel("Choose your action: ");
        menuLabel.setBounds(440, top+50, 300, 50);

        JButton registerUserBtn = new JButton("Register User");
        registerUserBtn.setBounds(440, top+100, 220, 30);
        registerUserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(container, "registerPage");
            }
        });
        JButton roomsBtn = new JButton("Rooms");
        roomsBtn.setBounds(440, top+150, 220, 30);
        roomsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(container, "roomsPage");
            }
        });
        JButton servicesBtn = new JButton("Services");
        servicesBtn.setBounds(440, top+200, 220, 30);

        JButton deleteBtn = new JButton("Delete User");
        deleteBtn.setBounds(440, top+250, 220, 30);
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(container, "deleteUserPage");
            }
        });

        JButton backButton1 = new JButton("Back");
        backButton1.setBounds(700, top+ 300, 60, 30);
        backButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(container, "logInPage");
            }
        });



        add(welcomeLabel);
        add(menuLabel);
        add(registerUserBtn);
        add(roomsBtn);
        add(servicesBtn);
        add(deleteBtn);
        add(backButton1);
    }
}









class CustomerDashboardPage extends JPanel {
    private int top = 150;
    public boolean setRegisterButton = true;

    CustomerDashboardPage(CardLayout cardLayout, JPanel container) {
        setLayout(null);
//        JButton prevPageButton = new JButton("Previous Page");
//        prevPageButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                cardLayout.show(container, "logInPage");
//            }
//        });
//        add(prevPageButton);
        JLabel welcomeLabel = new JLabel("Welcome");
        welcomeLabel.setBounds(440, top, 300, 50);
        welcomeLabel.setFont(new Font(welcomeLabel.getFont().getName(), Font.BOLD, 48));
        JLabel menuLabel = new JLabel("Choose your action: ");
        menuLabel.setBounds(440, top+50, 300, 50);

        JButton roomsBtn = new JButton("Rooms");
        roomsBtn.setBounds(440, top+100, 220, 30);
        roomsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(container, "userRoomsPage");
            }
        });
        JButton servicesBtn = new JButton("Services");
        servicesBtn.setBounds(440, top+150, 220, 30);

        JButton backButton4 = new JButton("Back");
        backButton4.setBounds(670, top+190, 60, 30 );

        backButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(container, "logInPage");
            }
        });


        add(welcomeLabel);
        add(menuLabel);
        add(roomsBtn);
        add(servicesBtn);
        add(backButton4);
    }
}


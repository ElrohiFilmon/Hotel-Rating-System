import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Main {
    public static void main(String[] args) {
        com.formdev.flatlaf.themes.FlatMacLightLaf.install();
        //com.formdev.flatlaf.themes.FlatMacDarkLaf.install();
        SwingUtilities.invokeLater(() -> {
            landingPage();
        });
    }

    private static void landingPage() {
        JFrame frame = new JFrame("Hotel Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100, 700);
        frame.setResizable(false);

        JPanel container = new JPanel(new CardLayout());

        //CreateAccountPage createAccountPage = new CreateAccountPage((CardLayout) container.getLayout(), container);
        LogInPage logInPage = new LogInPage((CardLayout) container.getLayout(), container);
        EmployeeDashboardPage employeeDashboardPage = new EmployeeDashboardPage((CardLayout) container.getLayout(), container);
        CustomerDashboardPage customerDashboardPage = new CustomerDashboardPage((CardLayout) container.getLayout(), container);
        RegisterUserPage registerUserPage = new RegisterUserPage((CardLayout) container.getLayout(), container);
        RoomsPage roomsPage = new RoomsPage((CardLayout) container.getLayout(), container);
        DeleteUserPage deleteUserPage = new DeleteUserPage((CardLayout) container.getLayout(), container);
        UserRooms userRoomsPage = new UserRooms((CardLayout) container.getLayout(), container);

        container.add(logInPage, "logInPage");
        container.add(customerDashboardPage, "customerDashboard");
        container.add(employeeDashboardPage, "employeeDashboard");
        container.add(registerUserPage, "registerPage");
        container.add(roomsPage, "roomsPage");
        container.add(deleteUserPage, "deleteUserPage");
        container.add(userRoomsPage, "userRoomsPage");
        //container.add(createAccountPage, "createAccountPage");

        frame.add(container);
        frame.setVisible(true);
    }
}

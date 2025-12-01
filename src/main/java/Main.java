import java.sql.*;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    private static Object query;

    public static void main(String[] args) {

        String homeMenu = "" +
                "\n 1) Display all products \n" +
                " 2) Display all customers \n" +
                " 0) Exit \n" +
                " Select and option\n ";
        System.out.println(homeMenu);
        int choice = scanner.nextInt();


        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root", "Apples06")) {
            if (choice == 1) {

                Statement statement = connection.createStatement();
                String query = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM Products ";
                ResultSet results = statement.executeQuery(query);

                while (results.next()) {
                    String ProductID = results.getString("ProductID");
                    String ProductName = results.getString("ProductName");
                    String UnitPrice = results.getString("UnitPrice");
                    String UnitsInStock = results.getString("UnitsInStock");
                    System.out.println("ProductID: " + ProductID);
                    System.out.println("ProductName: " + ProductName);
                    System.out.println("Unit Price: " + UnitPrice);
                    System.out.println("Units In Stock: " + UnitsInStock);

                }
            } else if (choice == 2) {
                Statement statement = connection.createStatement();
                String query = "SELECT ContactName, CompanyName, City, Country, Phone FROM Customers ORDER BY Country";
                ResultSet results = statement.executeQuery(query);

                while (results.next()) {
                    String CompanyName = results.getString("CompanyName");
                    String ContactName = results.getString("ContactName");
                    String City = results.getString("City");
                    String Country = results.getString("Country");
                    String Phone = results.getString("Phone");
                    System.out.println("Contact name: " + ContactName);
                    System.out.println("Company Name: " + CompanyName);
                    System.out.println("City: " + City);
                    System.out.println("Country: " + Country);
                    System.out.println("Phone number: " + Phone);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

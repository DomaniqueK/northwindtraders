import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    private static Object query;

    public static void main(String[] args) throws RuntimeException {

        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
        dataSource.setUsername("root");
        dataSource.setPassword("Apples06");

        String homeMenu = "" +
                "\n 1) Display all products \n" +
                " 2) Display all customers \n" +
                " 3) Display all categories \n " +
                " 0) Exit \n" +
                " Select and option\n ";
        System.out.println(homeMenu);
        int choice = scanner.nextInt();


        try (Connection connection = dataSource.getConnection()){// Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root", "Apples06")) {


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
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = dataSource.getConnection()) {

            if (choice == 2) {

                PreparedStatement preparedStatement = connection.prepareStatement("SELECT First_name, Last_name FROM Customer " + "WHERE Last_name LIKE ? ORDER BY First_name") ;
                String query = "SELECT ContactName, CompanyName, City, Country, Phone FROM Customers ORDER BY Country";
                ResultSet results = preparedStatement.executeQuery(query);

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
                }  if (choice == 3 ) {
                    String CategoryID = results.getString("CategoryID");
                    String CategoryName = results.getString("CategoryName");
                    System.out.println("Contact name: " + CategoryID);
                    System.out.println("Contact name: " + CategoryName);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        }
}




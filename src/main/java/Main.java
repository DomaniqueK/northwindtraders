import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection;
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/northwind",
                "root",
                "Apples06");

        Statement statement = connection.createStatement();
        String query = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM Products ";

        ResultSet results = statement.executeQuery(query);
        while (results.next()) {
            String ProductID = results.getString("ProductID");
            String ProductName= results.getString("ProductName");
            String UnitPrice = results.getString("UnitPrice");
            String UnitsInStock = results.getString("UnitsInStock");
            System.out.println("ProductID: " + ProductID);
            System.out.println("ProductName: " + ProductName);
            System.out.println("Unit Price: " + UnitPrice);
            System.out.println("Units In Stock: " + UnitsInStock);

        } connection.close();
    }
}

package rvt.product_and_categories;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static final String URL = "jdbc:sqlite:shop.db";

    public static Connection connect() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("Connected to SQLite");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}

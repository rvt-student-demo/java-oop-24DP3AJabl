package rvt.product_and_categories;
import java.sql.*;
import java.util.Scanner;

public class Main {
    
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        createTables();

        while (true) {
            System.out.println("Menu ++++++++++++++++++++++++");
            System.out.println("1.   Kategorijas pievienošana");
            System.out.println("2.   Produkta pievienošana   ");
            System.out.println("3.   Parādīt kategorijas     ");
            System.out.println("4.   Parādīt produktus       ");
            System.out.println("5.   Produktu meklešana      ");
            System.out.println("6.   EXIT                    ");
            System.out.println("     ++++++++++++++++++++++++");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choise) {
                case 1:
                    addCategory();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    showCategory();
                    break;
                case 4:
                    showProduct();
                    break;
                case 5:
                    searchProduct();
                    break;
                case 6:
                    System.out.println("Programa beidzas");
                    return;
                default:
                    System.out.println("Nepareiza ievade");
            }
        }
    }

    public static void createTables() {
        String categoriesTable = """
        CREATE TABLE IF NOT EXISTS categories (
            id INTEGER PRIMAY KEY AUTOINCREMENT,
            name TEXT NOT NULL
        );
        """;

        String productsTable = """
        CREATE TABLE IF NOT EXISTS products (
            id INTEGER PRIMAY KEY AUTOINCREMENT,
            name TEXT NOT NULL,
            price REAL NOT NULL,
            category_id INTEGER,
            FOREIGN KEY (category_id)
                REFERENCES cagories(id)
        );
        """;

        try (
            Connection conn = DatabaseConnection.connect();
            Statement stmt = conn.createStatement();
        ) {
            stmt.execute(categoriesTable);
            stmt.execute(productsTable);

            System.out.println("Table created");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addCategory() {
        System.out.print("Enter category name: ");
        String name = scanner.nextLine();

        String sql = "INSERT INTO categories(name) VALUES(?)";

        try (
            Connection conn = DatabaseConnection.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, name);
            ps.executeUpdate();

            System.out.println("Category added");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addProduct() {
        System.out.print("Ievade produkciju nosaukumu: ");
        String name = scanner.nextLine();
        System.out.print("Ievade produkciju cenu: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Ievade produkciju kategoriju: ");
        int categoryID = scanner.nextInt();

        String sql = "INSERT INTO products(name) VALUES(?, ?, ?)";

        try (
            Connection conn = DatabaseConnection.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setInt(3, categoryID);
            ps.executeUpdate();

            System.out.println("Product added");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showCategory() {
        String sql = "SELECT * FROM categories";

        try (
                Connection conn = DatabaseConnection.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ) {

            System.out.println("\n=== Categories ===");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void showProduct() {
        String sql = """
                SELECT products.id,
                       products.name,
                       products.price,
                       categories.name AS category
                FROM products
                JOIN categories
                ON products.category_id = categories.id
                """;

        try (
                Connection conn = DatabaseConnection.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ) {

            System.out.println("\n=== Products ===");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getDouble("price") + " | " +
                        rs.getString("category")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void searchProduct() {
        System.out.print("Enter category name: ");
        String categoryName = scanner.nextLine();

        String sql = """
                SELECT products.name,
                       products.price,
                       categories.name AS category
                FROM products
                JOIN categories
                ON products.category_id = categories.id
                WHERE categories.name = ?
                """;

        try (
                Connection conn = DatabaseConnection.connect();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, categoryName);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n=== Search Result ===");

            while (rs.next()) {

                System.out.println(
                        rs.getString("name") + " | " +
                        rs.getDouble("price") + " | " +
                        rs.getString("category")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

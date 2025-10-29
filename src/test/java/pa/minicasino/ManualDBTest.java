package pa.minicasino;

import java.sql.Connection;
import java.sql.DriverManager;

public class ManualDBTest {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/minicasino";
        String username = "postgres";
        String password = "Bdr5923!";

        try {
            // Explicitly load the driver
            Class.forName("org.postgresql.Driver");

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                System.out.println("Connected to the database successfully!");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("PostgreSQL Driver not found. Make sure it's on the classpath.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
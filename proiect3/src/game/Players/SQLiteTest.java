package game.Players;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteTest {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:test_database.db"; // SQLite va crea fișierul dacă nu există

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Conexiune la baza de date SQLite reușită!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}


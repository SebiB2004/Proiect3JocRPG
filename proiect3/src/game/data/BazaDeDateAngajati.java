package game.data;

import game.staff.Angajat;
import java.sql.*;

public class BazaDeDateAngajati {
    private Connection conn;

    public BazaDeDateAngajati() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:angajati.db");
            System.out.println("Conexiunea la baza de date a fost realizată cu succes.");
            String createTableSQL = "CREATE TABLE IF NOT EXISTS angajati (" +
                    "nume TEXT PRIMARY KEY, " +
                    "functie TEXT, " +
                    "autoritate TEXT)";
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(createTableSQL);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void adaugaAngajat(Angajat angajat) {
        String insertSQL = "INSERT INTO angajati (nume, functie, autoritate) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, angajat.getNume());
            pstmt.setString(2, angajat.getFunctie());
            pstmt.setString(3, angajat.getAutoritate());
            pstmt.executeUpdate();
            System.out.println("Angajatul " + angajat.getNume() + " a fost adăugat.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void stergeAngajat(String nume) {
        String deleteSQL = "DELETE FROM angajati WHERE nume = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
            pstmt.setString(1, nume);
            pstmt.executeUpdate();
            System.out.println("Angajatul " + nume + " a fost șters.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Angajat gasesteAngajat(String nume) {
        String selectSQL = "SELECT * FROM angajati WHERE nume = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
            pstmt.setString(1, nume);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String functie = rs.getString("functie");
                String autoritate = rs.getString("autoritate");
                Angajat angajat = new Angajat(nume, functie);
                angajat.setAutoritate(autoritate);
                return angajat;
            } else {
                System.out.println("Angajatul " + nume + " nu a fost găsit.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void listareAngajati() {
        String selectAllSQL = "SELECT * FROM angajati";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectAllSQL)) {
            System.out.println("Lista angajaților:");
            while (rs.next()) {
                String nume = rs.getString("nume");
                String functie = rs.getString("functie");
                String autoritate = rs.getString("autoritate");
                System.out.println("Nume: " + nume + ", Funcție: " + functie + ", Autoritate: " + autoritate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizeazaAutoritate(String nume, String autoritateNoua) {
        String updateSQL = "UPDATE angajati SET autoritate = ? WHERE nume = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
            pstmt.setString(1, autoritateNoua);
            pstmt.setString(2, nume);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Autoritatea pentru " + nume + " a fost actualizată la: " + autoritateNoua);
            } else {
                System.out.println("Angajatul " + nume + " nu a fost găsit.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package game;

import java.sql.*;

public class SQLiteTest {
    private static final String URL = "jdbc:sqlite:test_database.db";

    public SQLiteTest(){
        createTable();
    }
  public void createTable(){
        String sql = "CREATE TABLE IF NOT EXISTS stoc_hrana (" +
                "denumire TEXT PRIMARY KEY," +
                "cantitate INTEGER," +
                "pret REAL)";
      try (Connection conn = DriverManager.getConnection(URL);
           Statement stmt = conn.createStatement()) {
          stmt.execute(sql);
      } catch (SQLException e) {
          System.out.println("Eroare la crearea tabelului: " + e.getMessage());
      }
  }

  public void insertProdus(String denumire, int cantitate, double pret){
        String sql = "INSERT OR REPLACE INTO stoc_hrana(denumire, cantitate, pret) VALUES(?, ?, ?)";
      try (Connection conn = DriverManager.getConnection(URL);
           PreparedStatement pstmt = conn.prepareStatement(sql)) {
          pstmt.setString(1, denumire);
          pstmt.setInt(2, cantitate);
          pstmt.setDouble(3, pret);
          pstmt.executeUpdate();
      } catch (SQLException e) {
          System.out.println("Eroare la inserarea produsului: " + e.getMessage());
      }
  }
    public void updateCantitate(String denumire, int cantitateNoua) {
        String sql = "UPDATE stoc_hrana SET cantitate = ? WHERE denumire = ?";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, cantitateNoua);
            pstmt.setString(2, denumire);
            pstmt.executeUpdate();
            System.out.println("Cantitatea s-a actualizat!");
        } catch (SQLException e) {
            System.out.println("Eroare la actualizarea cantității: " + e.getMessage());
        }
    }
    public ResultSet getAllProduse() {
        String sql = "SELECT denumire, cantitate, pret FROM stoc_hrana";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(URL);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Eroare la obținerea produselor: " + e.getMessage());
        }
        return rs;
    }


    public void afiseazaProduse() {
        String sql = "SELECT denumire, cantitate, pret FROM stoc_hrana";
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Produse în baza de date:");
            while (rs.next()) {
                String denumire = rs.getString("denumire");
                int cantitate = rs.getInt("cantitate");
                double pret = rs.getDouble("pret");
                System.out.println("Denumire: " + denumire + ", Cantitate: " + cantitate + ", Pret: " + pret);
            }
        } catch (SQLException e) {
            System.out.println("Eroare la obținerea produselor: " + e.getMessage());
        }
    }
}


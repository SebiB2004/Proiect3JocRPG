package game;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StocHrana {
    private JTable tabelStoc;
    private DefaultTableModel model;
    private int inaltimeTabel = 50;
    private SQLiteTest dbHelper;

    public StocHrana(){
        dbHelper = new SQLiteTest();

        String coloane[] = {"denumire", "cantitate", "pret"};
        model = new DefaultTableModel(coloane, 0);
        tabelStoc = new JTable(model);
        tabelStoc.setBackground(Color.ORANGE);
        incarcaProdusedinBD();


        // Adaugă produse în interfață și în baza de date
        adaugaProdus(new Produs("Mere", 100, 15));
        adaugaProdus(new Produs("Pietre", 300, 20));
        adaugaProdus(new Produs("Afine", 1000, 5));
        adaugaProdus(new Produs("Mici", 2000, 20));

        tabelStoc.setBounds(150, 190, 300, 150);
        tabelStoc.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public void incarcaProdusedinBD(){
        model.setRowCount(0);
        ResultSet rs = dbHelper.getAllProduse();
        try{
            while(rs != null && rs.next()){
                String denumire = rs.getString("denumire");
                int cantitate = rs.getInt("cantitate");
                double pret = rs.getDouble("pret");
                model.addRow(new Object[]{denumire, cantitate, pret});
            }
        } catch(SQLException e){
            System.out.println("Eroare la incarcarea produselor din baza de date" + e.getMessage());
        }
    }

    public JTable getTabelStoc(){
        return this.tabelStoc;
    }

    public void adaugaProdus(Produs produs){
        dbHelper.insertProdus(produs.getNume(), produs.getCantitate(), produs.getPret());
    }

    public boolean scadeCantitate(String numeProdus, int cantitateScazut){
        boolean produsGasit = false;

        for(int i = 0; i < model.getRowCount(); i++) {
            String denumireProdus = (String) model.getValueAt(i, 0);
            if (denumireProdus.equalsIgnoreCase(numeProdus)) {
                produsGasit = true;
                int cantitateActuala = (int) model.getValueAt(i, 1);

                if(cantitateActuala >= cantitateScazut){
                    int cantitateNoua = cantitateActuala - cantitateScazut;
                    System.out.println("Cantitate actuala: " + cantitateActuala);
                    model.setValueAt(cantitateNoua, i, 1);
                    model.fireTableRowsUpdated(i,i);
                    dbHelper.updateCantitate(numeProdus, cantitateNoua);
                    dbHelper.afiseazaProduse();

                    System.out.println("Cantitatea noua: " + cantitateNoua);
                    tabelStoc.repaint();
                    tabelStoc.revalidate();
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Cantitate insuficienta in stoc!");
                    return false;
                }
            }
        }
        if(!produsGasit){
            JOptionPane.showMessageDialog(null, "Produsul nu a fost gasit in stoc!");
        }
        return false;
    }

}

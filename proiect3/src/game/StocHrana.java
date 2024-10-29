package game;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StocHrana

{
    private  JTable tabelStoc;
    private DefaultTableModel model;
    private int inaltimeTabel = 50;

    public StocHrana(){
        String coloane[] = {"Denumire", "Cantitate in stoc", "Pret/kg"};
        model = new DefaultTableModel(coloane, 0);
        model.addRow(new String[]{"Denumire", "Cantitate(kg)", "Pret / kg"});
        tabelStoc = new JTable(model);
        tabelStoc.setBackground(Color.ORANGE);
        adaugaProdus(new Produs("Furaj combinat", 100, 15));
        adaugaProdus(new Produs("Porumb boabe", 300, 20));
        tabelStoc.setBounds(100, 120, 300, 150);
        tabelStoc.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    public JTable getTabelStoc(){
        return this.tabelStoc;
    }

    public void adaugaProdus(Produs produs){
        model.addRow(new Object[]{produs.getNume(), produs.getCantitate(), produs.getPret()});
    }

    public boolean scadeCantitate(String numeProdus, int cantitateScazut){
        boolean produsGasit = false;
        for(int i = 0; i < model.getRowCount(); i++) {
            String denumireProdus = (String) model.getValueAt(i, 0);
            if (denumireProdus.equalsIgnoreCase(numeProdus)) {
                produsGasit = true;
                int cantitateActuala = (int) model.getValueAt(i, 1);
                if(cantitateActuala >= cantitateScazut){
                    model.setValueAt(cantitateActuala - cantitateScazut, i, 1);
                    model.fireTableDataChanged();
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Cantitate insuficienta in stoc!");
                    return false;
                }
            }
        }
        if(!produsGasit){
            JOptionPane.showMessageDialog(null,  "Produsul nu a fost gasit in stoc!");
        }
        return false;

    }
    public void StergeProduse(){
        model.setRowCount(0);
    }
}


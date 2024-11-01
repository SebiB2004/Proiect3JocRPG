package game.logic;

import game.Monstru;
import game.logic.Batalie;

import javax.swing.*;
public class BatalieDragoni extends Batalie {

    public BatalieDragoni(Monstru dragon1, Monstru dragon2) {
        super(dragon1, dragon2);
    }
    @Override
    protected Atac alegereAtac(String numeDragon) {
        String[] optiuni = {"Atac Fizic", "Suflu de Foc", "Lovitură de Aripă"};
        int alegere = JOptionPane.showOptionDialog(null, "Alege atacul pentru " +
                        numeDragon, "Alege atac",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, optiuni, optiuni[0]);
        switch (alegere) {
            case 0:
                return new AtacFizic();
            case 1:
                return new SufluDeFoc();
            case 2:
                return new LovituraDeAripa();
            default:
                return null;
        }
    }
}

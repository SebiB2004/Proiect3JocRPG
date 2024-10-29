package game;

import javax.swing.*;
import java.awt.*;

public class FightLogic extends Monstru{
    private JPanel batalie;

    public FightLogic(){
    batalie = new JPanel();
    batalie.setBackground(Color.orange);
    batalie.setLayout(new BorderLayout());

    }
    public JPanel getBatalie(){
        return this.batalie;
    }

}

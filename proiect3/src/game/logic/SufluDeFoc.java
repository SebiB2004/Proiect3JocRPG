package game.logic;

import java.util.Random;

public class SufluDeFoc implements Atac {
    private static final double sansa_atac = 0.65; // 65% șanse de reușită
    private static final Random random = new Random();

    @Override
    public int executaAtac() {
        if (random.nextDouble() < sansa_atac) {
            return 25; // Daune pentru suflu de foc
        } else {
            System.out.println("Suflul de foc a ratat!");
            return 0; // Atacul ratează
        }
    }

    @Override
    public String descriere() {
        return "Suflu de Foc";
    }
}

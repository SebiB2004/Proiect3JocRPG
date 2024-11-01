package game.logic;

import java.util.Random;

public class AtacFizic implements Atac {
    private static final double sansa_atac = 1; // Asta e mereu true deoarece e 100% sanse , l-am schimbat ca am zis in caz de vrei sa te joci cu valorile , vezi tu
    private static final Random random = new Random();

    @Override
    public int executaAtac() {
        if (random.nextDouble() < sansa_atac) {
            return 10; // Daune pentru atac fizic
        } else {
            System.out.println("Atacul fizic a ratat!");
            return 0; // Atacul ratează
        }
    }

    @Override
    public String descriere() {
        return "Atac Fizic";
    }
}

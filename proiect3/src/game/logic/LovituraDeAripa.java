package game.logic;

import java.util.Random;

//(80% inseamna ca 8/10 va lovii atacul iar 20% sanse sa rateze)
public class LovituraDeAripa implements Atac {
    private static final double sansa_atac = 0.8; // Asta reprezinta procentajul de atac
    private static final Random random = new Random();

    @Override
    public int executaAtac() {
        if (random.nextDouble() < sansa_atac) {
            return 15; // Daune pentru lovitura de aripa, aici ai putea schimba dupa mine , mai mult cand e gata sau ceva , joaca-te putin cu valorile astea
        } else {
            System.out.println("Lovitura de aripă a ratat!");
            return 0;
        }
    }

    @Override
    public String descriere() {
        return "Lovitură de Aripă";
    }
}

package game.logic;

public class AtacFizic implements Atac {
    @Override
    public int executaAtac() {
        return 10; // Daune pentru atac fizic
    }

    @Override
    public String descriere() {
        return "Atac Fizic";
    }
}
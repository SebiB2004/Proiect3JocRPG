package game.entities;

public class Player implements Character, StatusDisplayable {
    private String name;
    private int health;

    public Player(String name) {
        this.name = name;
        this.health = 100;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public void printStatus() {
        System.out.println(name + " - Viață: " + health);
    }
}

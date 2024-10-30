package game.entities;

import java.util.Random;

public class Monster implements Character, Attackable, StatusDisplayable {
    private String name;
    private int health;
    private int attackDamage;
    private static final Random rand = new Random();

    public Monster(String name) {
        this.name = name;
        this.health = 50;
        this.attackDamage = 5;
    }

    public Monster(String name, int health, int attackDamage) {
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
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

    @Override
    public int attack() {
        int damage = attackDamage;
        if (rand.nextDouble() <= 0.2) {
            damage *= 2;
        }
        return damage;
    }
}

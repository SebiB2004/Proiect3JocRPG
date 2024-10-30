package game.logic;

import game.entities.Monster;
import game.entities.Player;
import java.util.ArrayList;
import java.util.List;

public class GameWorld {
    private Player player;
    private List<Monster> monsters;

    public GameWorld(String playerName) {
        this.player = new Player(playerName);
        this.monsters = new ArrayList<>();
        monsters.add(new Monster("Goblin"));
        monsters.add(new Monster("Orc"));
        monsters.add(new Monster("Troll"));
        monsters.add(new Monster("Dragon", 100, 10)); // Boss
    }

    public Player getPlayer() {
        return player;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }
}

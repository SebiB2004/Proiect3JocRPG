package game.Players;

public class Player {

    int level;
    String autoritate;
    private String nume;

    public Player(){

    }

    public Player(String nume, int level){
        this.level = level;
        this.nume = nume;
    }

    public String getNume(){
        return this.nume;
    }

    public int getLevel(){

        return this.level;
    }


    public void setAutoritate(String autoritate){
        this.autoritate = autoritate;
    }

    public String getAutoritate(){
        return this.autoritate;
    }

}

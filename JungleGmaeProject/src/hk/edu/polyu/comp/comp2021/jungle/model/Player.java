package hk.edu.polyu.comp.comp2021.jungle.model;

public class Player {
    private int playerID;
    private String name;

    public Player(int id){
        this.playerID = id;
    }
    public int getPlayerID(){
        return playerID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

package hk.edu.polyu.comp.comp2021.jungle.model;

/**
 * Player: playerID,name
 */
public class Player {
    private int playerID;
    private String name;

    /**
     * constructor
     * @param id the id for different player
     */
    public Player(int id){
        this.playerID = id;
    }

    /**
     * @return playerID
     */
    public int getPlayerID(){
        return playerID;
    }

    /**
     *
     * @param name player name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }
}

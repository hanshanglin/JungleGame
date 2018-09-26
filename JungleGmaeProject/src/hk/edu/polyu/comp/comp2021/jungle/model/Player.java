package hk.edu.polyu.comp.comp2021.jungle.model;

public class Player {
    private int playerID;
    private int[] pieceList;

    public Player(int id){
        this.playerID = id;
    }
    public int getPlayerID(){
        return playerID;
    }
    public int[] getPieceList() {
        return pieceList;
    }

}

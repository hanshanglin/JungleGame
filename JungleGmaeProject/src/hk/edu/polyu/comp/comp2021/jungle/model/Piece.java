package hk.edu.polyu.comp.comp2021.jungle.model;


import org.jetbrains.annotations.NotNull;

public class Piece {
    /**
     * 8 Elephant
     * 7 Lion
     * 6 Tiger
     * 5 Leopard
     * 4 Wolf
     * 3 Dog
     * 2 Cat
     * 1 Rat */

    protected int rank;
    protected int[] position={0,0};
    protected int owner;

    public Piece(int rank,int owner){

        this.rank = rank;
        this.owner = owner;
    }

    public int[] getPosition(){
        return position;
    }
    private void updatePosition(@NotNull int[] newPosition){
        position = newPosition.clone();
    }
    public boolean checkMove(int x, int y){
        return false;
    }
}

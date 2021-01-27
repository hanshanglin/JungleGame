package hk.edu.polyu.comp.comp2021.jungle.model;
/**
 * extends from Piece
 * Wolf: rank 4
 */
public class Wolf extends Piece {
    /**
     * init: for player1 [2,2], for player2 [4,6]
     * @param owner 0 for player1, 1 for player2
     */
    public Wolf(int owner) {
        super(owner);
        if(owner == 0){
            this.x = 2;
            this.y = 2;
        }
        else{
            this.x = 4;
            this.y = 6;
        }
        this.rank = 4;
    }
}

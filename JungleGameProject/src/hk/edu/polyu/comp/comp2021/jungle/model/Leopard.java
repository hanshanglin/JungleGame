package hk.edu.polyu.comp.comp2021.jungle.model;

/**
 * extends from Piece
 * Leopard: rank 5
 */
public class Leopard extends Piece {
    /**
     * init: for player1 [4,2], for player2 [2,6]
     * @param owner 0 for player1, 1 for player2
     */
    public Leopard(int owner) {
        super(owner);
        if(owner == 0){
            this.x = 4;
            this.y = 2;
        }
        else{
            this.x = 2;
            this.y = 6;
        }
        this.rank = 5;
    }
}

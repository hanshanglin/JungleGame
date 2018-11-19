package hk.edu.polyu.comp.comp2021.jungle.model;

/**
 * extends from Piece
 * Cat: rank 2
 */
public class Cat extends Piece {
    /**
     * init: for player1 [1,1], for player2 [5,7]
     * @param owner 0 for player1, 1 for player2
     */
    public Cat(int owner) {
        super(owner);
        if(owner == 0){
            this.x = 1;
            this.y = 1;
        }
        else{
            this.x = 5;
            this.y = 7;
        }
        this.rank = 2;
    }
}

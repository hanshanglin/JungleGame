package hk.edu.polyu.comp.comp2021.jungle.model;
/**
 * extends from Piece
 * Dog: rank 3
 */
public class Dog extends Piece {
    /**
     * init: for player1 [5,1], for player2 [1,7]
     * @param owner 0 for player1, 1 for player2
     */
    public Dog(int owner) {
        super(owner);
        if(owner == 0){
            this.x = 5;
            this.y = 1;
        }
        else{
            this.x = 1;
            this.y = 7;
        }
        this.rank = 3;
    }
}

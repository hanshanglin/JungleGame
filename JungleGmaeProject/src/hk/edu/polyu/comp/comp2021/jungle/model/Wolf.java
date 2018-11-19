package hk.edu.polyu.comp.comp2021.jungle.model;
/**
 * extends from Piece
 * Wolf: rank 4
 */
public class Wolf extends Piece {
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

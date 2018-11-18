package hk.edu.polyu.comp.comp2021.jungle.model;

public class Leopard extends Piece {
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

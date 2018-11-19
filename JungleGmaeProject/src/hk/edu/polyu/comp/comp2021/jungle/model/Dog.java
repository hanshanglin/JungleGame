package hk.edu.polyu.comp.comp2021.jungle.model;

public class Dog extends Piece {
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

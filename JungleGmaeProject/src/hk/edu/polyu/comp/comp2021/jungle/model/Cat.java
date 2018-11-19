package hk.edu.polyu.comp.comp2021.jungle.model;

public class Cat extends Piece {

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

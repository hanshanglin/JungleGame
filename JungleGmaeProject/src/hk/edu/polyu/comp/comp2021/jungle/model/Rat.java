package hk.edu.polyu.comp.comp2021.jungle.model;

public class Rat extends Piece{

    public Rat(int rank, int owner) {
        super(rank, owner);
        if(owner == 0){
            this.position = new int[]{7,3};
        }
        else{
            this.position = new int[]{1,7};
        }
    }

    public boolean checkMove(int x, int y){
        /**check movement*/
        if (Math.abs(x-this.position[0])==1){

        }
        /**check water*/

        /**check traps*/

        /**check rank*/

        /**check den*/
        return false;
    }

}

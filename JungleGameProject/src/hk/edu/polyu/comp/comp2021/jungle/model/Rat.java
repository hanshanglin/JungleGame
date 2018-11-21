package hk.edu.polyu.comp.comp2021.jungle.model;
/**
 * extends from Piece
 * Rat: rank 1 | can jump into the water | can kill rank 8(Elephant)
 */
public class Rat extends Piece{
    /**
     * init: for player1 [6,2], for player2 [0,6]
     * @param owner 0 for player1, 1 for player2
     */
    public Rat(int owner) {
        super(owner);
        if(owner == 0){
            this.x = 6;
            this.y = 2;
        }
        else{
            this.x = 0;
            this.y = 6;
        }
        this.rank = 1;
    }


    @Override
    public boolean checkMove(int x, int y, int[][] map, Piece[][] pieces)throws Exception{
        /**check movement*/
        int nowX = this.getX();
        int nowY = this.getY();
        if(x==nowX && y == nowY) throw new Exception("the piece should move");
        if(Math.abs(x-nowX)+Math.abs(y-nowY) > 1) throw new Exception("the piece can't move in that way");
        if(y == (owner==0?0:8) && x==8) throw new Exception("the piece can't move to your own den");

        if (pieces[y][x] == null)return true; // no enemy
        if (pieces[y][x].getOwner() == owner) throw new Exception("the piece can't attack friend");

        if (map[nowY][nowX] == -10){ // now is in water
            if (map[y][x] == -10) return true; // enemy's rat in water
            throw new Exception("the piece can't move in that way");
        }
        else { // now is on land
            if(map[y][x] == -10) throw new Exception("the piece can't move in that way"); // can't attack enemy in water
            if(map[y][x] == -1){ // enemy in trap
                return true;
            }
            return pieces[y][x].getRank() >= rank || pieces[y][x].getRank() == 8;
        }
    }

}

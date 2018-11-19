package hk.edu.polyu.comp.comp2021.jungle.model;

/**
 * extends from Piece
 * Elephant: rank 8 | killed by rank 1(Rat)
 */
public class Elephant extends Piece {
    /**
     * init: for player1 [0,2], for player2 [6,6]
     * @param owner 0 for player1, 1 for player2
     */
    public Elephant(int owner) {
        super(owner);
        if(owner == 0){
            this.x = 0;
            this.y = 2;
        }
        else{
            this.x = 6;
            this.y = 6;
        }
        this.rank = 8;
    }

    @Override
    public boolean checkMove(int x, int y, int[][] map, Piece[][] pieces)throws Exception{
        /*check movement*/
        int nowX = this.getX();
        int nowY = this.getY();
        if(x==nowX && y == nowY) throw new Exception("the piece should move");
        if(Math.abs(x-nowX)+Math.abs(y-nowY) > 1) throw new Exception("the piece can't move in that way");
        if(map[y][x] == -10) throw new Exception("the piece can't move in that way"); // can't go into water
        if (pieces[y][x] == null)return true; // no enemy
        if (pieces[y][x].getOwner() == owner) throw new Exception("the piece can't attack friend");

        if(map[y][x] == -1){ // enemy in trap
            map[y][x] = 0;
            return true;
        }
        return pieces[y][x].getRank() >= rank && pieces[y][x].getRank() != 1;
    }
}

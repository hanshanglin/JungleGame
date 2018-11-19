package hk.edu.polyu.comp.comp2021.jungle.model;

public class Elephant extends Piece {


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

    public boolean checkMove(int x, int y,int[][] map,Piece[][] pieces)throws Exception{
        /**check movement*/
        int nowX = this.getX();
        int nowY = this.getY();
        if(x==nowX && y == nowY) throw new Exception("the piece should move");
        if(Math.abs(x-nowX)+Math.abs(y-nowY) > 1) throw new Exception("the piece can't move in that way");
        if(map[y][x] == -10) throw new Exception("the piece can't move in that way"); // can't go into water
        if (pieces[y][x] == null)return true; // no enemy
        if (pieces[y][x].owner == owner) throw new Exception("the piece can't attack friend");

        if(map[y][x] == -1){ // enemy in trap
            map[y][x] = 0;
            return true;
        }
        if(pieces[y][x].rank >= rank && pieces[y][x].rank!=1) return true;
        return false;
    }
}

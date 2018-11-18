package hk.edu.polyu.comp.comp2021.jungle.model;


import org.jetbrains.annotations.NotNull;

public class Piece {
    /**
     * 8 Elephant
     * 7 Lion
     * 6 Tiger
     * 5 Leopard
     * 4 Wolf
     * 3 Dog
     * 2 Cat
     * 1 Rat */

    protected int rank;
    protected int x=0;
    protected int y=0;
    protected int owner;

    public Piece(int owner){


        this.owner = owner;
    }

    public int getX() {
        return x;
    }
    public int getY(){
        return y;
    }

    public void setPos(int x,int y){
        this.x = x;
        this.y = y;
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
        if(pieces[y][x].rank >= rank) return true;
        return false;
    }

    private void update(int x, int y){
        this.x = x;
        this.y = y;
    }
}

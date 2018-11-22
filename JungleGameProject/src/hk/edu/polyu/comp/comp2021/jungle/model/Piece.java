package hk.edu.polyu.comp.comp2021.jungle.model;

/**
 * super class of all type of Piece
 */
public class Piece {
    /** rank: level */
    protected int rank;
    /** x: the col of the piece */
    protected int x=0;
    /** y: the row of the piece */
    protected int y=0;
    /** owner: the owner of the piece, 0 is belong to player0, 1 is belong to player1 */
    protected int owner;

    /**
     * constructor
     * @param owner the owner of the piece
     */
    public Piece(int owner){
        this.owner = owner;
    }

    /**
     * @return rank
     */
    public int getRank(){
        return rank;
    }

    /**
     * @return owner
     */
    public int getOwner(){
        return owner;
    }

    /**
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * @return y
     */
    public int getY(){
        return y;
    }

    /**
     *
     * @param x col
     * @param y row
     */
    public void setPos(int x,int y){
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @param x target col
     * @param y target row
     * @param map board map
     * @param pieces position of pieces
     * @return true if move is valid
     * @throws Exception if move is invalid
     */
    public boolean checkMove(int x, int y,int[][] map,Piece[][] pieces)throws Exception{
        int nowX = this.getX();
        int nowY = this.getY();
        if(x==nowX && y == nowY) throw new Exception("the piece should move");
        if(Math.abs(x-nowX)+Math.abs(y-nowY) > 1) throw new Exception("the piece can't move in that way");
        if(y == (owner==0?0:8) && x==3) throw new Exception("the piece can't move to your own den");
        if(map[y][x] == -10) throw new Exception("the piece can't move in that way"); // can't go into water
        if (pieces[y][x] == null)return true; // no enemy
        if (pieces[y][x].getOwner() == owner) throw new Exception("the piece can't attack friend");

        if(map[y][x] == -1){ // enemy in trap
            return true;
        }
        if(pieces[y][x].getRank() > rank)
            throw new Exception("the target's rank is higher") ;
        return true;
    }
    
    @Override
    public String toString(){return Character.toString((char)((this.owner==0?'A':'a')+this.rank-1)); }
}

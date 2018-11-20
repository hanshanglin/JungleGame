package hk.edu.polyu.comp.comp2021.jungle.model;

/**
 * extends from Piece
 * Lion: rank 7 | can jump over the water
 */
public class Lion extends Piece {
    /**
     * init: for player1 [6,0], for player2 [0,8]
     * @param owner 0 for player1, 1 for player2
     */
    public Lion(int owner) {
        super(owner);
        if(owner == 0){
            this.x = 6;
            this.y = 0;
        }
        else{
            this.x = 0;
            this.y = 8;
        }
        this.rank = 7;
    }
    @Override
    public boolean checkMove(int x, int y, int[][] map, Piece[][] pieces)throws Exception{
        /*check movement*/
        int nowX = this.getX();
        int nowY = this.getY();
        if(x==nowX && y == nowY) throw new Exception("the piece should move");
        if(Math.abs(x-nowX)+Math.abs(y-nowY) > 1){
            //jump water
            if(Math.abs(x-nowX) != 0 && Math.abs(y-nowY) !=0){
                throw new Exception("the piece can't move in that way");
            }
            else if (x != nowX) {
                if (x < nowX) {
                    for (int i = x + 1; i < nowX; i++) {
                        if (map[y][i] != -10) throw new Exception("the piece can't move in that way");
                    }
                } else {
                    for (int i = nowX + 1; i < x; i++) {
                        if (map[y][i] != -10) throw new Exception("the piece can't move in that way");
                    }
                }
            } else {
                if (y < nowY) {
                    for (int i = y + 1; i < nowY; i++) {
                        if (map[i][x] != -10) throw new Exception("the piece can't move in that way");
                    }
                } else {
                    for (int i = nowY + 1; i < y; i++) {
                        if (map[i][x] != -10) throw new Exception("the piece can't move in that way");
                    }
                }
            }
            return true;
        }
        if(map[y][x] == -10) throw new Exception("the piece can't move in that way"); // can't go into water
        if (pieces[y][x] == null)return true; // no enemy
        if (pieces[y][x].getOwner() == owner) throw new Exception("the piece can't attack friend");

        if(map[y][x] == -1){ // enemy in trap
            map[y][x] = 0;
            return true;
        }
        return pieces[y][x].getRank() >= rank;
    }
}

package hk.edu.polyu.comp.comp2021.jungle.model;


public class CheckerBoard {
    private int[][] board;
    private Piece[][] pieceBoard;
    private int X;
    private int Y;

    public  CheckerBoard(){
    }

    public int[][] getBoard() {
        return board;
    }

    public Piece[][] getPieceBoard() {
        return pieceBoard;
    }

    public boolean movePiece(int x1, int y1, int x2, int y2){

        /**if can't move return false/
         * if can move, do move and return true
         */
        return false;
    }

    public void newBoard(){
        this.board = new int[9][7];
    }

    public void loadBoard(String path){

    }

    public void newPieceBoard(){
        /**set original PieceBoard
         * */
    }

    public void loadPieceBoard(String path){
        /**set Pieces as position in path file*/
    }

}

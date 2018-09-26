package hk.edu.polyu.comp.comp2021.jungle.model;

import java.util.Arrays;

public class CheckerBoard {
    private int currentTurn; // 0 for user 1, 1 for user 2
    private int[][] board;
    private Piece[][] pieceBoard;
    private int X;
    private int Y;
    private Player p1;
    private Player p2;

    public  CheckerBoard(){
        currentTurn=0;
        this.p1 = new Player(0);
        this.p2 = new Player(1);
        this.board = new int[][]{
                {0,0,-1,-10,-1,0,0},
                {0,0,0,-1,0,0,0},
                {0,0,0,0,0,0,0},
                {0,-2,-2,0,-2,-2,0},
                {0,-2,-2,0,-2,-2,0},
                {0,-2,-2,0,-2,-2,0},
                {0,0,0,0,0,0,0},
                {0,0,0,-1,0,0,0},
                {0,0,-1,-10,-1,0,0}
        };
        /*
          new piece
          */
    }

    public  CheckerBoard(String path){
        /**load game from a file*/
    }





    public void changePiece(int x1,int y1,int x2,int y2){

    }

    public void printBoard(){

    }

    public void newPieceBoard(){

    }

    public void loadPieceBoard(){

    }
    public int getBoard(int x, int y){
        return board[x][y];
    }


}

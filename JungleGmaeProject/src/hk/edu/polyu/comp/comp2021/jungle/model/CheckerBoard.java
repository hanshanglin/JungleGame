package hk.edu.polyu.comp.comp2021.jungle.model;

import java.util.Arrays;

public class CheckerBoard {
    private int[][] board={
            {0,0,-1,-10,-1,0,0},
            {0,0,0,-1,0,0,0},
            {0,0,0,0,0,0,0},
            {0,-2,-2,0,-2,-2,0},
            {0,-2,-2,0,-2,-2,0},
            {0,-2,-2,0,-2,-2,0},
            {0,0,0,0,0,0,0},
            {0,0,0,-1,0,0,0},
            {0,0,-1,-10,-1,0,0},
    };

    final private int X = board[0].length;
    final private int Y = board.length;

    private Piece[][] pieceBoard= new Piece[Y][X];
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

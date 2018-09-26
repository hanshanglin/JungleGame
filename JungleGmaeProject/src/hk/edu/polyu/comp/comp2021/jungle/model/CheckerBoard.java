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

    public void printBoard(){

        for (int i = 0; i < 9; i++) {

        }
        for (int i = 0;i<Y;i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public int getBoard(int x, int y){
        return board[x][y];
    }


}

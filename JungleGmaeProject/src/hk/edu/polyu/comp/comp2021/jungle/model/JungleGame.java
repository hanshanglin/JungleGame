package hk.edu.polyu.comp.comp2021.jungle.model;

import java.util.Scanner;

public class JungleGame {


    public JungleGame(){}
    public void gameSetUp(){
        Scanner sc = new Scanner(System.in);
        IOController io = new IOController(sc);
        io.getCommand();
    }
    public void newGame(){
        CheckerBoard checkerBoard = new CheckerBoard();
        checkerBoard.printBoard();
    }



    public void win(int i){
        /** player i is win*/
    }
}

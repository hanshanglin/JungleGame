package hk.edu.polyu.comp.comp2021.jungle.model;

import java.util.Scanner;

public class Controller {
    /**state 0: no game
     * state 1: single pc game
     * state 2: online pc game
     * */
    private int state = 0;
    private Scanner sc;
    private Displayer view;
    private JungleGame game;

    public Controller(){
        this.sc = new Scanner(System.in);
        this.game = new JungleGame();
        this.view = new Displayer(game);
    }

    private String getCommand(){
        return sc.nextLine();
    }

    public void gameSetUp(){
        /**
         * ask for game choice*/
        Displayer.messageDisplay("Welcome to the JungleGame, you can choose following command:");
        Displayer.messageDisplay("NEW:\tto crate a new game");
        Displayer.messageDisplay("OPEN [path]:\tto open a exist game");
        cmdParsing(getCommand());
    }


    public static void cmdParsing(String cmd){

        /**gameState :  0 for no game playing now, cmd can be "NEW" "OPEN"
         *              1 for a game is playing, cmd can be "NEW" "OPEN" "Online" ->need to remind save the game
         *                                          or can be "MOVE"  "SAVE"
         *
         *
         * just for test ,will change to regex */

        cmd = cmd.toUpperCase();
        cmd = cmd.trim();
        if (cmd.equals("NEW")) crateHandle();
        else{
            String[] temp = cmd.split(" ");
            if (temp[0]=="OPEN") openHandle(temp[1]);
            else if(temp[0]=="SAVE") saveHandle(temp[1]);
            else if(temp[0]=="MOVE") moveHandle(temp[1].charAt(1)-'A',temp[1].charAt(0),temp[2].charAt(1)-'A',temp[1].charAt(0));
        }


    }
    private static void saveHandle(String path){
        /**
         * if path didn't exist, print error message and ask another command
         * if exist, call save function
         * */

    }
    private static void crateHandle(){
        /**
         * if a game has existed, ask user if need to save(Y/N)
         *  if Y, ask for a path, call saveHandle
         * else open a new game
         * */

    }
    private static void openHandle(String path){
        /**
         * if path didn't exist, print error message and ask another command
         * else load the game
         * */

    }
    private static boolean moveHandle(int x1,int y1,int x2,int y2){
        /**
         * check if move is allow,
         * if allow refresh the output
         * else ask another command
         * */
        return false;
    }

}

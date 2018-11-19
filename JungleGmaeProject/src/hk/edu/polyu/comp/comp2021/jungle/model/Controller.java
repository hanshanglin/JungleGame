package hk.edu.polyu.comp.comp2021.jungle.model;

import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Controller {
    /**state 0: no game
     * state 1: single pc game
     * state 2: online pc game
     Welcome to the JungleGame, you can choose following command:
     NEW:	to create a new game
     OPEN [path]:	to open a exist game
     NEW
     * */
    private int state = 0;
    private Scanner sc;
    private Displayer view;
    private JungleGame game;

    public Controller(){
        this.sc = new Scanner(System.in);
    }


    private String getCommand(){
        return sc.nextLine().trim();
    }

    private String getName(){
        return sc.nextLine();
    }

    public void gameSetUp(){
        /*
          ask for game choice*/
        Displayer.messageDisplay("Welcome to the JungleGame, you can choose following command:\n");
        Displayer.messageDisplay("STANDALONE:\tplay the game on this PC\n");
        Displayer.messageDisplay("ONLINE:\tplay the game on two PC\n");
        while(state == 0){
            cmdParsing(getCommand());
        }
        if(state == 1){
            singleGameSetUp();
            return;
        }
        else{
            //onlineGameSetUp();
        }
        cmdParsing(getCommand());
    }

    private void singleGameSetUp(){
        Displayer.messageDisplay("NEW:\tto open a new game\n");
        Displayer.messageDisplay("OPEN [path]:\tto open a exist game\n");
        cmdParsing(getCommand());
    }




    /**
     * use for game, keep doing round
     */
    public void doRound(){
        while(!game.isEnd() && state!=0){
            view.turnMsgDisplay();
            cmdParsing(getCommand());
            view.boardDisplay();
        }
        view.winnerDisplay();
    }

    /**
     * parsing the user's input
     *
     * @param cmd the user's input
     */
    public void cmdParsing(String cmd){
        StringTokenizer token = new StringTokenizer(cmd," ");
        String temp = token.nextToken();
        if (state == 0){
            if (temp.toUpperCase().equals("STANDALONE")) {
                state = 1;
                return;
            }
            if (temp.toUpperCase().equals("ONLINE")){
                state = 2;
                return;
            }
            Displayer.messageDisplay("please enter STANDALONE or ONLINE to select game mode.\n");
            return;
        }
        try {
            if (temp.toUpperCase().equals("NEW"))
            createHandle();
            else{
                if (temp.toUpperCase().equals("OPEN")) openHandle(token.nextToken());
                else if (temp.toUpperCase().equals("SAVE")) saveHandle(token.nextToken());
                else if (temp.toUpperCase().equals("MOVE"))
                    moveHandle(token.nextToken().toUpperCase(),token.nextToken().toUpperCase());
            }
        }
        catch (Exception e) {cmdParsing(getCommand());}
    }

    /**
     * save game
     *
     * @param path
     * @throws Exception
     */
    private void saveHandle(String path){
        /*
          if path didn't exist, print error message and ask another command
          if exist, call save function
          */
        game.saveGame(path);
    }

    /**
     * create a new game
     */
    private void createHandle(){
        if(state!=0 && game!=null){
            Displayer.messageDisplay("A game is existing now, please save it first, if you do not want to save, please input \"Y\"\n");
            if(!getCommand().equals("Y")){
                Displayer.messageDisplay("You give up to create new game, now you can back to game\n");
                return;
            }
        }

        this.game = new JungleGame();
        this.view = new Displayer(game);

        game.newGame();
        Displayer.messageDisplay("please enter the player1 's name:\n");
        game.getPlayer(0).setName(getName());
        Displayer.messageDisplay("please enter the player2 's name:\n");
        game.getPlayer(1).setName(getName());

        view.boardDisplay();
        doRound();
    }

    /**
     * @param path
     * @throws Exception if file not exists
     */
    private void openHandle(String path)throws Exception{
        if(state!=0 && game!=null){
            Displayer.messageDisplay("A game is existing now, please save it first, if you do not want to save, please input \"Y\"\n");
            if(!getCommand().equals("Y")){
                Displayer.messageDisplay("You give up to create new game, now you can back to game\n");
                return;
            }
        }
        File file = new File(path);
        if(!file.exists()){
            throw new Exception("ERROR: file not exists");
        }
        this.game = new JungleGame();
        this.view = new Displayer(game);
        game.openGame(file);
        view.boardDisplay();
        doRound();
    }

    /**
     *
     * @param pos1 the first position input as "A1"
     * @param pos2 the second position input as "A1"
     * @return boolean if the no error return true
     * @throws Exception if move is invalid
     */
    private boolean moveHandle (String pos1,String pos2)throws Exception{
        if(game == null)throw new Exception("No game exits now.\n");
        int x = pos1.charAt(0)-'A';
        int y = pos1.charAt(1)-'1';
        int newX = pos2.charAt(0)-'A';
        int newY = pos2.charAt(1)-'1';
        if (x<0 || x>6 || y<0 || y>9){
            throw new Exception("position 1 invalid");
        }
        if (newX<0 || newX>6 || newY<0 || newY>9){
            throw new Exception("position 2 invalid");
        }
        try{
            game.move(x,y,newX,newY);
        }
        catch (Exception e){
            Displayer.messageDisplay(e.getMessage());
        }
        return true;
    }
}

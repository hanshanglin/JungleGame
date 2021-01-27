package hk.edu.polyu.comp.comp2021.jungle.model;


import com.sun.istack.internal.Nullable;
import hk.edu.polyu.comp.comp2021.jungle.view.Displayer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;

/**
 * main control the game cycle
 */
public class JungleGame {
    /** CheckerBoard cb: record piece information and movement  */
    private CheckerBoard cb;
    /** currentTurn : record the current turn. 0 means player0's turn, 1 means player1's turn*/
    private int currentTurn;
    /**  */
    private Player p0;
    private Player p1;
    private boolean end;

    @Nullable
    private Player winner = null;
    // 0 for user 0, 1 for user 1

    /**
     * constructor
     */
    public JungleGame(){
        currentTurn=0;
        this.cb = new CheckerBoard();
        this.p0 = new Player(0);
        this.p1 = new Player(1);
    }

    /**
     * init new game
     */
    public void newGame(){
        currentTurn = 0;
        cb.newBoard();
        cb.originalPieceBoard();
        this.end = false;
    }

    /**
     *
     * save game
     * @param path save file path
     */
    public void saveGame(String path){
        File file = new File(path);
        try{
            file.createNewFile();
            OutputStream os = new FileOutputStream(file);
            OutputStreamWriter writer = new OutputStreamWriter(os, StandardCharsets.UTF_8);
            /* creates a FileWriter Object*/

            /*player name*/
            writer.write(p0.getName());
            writer.write("\r\n");
            writer.write(p1.getName());
            writer.write("\r\n");
            /* current turn */
            writer.write(String.valueOf(currentTurn));
            writer.write("\r\n");
            /* piece */
            Piece[][] pieceMap = cb.getPieceBoard();
            for(int i = 0;i<9;i++){
                for (int j = 0; j < 7; j++) {
                    if (pieceMap[i][j]!=null){
                        writer.write(String.valueOf(i)+" "+String.valueOf(j)+" "+String.valueOf(pieceMap[i][j].getRank())+" "+String.valueOf(pieceMap[i][j].getOwner()));
                        writer.write("\r\n");
            } } }
            writer.flush();
            writer.close(); }
        catch (Exception e){            Displayer.messageDisplay(e.getMessage());
        }
    }

    /**
     *
     * open a game
     * @param f open file
     */
    public void openGame(File f){
        try{
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);


            p0.setName(br.readLine());
            p1.setName(br.readLine());
            currentTurn = Integer.valueOf(br.readLine());

            cb.newBoard();

            Piece[][] board = cb.newPieceBoard();
            String line = null;
            while((line = br.readLine()) != null){
                StringTokenizer token = new StringTokenizer(line," ");
                int pos1 = Integer.valueOf(token.nextToken());
                int pos2 = Integer.valueOf(token.nextToken());
                int rank = Integer.valueOf(token.nextToken());
                int owner = Integer.valueOf(token.nextToken());
                switch (rank){
                    case 1:
                        board[pos1][pos2] = new Rat(owner);
                        board[pos1][pos2].setPos(pos2,pos1);
                        break;
                    case 2:
                        board[pos1][pos2] = new Cat(owner);
                        board[pos1][pos2].setPos(pos2,pos1);
                        break;
                    case 3:
                        board[pos1][pos2] = new Dog(owner);
                        board[pos1][pos2].setPos(pos2,pos1);
                        break;
                    case 4:
                        board[pos1][pos2] = new Wolf(owner);
                        board[pos1][pos2].setPos(pos2,pos1);
                        break;
                    case 5:
                        board[pos1][pos2] = new Leopard(owner);
                        board[pos1][pos2].setPos(pos2,pos1);
                        break;
                    case 6:
                        board[pos1][pos2] = new Tiger(owner);
                        board[pos1][pos2].setPos(pos2,pos1);
                        break;
                    case 7:
                        board[pos1][pos2] = new Lion(owner);
                        board[pos1][pos2].setPos(pos2,pos1);
                        break;
                    case 8:
                        board[pos1][pos2] = new Elephant(owner);
                        board[pos1][pos2].setPos(pos2,pos1);
                        break;
                }
            }
            br.close();
            this.end = false;
        }
        catch (Exception e){
            Displayer.messageDisplay(e.getMessage());
        }


    }

    /**
     *
     * @return winner (if no winner, return null)
     */
    @Nullable
    public Player getWinner() {
        return winner;
    }

    /**
     *
     * @param x1 selected col
     * @param y1 selected row
     * @param x2 target col
     * @param y2 target row
     * @return true if move is valid
     * @throws Exception if move is invalid
     */
    public boolean move(int x1, int y1, int x2, int y2)throws Exception{
        if (cb.getPiece(x1,y1)==null){throw new Exception("piece not exits");}
        if (cb.getPiece(x1,y1).getOwner() != currentTurn){
            throw new Exception("you can not move other's piece");
        }
        try{
            cb.movePiece(x1, y1, x2, y2);
            checkWinner();
            currentTurn = 1-currentTurn; //to next turn
        }
        catch (Exception e){
            throw e;
        }
        return true;
    }

    /**
     *
     * @return cb: record piece board information
     */
    public CheckerBoard getCheckerBoard(){
        return cb;
    }

    /**
     *
     * @return current turn
     */
    public int getCurrentTurn(){
        return currentTurn;
    }

    /**
     *
     * check is there a winner
     */
    private void checkWinner(){
        if(cb.getPiece(3,0)!=null && cb.getPiece(3,0).getOwner()!=0){
            end = true;
            winner = p1;
        }
        if(cb.getPiece(3,8)!=null && cb.getPiece(3,8).getOwner()!=1){
            end = true;
            winner = p0;
        }
    }

    /**
     *
     * @param id for player
     * @return the player
     */
    public Player getPlayer(int id){
        if (id==0) return p0;
        else return p1;
    }

    /**
     *
     * @return is the game end or not
     */
    public boolean isEnd(){
        return end;
    }

}

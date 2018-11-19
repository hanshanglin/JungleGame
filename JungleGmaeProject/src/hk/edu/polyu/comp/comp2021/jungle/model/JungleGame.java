package hk.edu.polyu.comp.comp2021.jungle.model;


import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;

public class JungleGame {
    private CheckerBoard cb;
    private int currentTurn;
    private Player p0;
    private Player p1;
    private boolean end;
    @Nullable
    private Player winner;
    // 0 for user 0, 1 for user 1

    public JungleGame(){
        currentTurn=0;
        this.cb = new CheckerBoard();
        this.p0 = new Player(0);
        this.p1 = new Player(1);
        winner = null;
    }

    public void newGame(){
        currentTurn = 0;
        cb.newBoard();
        cb.newPieceBoard();
        this.end = false;
    }

    public void saveGame(String path){
        File file = new File(path);
        try{
            file.createNewFile();
            OutputStream os = new FileOutputStream(file);
            OutputStreamWriter writer = new OutputStreamWriter(os, StandardCharsets.UTF_8);
            // creates a FileWriter Object

            //player name
            writer.write(p0.getName());
            writer.write("\r\n");
            writer.write(p1.getName());
            writer.write("\r\n");
            //current turn
            writer.write(String.valueOf(currentTurn));
            writer.write("\r\n");
            //traps
            int[][] map = cb.getBoard();
            if (map[0][2] == -1) writer.write(String.valueOf(1)+" ");
            else writer.write(String.valueOf(0)+" ");
            if (map[0][4] == -1) writer.write(String.valueOf(1)+" ");
            else writer.write(String.valueOf(0)+" ");
            if (map[1][3] == -1) writer.write(String.valueOf(1)+" ");
            else writer.write(String.valueOf(0)+" ");
            if (map[7][3] == -1) writer.write(String.valueOf(1)+" ");
            else writer.write(String.valueOf(0)+" ");
            if (map[8][2] == -1) writer.write(String.valueOf(1)+" ");
            else writer.write(String.valueOf(0)+" ");
            if (map[8][4] == -1) writer.write(String.valueOf(1)+" ");
            else writer.write(String.valueOf(0)+" ");
            writer.write("\r\n");
            //piece
            Piece[][] pieceMap = cb.getPieceBoard();
            for(int i = 0;i<9;i++){
                for (int j = 0; j < 7; j++) {
                    if (pieceMap[i][j]!=null){
                        writer.write(String.valueOf(i)+" "+String.valueOf(j)+" "+String.valueOf(pieceMap[i][j].rank)+" "+String.valueOf(pieceMap[i][j].owner));
                        writer.write("\r\n");
                    }
                }
            }
            writer.flush();
            writer.close();
        }
        catch (Exception e){
            Displayer.messageDisplay(e.getMessage());
        }
    }

    public void openGame(File f){
        try{
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);


            p0.setName(br.readLine());
            p1.setName(br.readLine());
            currentTurn = Integer.valueOf(br.readLine());

            cb.newBoard();
            StringTokenizer token = new StringTokenizer(br.readLine()," ");
            if (token.nextToken().equals("0")) cb.getBoard()[0][2]=0;
            if (token.nextToken().equals("0")) cb.getBoard()[0][4]=0;
            if (token.nextToken().equals("0")) cb.getBoard()[1][3]=0;
            if (token.nextToken().equals("0")) cb.getBoard()[7][3]=0;
            if (token.nextToken().equals("0")) cb.getBoard()[8][2]=0;
            if (token.nextToken().equals("0")) cb.getBoard()[8][4]=0;

            Piece[][] board = cb.loadPieceBoard();
            String line = null;
            while((line = br.readLine()) != null){
                token = new StringTokenizer(line," ");
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

    @Nullable
    public Player getWinner() {
        return winner;
    }

    public boolean move(int x1, int y1, int x2, int y2)throws Exception{
        if (cb.getPiece(x1,y1)==null){
            throw new Exception("piece not exits");
        }
        if (cb.getPiece(x1,y1).owner != currentTurn){
            throw new Exception("you can not move other's piece");
        }
        try{
            cb.movePiece(x1, y1, x2, y2);
            currentTurn = 1-currentTurn; //to next turn
        }
        catch (Exception e){
            throw e;
        }
        finally {
            checkWinner();
        }

        return true;
    }

    public CheckerBoard getCb(){
        return cb;
    }

    public int getCurrentTurn(){
        return currentTurn;
    }

    private void checkWinner(){
        if(cb.getPiece(3,0)!=null && cb.getPiece(3,0).owner!=1){
            end = true;
            winner = p1;
        }
        if(cb.getPiece(3,8)!=null && cb.getPiece(3,8).owner!=0){
            end = true;
            winner = p0;
        }
    }

    public Player getPlayer(int id){
        if (id==0) return p0;
        else return p1;
    }

    public boolean isEnd(){
        return end;
    }

}

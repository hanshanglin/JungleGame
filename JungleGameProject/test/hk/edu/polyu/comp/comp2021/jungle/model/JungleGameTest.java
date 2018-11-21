package hk.edu.polyu.comp.comp2021.jungle.model;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class JungleGameTest {
    private JungleGame game;
    @org.junit.Before
    public void setUp() throws Exception{
        game = new JungleGame();
    }

    @Test
    public void newGameTest(){
        game.newGame();
        assertEquals(false,game.isEnd());
        assertEquals(null,game.getWinner());
        game.getPlayer(0).setName("test1");
        game.getPlayer(1).setName("test2");
        assertSame("test1",game.getPlayer(0).getName());
        assertSame("test2",game.getPlayer(1).getName());
    }

    @Test
    public void saveAndLoadTest1(){
        game.newGame();
        game.getPlayer(0).setName("test1");
        game.getPlayer(1).setName("test2");
        game.saveGame("a");
        JungleGame game1 = new JungleGame();
        game1.openGame(new File("a"));
        assertEquals(game1.getPlayer(0).getName(),game.getPlayer(0).getName());
        assertEquals(game1.getPlayer(1).getName(),game.getPlayer(1).getName());
        int[][] a = game.getCheckerBoard().getBoard();
        int[][] b = game.getCheckerBoard().getBoard();
        assertEquals((Object) a,(Object) b);
        assertEquals(game.getCurrentTurn(),game1.getCurrentTurn());
        Piece[][] c = game.getCheckerBoard().getPieceBoard();
        Piece[][] d = game1.getCheckerBoard().getPieceBoard();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 7; j++) {
                if(c[i][j] == null && d[i][j] == null) continue;
                assertEquals(c[i][j].owner,d[i][j].owner);
                assertEquals(c[i][j].rank,d[i][j].rank);
                assertEquals(c[i][j].x,d[i][j].x);
                assertEquals(c[i][j].y,d[i][j].y);
            }
        }
    }

    @Test
    public void winnerTest1() throws Exception{
        game.newGame();
        //game.getCheckerBoard().getPieceBoard()[1][3] = new Piece(1);
        game.getCheckerBoard().getPieceBoard()[7][3] = new Piece(0);
        game.getCheckerBoard().getPieceBoard()[7][3].setPos(3,7);
        try{
            game.move(3,7,3,8);
            assertEquals(game.getPlayer(0),game.getWinner());

        }catch (Exception e){throw e;}

    }
    @Test
    public void winnerTest2()throws Exception{
        game.newGame();
        //game.getCheckerBoard().getPieceBoard()[1][3] = new Piece(1);
        game.getCheckerBoard().getPieceBoard()[7][3] = new Piece(0);
        game.getCheckerBoard().getPieceBoard()[7][3].setPos(3,7);
        game.getCheckerBoard().getPieceBoard()[1][3] = new Piece(1);
        game.getCheckerBoard().getPieceBoard()[1][3].setPos(3,1);
        try{
            game.move(3,7,3,6);
            game.move(3,1,3,0);
            assertEquals(game.getPlayer(1),game.getWinner());

        }catch (Exception e){throw e;}

    }

    /**
     * move others piece
     * @throws Exception
     */
    @Test(expected = Exception.class)
    public void moveTest1()throws Exception{
        game.newGame();
        game.getCheckerBoard().getPieceBoard()[1][3] = new Piece(1);
        game.getCheckerBoard().getPieceBoard()[1][3].setPos(3,1);
        try{
            game.move(3,1,3,0);
        }catch (Exception e){throw e;}
    }

    /**
     * move null piece
     * @throws Exception
     */
    @Test(expected = Exception.class)
    public void moveTest2()throws Exception{
        game.newGame();
        try{
            game.move(3,1,3,0);
        }catch (Exception e){throw e;}
    }

}
